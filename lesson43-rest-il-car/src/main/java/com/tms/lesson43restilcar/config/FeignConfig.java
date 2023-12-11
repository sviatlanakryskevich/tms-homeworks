package com.tms.lesson43restilcar.config;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tms.lesson43restilcar.dto.exc.StoreFailedException;
import feign.Logger;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.io.IOException;
import java.io.InputStream;

@RequiredArgsConstructor
@Configuration
public class FeignConfig {
    private final ObjectMapper objectMapper;

    @Bean
    public Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
    @Bean
    public ErrorDecoder errorDecoder(){
        return (methodKey, response) -> {
            int status = response.status();
            if (status >= 400 && status < 500) {
                Response.Body body = response.body();
                InputStream inputStream = null;
                try {
                    StoreFailedException storeFailedException = objectMapper.readValue(body.asInputStream(), StoreFailedException.class);
                    return storeFailedException;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return  null;
        };
    }
}
