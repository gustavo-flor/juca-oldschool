package com.github.gustavoflor.juca.usecase.impl;

import com.github.gustavoflor.juca.entity.Wallet;
import com.github.gustavoflor.juca.exception.InsufficientFundsException;
import com.github.gustavoflor.juca.repository.WalletRepository;
import com.github.gustavoflor.juca.usecase.TransferBetweenWalletsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TransferBetweenWalletsUseCaseImpl implements TransferBetweenWalletsUseCase {
    private final WalletRepository walletRepository;

    @Transactional
    @Override
    public void execute(Payload payload) {
        final BigDecimal amount = payload.amount();
        final Wallet from = walletRepository.findByModalityAndCustomerId(payload.from(), payload.customerId())
                .filter(wallet -> wallet.hasEnoughBalance(amount))
                .orElseThrow(InsufficientFundsException::new);
        final Wallet to = walletRepository.findByModalityAndCustomerId(payload.to(), payload.customerId())
                .orElse(Wallet.of(payload.to(), payload.customerId()));
        from.subtractBalance(amount);
        to.addBalance(amount);
        walletRepository.saveAll(List.of(from, to));
    }
}
