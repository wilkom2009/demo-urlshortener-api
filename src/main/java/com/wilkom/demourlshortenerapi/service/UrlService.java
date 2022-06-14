package com.wilkom.demourlshortenerapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wilkom.demourlshortenerapi.dto.UrlDto;
import com.wilkom.demourlshortenerapi.model.Url;
import com.wilkom.demourlshortenerapi.repository.UrlRepository;
import com.wilkom.demourlshortenerapi.utils.UtilClass;

@Service
public class UrlService {
    @Autowired
    UrlRepository urlRepository;

    /**
     * Persist the UrlRequestDto object into the db
     * 
     * @param rootUrl
     * @param dto
     * @return a the created shortened code to append to api hostname to get
     *         shortened URL
     */
    public String save(UrlDto dto) {

        Url url = urlRepository.save(new Url(0, dto.getUrl(),
                UtilClass.generateHashCode(dto.getUrl())));

        return url.getShortenedCode();
    }

    /**
     * Get origin URL from shortened URL
     * 
     * @param shortenedCode
     * @return the Original URL
     */
    public String getOriginalUrl(String shortenedCode) {
        Optional<Url> optUrl = urlRepository.findByShortenedCode(shortenedCode);
        if (optUrl.isEmpty()) {
            return null;
        }
        return optUrl.get().getOriginUrl();
    }
}
