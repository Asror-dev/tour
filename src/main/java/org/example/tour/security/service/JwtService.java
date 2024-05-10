package org.example.tour.security.service;



import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import org.springframework.http.ResponseEntity;

import javax.crypto.SecretKey;

public interface JwtService {
    String generateJwt(String id);
    String generateRefreshJwt(String id);
    SecretKey signWithKey();
    SecretKey signWithKeyRefresh();
    Jws<Claims> extractJwt(String jwt);

    ResponseEntity<?> refreshToken(String refreshToken);
}
