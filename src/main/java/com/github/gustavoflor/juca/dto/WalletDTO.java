package com.github.gustavoflor.juca.dto;

import com.github.gustavoflor.juca.entity.Modality;
import com.github.gustavoflor.juca.entity.Wallet;

import java.math.BigDecimal;

public record WalletDTO(Long id, BigDecimal balance, Modality modality) {
    public static WalletDTO of(final Wallet wallet) {
        return new WalletDTO(wallet.getId(), wallet.getBalance(), wallet.getModality());
    }
}
