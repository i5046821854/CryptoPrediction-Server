package com.capstone.crypto.dto;

import com.capstone.crypto.domain.CryptoCurrency;
import com.capstone.crypto.domain.CryptoPrice;
import lombok.Data;

import javax.persistence.*;

@Data
public class CryptoResponseDto {

    private Long cryptoId;
    private Long priceId;
    private String name;
    private String name_kor;
    private Long price;
    private String dateTime;

    public CryptoResponseDto(Long cryptoId, Long priceId, String name, String name_kor, Long price, String dateTime) {
        this.cryptoId = cryptoId;
        this.priceId = priceId;
        this.name = name;
        this.name_kor = name_kor;
        this.price = price;
        this.dateTime = dateTime;
    }

    public static CryptoResponseDto from(CryptoCurrency currency, CryptoPrice price) {
        return new CryptoResponseDto(currency.getCryptoId(),
                price.getPriceId(),
                currency.getNameEng(),
                currency.getNameKor(),
                price.getPrice(),
                price.getDateTime());
    }
}
