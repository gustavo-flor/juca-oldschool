package com.github.gustavoflor.juca.event;

import com.github.gustavoflor.juca.entity.Modality;
import com.github.gustavoflor.juca.usecase.RequestTransferBetweenWalletsUseCase;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

@Builder
public record TransferBetweenWalletsRequestedEvent(BigDecimal amount,
                                                   Modality from,
                                                   Modality to,
                                                   Long customerId,
                                                   LocalDateTime occurredAt) implements Event {
    public static final String BINDING_NAME = "TransferRequestedEvent";

    @Override
    public String bindingName() {
        return BINDING_NAME;
    }

    @Override
    public Object partitionKey() {
        return customerId();
    }

    public static TransferBetweenWalletsRequestedEvent of(RequestTransferBetweenWalletsUseCase.Payload payload) {
        return TransferBetweenWalletsRequestedEvent.builder()
                .amount(payload.amount())
                .from(payload.from())
                .to(payload.to())
                .customerId(payload.customerId())
                .occurredAt(now())
                .build();
    }
}
