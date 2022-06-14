package com.wilkom.demourlshortenerapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wilkom.demourlshortenerapi.model.Url;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {
    /**
     * Find URL by a provided shortenedCode
     * 
     * @param shortenedCode
     * @return Optional URL object
     */
    Optional<Url> findByShortenedCode(String shortenedCode);
}
