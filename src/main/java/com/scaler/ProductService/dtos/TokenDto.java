package com.scaler.ProductService.dtos;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TokenDto {

    private String tokenValue;
    private Date expiryAt;
    private String email;


    public String getTokenValue() {
        return tokenValue;
    }

    public void setTokenValue(String tokenValue) {
        this.tokenValue = tokenValue;
    }

    public Date getExpiryAt() {
        return expiryAt;
    }

    public void setExpiryAt(Date expiryAt) {
        this.expiryAt = expiryAt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
