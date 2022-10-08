package com.capstone.crypto.dto;

import lombok.Data;

@Data
public class CryptoPriceResponseDto {
    int priceId;
    float open;
    float high;
    float low;
    float close;
    float volume;
    String time;

    public CryptoPriceResponseDto(int priceId, float open, float high, float low, float close, float volume, String time) {
        this.priceId = priceId;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
        this.time = time;
    }
}
