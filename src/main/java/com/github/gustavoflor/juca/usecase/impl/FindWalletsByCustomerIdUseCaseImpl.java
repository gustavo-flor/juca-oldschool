package com.github.gustavoflor.juca.usecase.impl;

import com.github.gustavoflor.juca.dto.WalletDTO;
import com.github.gustavoflor.juca.repository.WalletRepository;
import com.github.gustavoflor.juca.usecase.FindWalletsByCustomerIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FindWalletsByCustomerIdUseCaseImpl implements FindWalletsByCustomerIdUseCase {
    private final WalletRepository walletRepository;

    @Transactional(readOnly = true)
    @Override
    public List<WalletDTO> execute(final Long customerId) {
        return walletRepository.findAllByCustomerId(customerId)
                .stream()
                .map(WalletDTO::of)
                .toList();
    }
}
