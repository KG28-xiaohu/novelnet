package com.novelnet.demo.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

/**
 * JWT工具类
 * 生成和解析token
 */
public class TokenUtil {
    //密钥：可自定义，字符串，也可配置在配置文件中
    private static final String secret = "tokenKey";

    /**
     * 生成token
     */
    public static String makeToken(Map<String, Object> claim){
        //设置过期时间
        Date date = new Date(System.currentTimeMillis() + 1000*20);
        //生成token
        return Jwts.builder().setExpiration(date)   //自定义载荷（内容）
                .setClaims(claim)   //设置过期时间
                .signWith(SignatureAlgorithm.ES256, secret) //使用HS256算法和密钥
                .compact();   //生成token
    }

    /**
     * 解析token
     */
    public static Claims parseToken(String token){
        //解析token的方法
        return Jwts.parser().setSigningKey(secret)   //设置密钥
                .parseClaimsJws(token)     //设置需要解析的token
                .getBody();     //拿到载荷
    }
}
