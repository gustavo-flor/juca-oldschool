package com.github.gustavoflor.juca.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "wallets")
@Getter
@Setter
@Builder(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "balance")
    private BigDecimal balance;

    @Column(name = "modality")
    @Enumerated(EnumType.STRING)
    private Modality modality;

    @Column(name = "customer_id")
    private Long customerId;

    public void addBalance(final BigDecimal value) {
        setBalance(getBalance().add(value));
    }

    public void subtractBalance(final BigDecimal value) {
        setBalance(getBalance().subtract(value));
    }

    public boolean hasEnoughBalance(final BigDecimal value) {
        return getBalance().compareTo(value) >= 0;
    }

    public static Wallet of(final Modality modality, final Long customerId) {
        return Wallet.builder()
                .balance(BigDecimal.ZERO)
                .modality(modality)
                .customerId(customerId)
                .build();
    }

    public static Wallet of(final BigDecimal balance, final Modality modality, final Long customerId) {
        return Wallet.builder()
                .balance(balance)
                .modality(modality)
                .customerId(customerId)
                .build();
    }
}
