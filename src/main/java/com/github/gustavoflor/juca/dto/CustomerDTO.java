package com.github.gustavoflor.juca.dto;

import com.github.gustavoflor.juca.entity.Customer;

public record CustomerDTO(Long id, String name) {
    public static CustomerDTO of(final Customer customer) {
        return new CustomerDTO(customer.getId(), customer.getName());
    }
}
