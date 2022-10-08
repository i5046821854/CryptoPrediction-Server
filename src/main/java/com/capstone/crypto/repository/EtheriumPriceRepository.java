package com.capstone.crypto.repository;

import com.capstone.crypto.domain.CryptoCurrency;
import com.capstone.crypto.domain.Etherium_Price;
import com.capstone.crypto.domain.bitCoin_Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface EtheriumPriceRepository extends JpaRepository<Etherium_Price, Long> {

    List<Etherium_Price> findAll();
}
