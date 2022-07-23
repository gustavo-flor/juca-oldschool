package com.github.gustavoflor.juca.usecase.impl;

import com.github.gustavoflor.juca.event.TransferBetweenWalletsRequestedEvent;
import com.github.gustavoflor.juca.event.publisher.EventPublisher;
import com.github.gustavoflor.juca.usecase.RequestTransferBetweenWalletsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RequestTransferBetweenWalletsUseCaseImpl implements RequestTransferBetweenWalletsUseCase {
    private final EventPublisher eventPublisher;

    @Override
    public void execute(final Payload payload) {
        eventPublisher.send(TransferBetweenWalletsRequestedEvent.of(payload));
    }
}
