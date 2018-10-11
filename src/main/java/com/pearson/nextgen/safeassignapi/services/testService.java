package com.pearson.nextgen.safeassignapi.services;

import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

@Service
public class testService {

    @PostConstruct
    private String generateJwtToken() {
        String token = Jwts.builder().setSubject("adam")
                .setExpiration(new Date(2019, 1, 1))
//                .setIssuer("info@wstutorial.com")
//                .claim("groups", new String[] { "user", "admin" })
                // HMAC using SHA-512  and 12345678 base64 encoded
                .signWith(SignatureAlgorithm.HS512, "MTIzNDU2Nzg=").compact();
        System.out.println(token);
        return token;
    }

}
