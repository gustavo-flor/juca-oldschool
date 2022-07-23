package com.github.gustavoflor.juca.event.publisher.impl;

import com.github.gustavoflor.juca.event.Event;
import com.github.gustavoflor.juca.event.publisher.EventPublisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class EventPublisherImpl implements EventPublisher {
    private static final String PARTITION_KEY_HEADER_NAME = "partitionKey";

    private final StreamBridge streamBridge;

    @Override
    public void send(Event event) {
        final var message = MessageBuilder.withPayload(event)
                .setHeader(PARTITION_KEY_HEADER_NAME, event.partitionKey())
                .build();
        streamBridge.send(event.outBindingName(), message);
        log.info("Event sent to {}", event.outBindingName());
    }
}
