package com.capstone.crypto.service;

import com.capstone.crypto.domain.CryptoCurrency;
import com.capstone.crypto.domain.CryptoPrice;
import com.capstone.crypto.domain.Etherium_Price;
import com.capstone.crypto.domain.bitCoin_Price;
import com.capstone.crypto.dto.CryptoPriceResponseDto;
import com.capstone.crypto.dto.CryptoResponseDto;
import com.capstone.crypto.repository.BitcoinPriceRepository;
import com.capstone.crypto.repository.CryptoCurrencyRepository;
import com.capstone.crypto.repository.CryptoPriceRepository;
import com.capstone.crypto.repository.EtheriumPriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class CryptoService {

    private final CryptoCurrencyRepository cryptoCurrencyRepository;
    private final CryptoPriceRepository cryptoPriceRepository;
    private final BitcoinPriceRepository bitcoinPriceRepository;
    private final EtheriumPriceRepository etheriumPriceRepository;

    public List<CryptoResponseDto> getPrices(String name) {
        Optional<CryptoCurrency> crypto = cryptoCurrencyRepository.findByNameEng(name);
        if(!crypto.isPresent())
            throw new IllegalArgumentException("해당하는 가상화폐가 존재하지 않습니다");
        CryptoCurrency cryptoCurrency = crypto.get();
        List<CryptoPrice> prices = cryptoPriceRepository.findByCryptoCurrency(cryptoCurrency);
        List<CryptoResponseDto> dto = new ArrayList<CryptoResponseDto>();
        for(CryptoPrice price : prices)
            dto.add(CryptoResponseDto.from(cryptoCurrency, price));
        return dto;
    }

    public List<CryptoPriceResponseDto> getRealPrices(int time , String cryptoName) {
        Optional<CryptoCurrency> crypto = cryptoCurrencyRepository.findByNameEng(cryptoName);
        List<CryptoPriceResponseDto> prices = new ArrayList<CryptoPriceResponseDto>();
        if(!crypto.isPresent())
            throw new IllegalArgumentException("해당하는 가상화폐가 존재하지 않습니다");
        if(crypto.get().getCryptoId() == 2){
            List<bitCoin_Price> all = bitcoinPriceRepository.findByTime1(time);
            for(bitCoin_Price bitcoin : all)
                prices.add(bitcoin.toDTO());
        }
        else {
            List<Etherium_Price> all = etheriumPriceRepository.findByTime1(time);
            for(Etherium_Price ether : all)
                prices.add(ether.toDTO());
        }
        return prices;
    }

//    public List<CryptoResponseDto> getPrices(Long cryptoId) {
//
//        prices.stream().map()
//    }
}
