package com.liang.ladataplatform.config.ws;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author liang
 * @version 1.0.0
 * @date 2024/11/28 09:22
 */
@Component
@Slf4j
public class SshWebsocketHandler extends TextWebSocketHandler {

    private static final JSch jSch = new JSch();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {

        log.info("ssh websocket 连接成功: {}", session.getRemoteAddress());
        // 建立 WebSocket 连接后，启动 SSH 会话
        new Thread(() -> {
            try {
                initSession(session);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    private static void initSession(WebSocketSession session) throws JSchException, IOException {
        Session sshSession = jSch.getSession("root", "172.30.1.160", 22);
        sshSession.setPassword("Bmos1018.com");
        sshSession.setConfig("StrictHostKeyChecking", "no");
        sshSession.connect(5000);
        Channel channel = sshSession.openChannel("shell");
        channel.connect();
        InputStream inputStream = channel.getInputStream();
        OutputStream outputStream = channel.getOutputStream();

        // 启动读取线程
        new Thread(() -> {
            try {
                byte[] buffer = new byte[1024];
                int len;
                while ((len = inputStream.read(buffer)) != -1) {
                    String output = new String(buffer, 0, len);
                    session.sendMessage(new TextMessage(output));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        // 等待 WebSocket 消息并写入到 SSH
        while (session.isOpen()) {
            TextMessage message = (TextMessage) session.getAttributes().get("message");
            if (message != null) {
                outputStream.write((message.getPayload() + "\n").getBytes());
                outputStream.flush();
                session.getAttributes().remove("message");
            }
        }

        // 关闭资源
        channel.disconnect();
        sshSession.disconnect();
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        session.getAttributes().put("message", message);
    }
}
