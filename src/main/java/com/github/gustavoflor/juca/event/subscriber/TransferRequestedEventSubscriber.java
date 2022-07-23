package com.github.gustavoflor.juca.event.subscriber;

import com.github.gustavoflor.juca.event.TransferBetweenWalletsRequestedEvent;
import com.github.gustavoflor.juca.usecase.TransferBetweenWalletsUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Slf4j
@Component(TransferBetweenWalletsRequestedEvent.BINDING_NAME)
@RequiredArgsConstructor
public class TransferRequestedEventSubscriber implements Consumer<TransferBetweenWalletsRequestedEvent> {
    private final TransferBetweenWalletsUseCase transferBetweenWalletsUseCase;

    @Override
    public void accept(TransferBetweenWalletsRequestedEvent event) {
        log.info("Event received from {}", TransferBetweenWalletsRequestedEvent.BINDING_NAME);
        final var payload = TransferBetweenWalletsUseCase.Payload.builder()
                .customerId(event.customerId())
                .from(event.from())
                .to(event.to())
                .amount(event.amount())
                .build();
        transferBetweenWalletsUseCase.execute(payload);
    }
}
