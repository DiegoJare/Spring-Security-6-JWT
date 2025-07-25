package com.dijar.springsecurityjwt.security.jwt;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
@ConfigurationProperties(prefix = "jwt") // buscara en el yml el prefijo jwt
public class JwtProperties {

    private String secret;
    private long expiration;

}
