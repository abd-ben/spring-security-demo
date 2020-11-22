package com.spmia.chapterone.chapterone.jwt;

import com.google.common.net.HttpHeaders;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Configuration
public class JwtConfig {

    @Value("${app.jwt.secretKey}")
    private String secretKey;
    @Value("${app.jwt.tokenPrefix}")
    private String tokenPrefix;

    public String getAuthorizationHeader() {
        return HttpHeaders.AUTHORIZATION;
    }
}
