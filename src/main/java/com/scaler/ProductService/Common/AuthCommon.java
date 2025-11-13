package com.scaler.ProductService.Common;

import com.scaler.ProductService.dtos.TokenDto;
import com.scaler.ProductService.exception.InvalidTokenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class AuthCommon {

    private static RestTemplate restTemplate;

    public AuthCommon(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public static boolean authTokenValidation(String tokenValue) throws InvalidTokenException {

        if(tokenValue == null){
            return false;
        }
        ResponseEntity<TokenDto> token = null;
        try{

            String url = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/user/validateToken")
                    .queryParam("tokenValue", tokenValue)
                    .toUriString();

            token = restTemplate.getForEntity(url,TokenDto.class);
        }catch (HttpClientErrorException ex){
            if(ex.getStatusCode() == HttpStatus.UNAUTHORIZED)
                throw new InvalidTokenException("Invalid Token");
            else
                throw new InvalidTokenException("Bad request");
        }

        return true;

    }
}
