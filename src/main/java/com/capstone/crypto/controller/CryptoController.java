package com.capstone.crypto.controller;

import com.capstone.crypto.domain.CryptoCurrency;
import com.capstone.crypto.dto.ArticlesDto;
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

    @GetMapping("/news/{type}")
    public List<ArticlesDto> getArticles(@PathVariable int type)
    {
        return cryptoService.getArticles(type);
    }

    @GetMapping("/news/{date}/{type}")
    public List<ArticlesDto> getArticles(@PathVariable int type, @PathVariable String date) {
        return cryptoService.getArticlesWithDate(type, date);
    }

    @GetMapping("/real/{time}/{cryptoName}")
    public List<CryptoPriceResponseDto> getRealPrices(@PathVariable int time, @PathVariable String cryptoName)
    {
        System.out.println(cryptoName);
        return cryptoService.getRealPrices(time , cryptoName);
    }
}
