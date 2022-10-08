package com.capstone.crypto.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "CryptoCurrency")
@NoArgsConstructor
public class CryptoCurrency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cryptoId;

    @Column(nullable = false , name = "name_eng")
    private String nameEng;

    @Column(nullable = false, name = "name_kor")
    private String nameKor;

    @OneToMany(mappedBy = "cryptoCurrency", cascade = CascadeType.ALL) private final Set<CryptoPrice> crpytoPrices = new LinkedHashSet<>();

    public CryptoCurrency(Long id, String name_eng, String name_kor) {
        this.cryptoId = id;
        this.nameEng = name_eng;
        this.nameKor = name_kor;
    }
}
