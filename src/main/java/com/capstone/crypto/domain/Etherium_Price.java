package com.capstone.crypto.domain;

import com.capstone.crypto.dto.CryptoPriceResponseDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@Table(name = "price_etherium")
public class Etherium_Price {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) int priceId;
    @Column(nullable = false) float open;
    @Column(nullable = false) float high;
    @Column(nullable = false) float low;
    @Column(nullable = false) float close;
    @Column(nullable = false) float volume;
    @Column(nullable = false)  String time;
    @Column(nullable = false)  Integer time1;

    public Etherium_Price(int priceId, float open, float high, float low, float close, float volume, String time) {
        this.priceId = priceId;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
        this.time = time;
    }

    public CryptoPriceResponseDto toDTO()
    {
        return new CryptoPriceResponseDto(this.priceId, this.open, this.high, this.low, this.close, this.volume, this.time);
    }
}
