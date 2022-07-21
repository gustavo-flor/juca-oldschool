package com.github.gustavoflor.juca.request;

import com.github.gustavoflor.juca.Modality;

import java.math.BigDecimal;

public record TransferRequestBody(BigDecimal amount, Modality from, Modality to) {
}
