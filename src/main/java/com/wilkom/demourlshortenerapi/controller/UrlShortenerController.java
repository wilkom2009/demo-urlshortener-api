package com.wilkom.demourlshortenerapi.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.wilkom.demourlshortenerapi.dto.UrlDto;
import com.wilkom.demourlshortenerapi.service.UrlService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "UrlShortenerController", description = "REST API controller to expose endpoints to shorten and verify url!!!!")
@RestController
@Validated
public class UrlShortenerController {

    @Autowired
    private UrlService urlService;

    /**
     * Endpoint to get the original URL format from a short URL
     * 
     * @param url
     * @return Redirect
     */
    @ApiOperation(value = "Finds original url from short url and automatically redirects", notes = "Finds original url from short url and automatically redirects")
    @GetMapping("/{urlcode}")
    public ResponseEntity<?> getOriginUrl(@PathVariable String urlcode) {
        String originUrl = urlService.getOriginalUrl(urlcode);
        if (originUrl.isEmpty()) {
            return new ResponseEntity<>("Origin URL not found for : " + urlcode, HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(originUrl))
                .build();
    }

    /**
     * Generate a shortened URL from a long format URL
     * 
     * @param dto
     * @return UrlRequestDto with shortened URL as data
     */
    @ApiOperation(value = "Shorten long url into short url", notes = "Shorten long url to short url")
    @PostMapping("/")
    public ResponseEntity<?> shortenUrl(@Valid @RequestBody UrlDto dto) {
        String uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString();
        String shortCode = urlService.save(dto);

        return new ResponseEntity<>(new UrlDto(uri.concat(shortCode)), HttpStatus.CREATED);
    }
}