package com.liang.ladataplatform.config.ws;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

/**
 * @author liang
 * @version 1.0.0
 * @date 2024/11/28 09:22
 */
@Component
@Slf4j
public class SshWebsocketHandler extends TextWebSocketHandler {

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        log.info("ssh websocket 连接成功: {}", session.getRemoteAddress());
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        super.handleTextMessage(session, message);
    }

    public static void main(String[] args) throws Exception {
        JSch jSch = new JSch();
        Session session = jSch.getSession("root", "172.30.1.160", 22);
        session.setPassword("Bmos1018.com");
        session.setConfig("StrictHostKeyChecking", "no");
        session.connect(5000);
        Channel channel = session.openChannel("shell");
        channel.connect();
        InputStream inputStream = channel.getInputStream();
        OutputStream outputStream = channel.getOutputStream();
        new Thread(() -> {
            try {
                while (true) {
                    byte[] bytes = new byte[1024];
                    int read = inputStream.read(bytes);
                    if (read < 0) break;
                    System.out.print(new String(bytes, 0, read));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                Scanner scanner = new Scanner(System.in);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    outputStream.write((line + "\n").getBytes());
                    outputStream.flush();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }).start();
    }
}
