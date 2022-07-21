package com.github.gustavoflor.juca.controller;

import com.github.gustavoflor.juca.dto.WalletDTO;
import com.github.gustavoflor.juca.request.TransferRequestBody;
import com.github.gustavoflor.juca.usecase.FindWalletsByCustomerIdUseCase;
import com.github.gustavoflor.juca.usecase.TransferBetweenWalletsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers/{customerId}/wallets")
@RequiredArgsConstructor
public class WalletController {
    private final FindWalletsByCustomerIdUseCase findWalletsByCustomerIdUseCase;
    private final TransferBetweenWalletsUseCase transferBetweenWalletsUseCase;

    @GetMapping
    public List<WalletDTO> findAll(@PathVariable final Long customerId) {
        return findWalletsByCustomerIdUseCase.execute(customerId);
    }

    @PostMapping("/transfer")
    public void transfer(@PathVariable final Long customerId, @RequestBody final TransferRequestBody body) {
        final TransferBetweenWalletsUseCase.Payload payload = TransferBetweenWalletsUseCase.Payload.builder()
                .amount(body.amount())
                .from(body.from())
                .to(body.to())
                .customerId(customerId)
                .build();
        transferBetweenWalletsUseCase.execute(payload);
    }
}
