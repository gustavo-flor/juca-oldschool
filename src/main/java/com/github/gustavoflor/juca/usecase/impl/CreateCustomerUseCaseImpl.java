package com.github.gustavoflor.juca.usecase.impl;

import com.github.gustavoflor.juca.entity.Modality;
import com.github.gustavoflor.juca.dto.CustomerDTO;
import com.github.gustavoflor.juca.entity.Customer;
import com.github.gustavoflor.juca.entity.Wallet;
import com.github.gustavoflor.juca.repository.CustomerRepository;
import com.github.gustavoflor.juca.repository.WalletRepository;
import com.github.gustavoflor.juca.usecase.CreateCustomerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CreateCustomerUseCaseImpl implements CreateCustomerUseCase {
    private static final BigDecimal ONE_HUNDRED = new BigDecimal("100");

    private final CustomerRepository customerRepository;
    private final WalletRepository walletRepository;

    @Transactional
    @Override
    public CustomerDTO execute(Payload payload) {
        final Customer customer = customerRepository.save(Customer.of(payload));
        final Wallet food = Wallet.of(ONE_HUNDRED, Modality.FOOD, customer.getId());
        final Wallet health = Wallet.of(ONE_HUNDRED, Modality.HEALTH, customer.getId());
        final Wallet mobility = Wallet.of(ONE_HUNDRED, Modality.MOBILITY, customer.getId());
        walletRepository.saveAll(List.of(food, health, mobility));
        return CustomerDTO.of(customer);
    }
}
