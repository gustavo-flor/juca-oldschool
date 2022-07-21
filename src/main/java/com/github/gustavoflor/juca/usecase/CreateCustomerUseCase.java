package com.github.gustavoflor.juca.usecase;

import com.github.gustavoflor.juca.dto.CustomerDTO;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

public interface CreateCustomerUseCase {
    @Validated
    CustomerDTO execute(@Valid Payload payload);

    record Payload(@NotBlank String name) {
    }
}
