package com.capstone.crypto.repository;

import com.capstone.crypto.domain.CryptoCurrency;
import com.capstone.crypto.domain.bitCoin_Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface BitcoinPriceRepository extends JpaRepository<bitCoin_Price, Long> {

    List<bitCoin_Price> findAll();
    List<bitCoin_Price> findByTime1(int time);
}
