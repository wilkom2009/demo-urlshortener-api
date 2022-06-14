package com.wilkom.demourlshortenerapi.dto;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.URL;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class to handle url shortener request/response body from/to client
 * 
 * @author Wilson
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UrlDto {
    @URL(message = "Invalid url format")
    @NotEmpty(message = "URL must not be empty")
    private String url;

}
