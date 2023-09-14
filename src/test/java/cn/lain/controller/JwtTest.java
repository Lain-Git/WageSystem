package cn.lain.controller;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Jwt令牌的生成与校验
 */
//@SpringBootTest
public class JwtTest {

    @Test
    public void testJwt() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("username", "000001");
        claims.put("adminname", "lain");

        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "lain") // 设置签名算法 HS256
                .setClaims(claims) // 自定义内容（载荷）
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000)) // 设置令牌有效期 1h
                .compact();
        System.out.println(jwt);
    }

    @Test
    public void testParseJwt() {
        Claims claims = Jwts.parser()
                .setSigningKey("lain") // 签名密钥, 所设置的字符串
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJhZG1pbm5hbWUiOiJsYWluIiwiaWQiOjEsImV4cCI6MTY5MTYyOTA3MiwidXNlcm5hbWUiOiIwMDAwMDEifQ.xqSwKPMDiY_9gZnR44o0V8lXjshMk3WTWMhxdYElRYQ")
                .getBody();
        System.out.println(claims);
    }

}
