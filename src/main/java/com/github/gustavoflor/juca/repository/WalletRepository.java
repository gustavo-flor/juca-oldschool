package com.github.gustavoflor.juca.repository;

import com.github.gustavoflor.juca.Modality;
import com.github.gustavoflor.juca.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {
    List<Wallet> findAllByCustomerId(Long customerId);

    Optional<Wallet> findByModalityAndCustomerId(Modality modality, Long customerId);
}
