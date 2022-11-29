package com.capstone.crypto.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "cryptoPrice")
@NoArgsConstructor
public class CryptoPrice {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long priceId;
    @ManyToOne(optional = false) @JoinColumn(name = "cryptoId") private CryptoCurrency cryptoCurrency;
    @Column(nullable = false) private Float price;
    @Column(nullable = false) private String dateTime;

    public CryptoPrice(Long priceId, CryptoCurrency cryptoCurrency, Float price, String dateTime) {
        this.priceId = priceId;
        this.cryptoCurrency = cryptoCurrency;
        this.price = price;
        this.dateTime = dateTime;
    }
}
