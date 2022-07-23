package com.github.gustavoflor.juca.usecase;

import com.github.gustavoflor.juca.entity.Modality;
import lombok.Builder;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public interface RequestTransferBetweenWalletsUseCase {
    void execute(Payload payload);

    @Builder
    record Payload(@Positive @Digits(integer = 15, fraction = 2) BigDecimal amount,
                   @NotNull Modality from,
                   @NotNull Modality to,
                   @NotNull Long customerId) {
        @AssertFalse
        public boolean isToTheSameModality() {
            return from() == to();
        }
    }
}
