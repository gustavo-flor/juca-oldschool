package com.github.gustavoflor.juca.entity;

import com.github.gustavoflor.juca.usecase.CreateCustomerUseCase;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "customers")
@Getter
@Setter
@Builder(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    public static Customer of(final CreateCustomerUseCase.Payload payload) {
        return Customer.builder()
                .name(payload.name())
                .build();
    }
}
