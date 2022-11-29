package com.capstone.crypto.repository;

import com.capstone.crypto.dto.ArticlesDto;
import com.capstone.crypto.dto.CryptoResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource
public interface ArticleRepository extends JpaRepository<ArticlesDto, Integer> {
    List<ArticlesDto> findByType(int cryptoType);
    List<ArticlesDto> findByTypeAndDateStartsWith(int cryptoType, String date);
}
