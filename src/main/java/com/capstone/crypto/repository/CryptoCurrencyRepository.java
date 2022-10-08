package com.capstone.crypto.repository;

import com.capstone.crypto.domain.CryptoCurrency;
import com.capstone.crypto.domain.CryptoPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface CryptoCurrencyRepository extends JpaRepository<CryptoCurrency, Long> {

    Optional<CryptoCurrency> findByNameEng(String name);
}
