package com.capstone.crypto.repository;

import com.capstone.crypto.domain.CryptoCurrency;
import com.capstone.crypto.domain.CryptoPrice;
import com.capstone.crypto.dto.CryptoPriceResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface CryptoPriceRepository extends JpaRepository<CryptoPrice, Long> {

    List<CryptoPrice> findByCryptoCurrency(CryptoCurrency cryptoCurrency);

}
