package com.tiny.core.crm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;

/**
 * @author wangzb
 * @version 1.0
 * @date 2020/12/29
 */
@SpringBootApplication
@EnableBinding({Sink.class, Source.class})
public class ProduceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProduceApplication.class,args);
    }
}
