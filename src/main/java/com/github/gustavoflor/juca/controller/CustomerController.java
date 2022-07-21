package com.github.gustavoflor.juca.controller;

import com.github.gustavoflor.juca.dto.CustomerDTO;
import com.github.gustavoflor.juca.usecase.CreateCustomerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CreateCustomerUseCase createCustomerUseCase;

    @PostMapping
    public CustomerDTO create(@RequestBody CreateCustomerUseCase.Payload payload) {
        return createCustomerUseCase.execute(payload);
    }
}
