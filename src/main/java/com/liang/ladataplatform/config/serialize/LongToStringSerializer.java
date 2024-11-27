package com.liang.ladataplatform.config.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * @author liang
 * @version 1.0.0
 * @date 2024/11/27 17:09
 */
public class LongToStringSerializer extends JsonSerializer<Long> {

    @Override
    public void serialize(Long aLong, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (aLong != null){
            jsonGenerator.writeString(aLong.toString());
        }
    }
}
