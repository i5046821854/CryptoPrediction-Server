package com.capstone.crypto.controller;

import com.capstone.crypto.domain.CryptoCurrency;
import com.capstone.crypto.dto.CryptoPriceResponseDto;
import com.capstone.crypto.dto.CryptoResponseDto;
import com.capstone.crypto.service.CryptoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CryptoController {

    private final CryptoService cryptoService;

    @GetMapping("/{cryptoName}")
    public List<CryptoResponseDto> getPrices(@PathVariable String cryptoName)
    {
        System.out.println(cryptoName);
        return cryptoService.getPrices(cryptoName);
    }

    @GetMapping("/real/{cryptoName}")
    public List<CryptoPriceResponseDto> getRealPrices(@PathVariable String cryptoName)
    {
        System.out.println(cryptoName);
        return cryptoService.getRealPrices(cryptoName);
    }
}
