package com.tiny.core.erp.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @author wangzb
 * @version 1.0
 * @date 2020/12/30
 */
@Component
@Slf4j
public class SourceMessageListener {
    @StreamListener(Sink.INPUT)
    public void onMessage(@Payload String message) {
        log.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);
    }
}
