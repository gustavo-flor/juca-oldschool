package com.github.gustavoflor.juca.usecase;

import com.github.gustavoflor.juca.dto.WalletDTO;

import java.util.List;

public interface FindWalletsByCustomerIdUseCase {
    List<WalletDTO> execute(Long customerId);
}
