package com.example.basedemo.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator.Builder;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.UnsupportedEncodingException;
import java.util.*;

@Component
@Data
public class JWTService {

    /*
       jwt共分为三段：分别是头部，负载，签名
        头部用密匙secret加密lalg和tyo字段
        负载用密匙secret加密公有负载和私有负载
        签名用密匙secret将 加密后的头部和负载拼接字符串 进行加密
     */


    /*
    公有负载：jwt的builder内置的参数
    私有负荷：自定义名字的参数，需要<key，value>形式
    此处负荷规则是：
        公有负荷：Payload的六个参数
        私有负荷：Payload中的六个参数（再存一次）+ 调用方自定义加入的参数对（demo中加入了username）
     */

    private String secret = "klchen_cuit_mySecret";//密匙
    //以下三项为 公有负载内容
    private String issuer = "klchen";//发布者
    private String subject = "userLoginToken";//主题
    private String audience = "commonUser";//签名的观众 也可以理解谁接受签名的
    private Map<String, String> claims;//私有负载

    /**
     * 创建 hour小时后过期的Token
     *
     * @param claims
     * @param hour
     * @return
     */
    public String createToken(Map<String, String> claims, int hour) throws UnsupportedEncodingException {
        Payload createPayload = this.createPayload(hour);//封装公有负载
        createPayload.setClaims(claims);//封装私有负载
        Algorithm hmac256 = Algorithm.HMAC256(this.getSecret());//构建密匙信息
        return createToken(createPayload, hmac256);
    }

    /**
     * 根据负载和算法创建Token
     *
     * @param payload
     * @param algorithm
     * @return
     */
    public String createToken(Payload payload, Algorithm algorithm) {

        Builder headBuilder = createHeaderBuilder(algorithm);//头部加密
        Builder publicClaimbuilder = addPublicClaimBuilder(headBuilder, payload);//公有负载加密
        Builder privateClaimbuilder = addPrivateClaimbuilder(publicClaimbuilder, payload);//私有负载加密
        String token = privateClaimbuilder.sign(algorithm);//生成签名
        return token;
    }

    /**
     * 创建自定小时后过期的负载
     *
     * @param hour
     * @return
     */
    public Payload createPayload(int hour) {
        Payload payload = new Payload();
        payload.setIssuer(this.getIssuer());
        payload.setSubject(this.getSubject());
        payload.setAudience(this.getAudience());
        this.setIssuedAtAndExpiresAt(new Date(), hour, payload);
        return payload;
    }

    /**
     * 创建自定小时后过期的负载
     *
     * @param hour
     * @return
     */
    public Payload createPayload(String issuer, String subject, String audience, Date date, int hour) {
        Payload payload = new Payload();
        payload.setIssuer(issuer);
        payload.setSubject(subject);
        payload.setAudience(audience);
        this.setIssuedAtAndExpiresAt(date, hour, payload);
        return payload;
    }

    /**
     * 添加私有声明
     *
     * @param builder
     * @param payload
     * @return
     */
    private Builder addPrivateClaimbuilder(Builder builder, Payload payload) {
        Map<String, String> claims = payload.getClaims();
        if (!CollectionUtils.isEmpty(claims)) {
            claims.forEach((k, v) -> {
                builder.withClaim(k, (String) v);
            });
        }
        return builder;
    }

    /**
     * 添加公共声明
     *
     * @param builder
     * @param payload
     * @return
     */
    private Builder addPublicClaimBuilder(Builder builder, Payload payload) {
        if (!StringUtils.isEmpty(payload.getIssuer())) {
            builder.withIssuer(payload.getIssuer());
        }

        if (!StringUtils.isEmpty(payload.getSubject())) {
            builder.withSubject(payload.getSubject());
        }

        if (payload.getIssuedAt() != null) {
            builder.withIssuedAt(payload.getIssuedAt()); //生成签名的时间
        }

        if (payload.getExpiresAt() != null) {
            builder.withExpiresAt(payload.getExpiresAt());//签名过期的时间
        }

        if (CollectionUtils.isEmpty(payload.getAudience())) {
            payload.getAudience().forEach((s) -> {
                builder.withAudience(s);
            });
        }

        return builder;
    }

    /**
     * 创建JWT 头部信息
     *
     * @param algorithm
     * @return
     */
    private Builder createHeaderBuilder(Algorithm algorithm) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("alg", algorithm.getName());//签名算法
        map.put("typ", "JWT");//令牌的类型
        Builder builder = JWT.create().
                withHeader(map);
        return builder;
    }

    /**
     * 校验Token
     *
     * @param token
     * @return
     */
    public Payload verifyToken(String token) throws UnsupportedEncodingException {
        DecodedJWT jwt = null;
        Payload payload = null;
        try {
            jwt = getDecodedJWT(token);//解码token获得jwt
            payload = getPublicClaim(jwt);//jwt解析出公有负载
            payload = getPrivateClaim(jwt, payload);//jwt解析出私有负载
        } catch (AlgorithmMismatchException e) {
            throw e;
        }
        return payload;//返回解析对象
    }

    /**
     * 获取JWT 私有声明
     *
     * @param jwt
     * @param payload
     * @return
     */
    private Payload getPrivateClaim(DecodedJWT jwt, Payload payload) {
        Map<String, String> claims = new HashMap<String, String>();
        jwt.getClaims().forEach((k, v) -> {
            String asString = v.asString();
            claims.put(k, asString);
        });
        payload.setClaims(claims);
        return payload;
    }

    /**
     * 获取JWT 公共声明
     *
     * @param jwt
     * @return
     */
    private Payload getPublicClaim(DecodedJWT jwt) {
        Payload payload = new Payload();
        payload.setIssuer(jwt.getIssuer());
        payload.setSubject(jwt.getSubject());
        payload.setAudience(jwt.getAudience());
        payload.setIssuedAt(jwt.getIssuedAt());
        payload.setExpiresAt(jwt.getExpiresAt());
        return payload;
    }

    /**
     * 获取 DecodedJWT
     * 将token解码为DecodedJWT
     *
     * @param token
     * @return
     */
    private DecodedJWT getDecodedJWT(String token) throws UnsupportedEncodingException {
        JWTVerifier verifier = JWT.
                require(Algorithm.HMAC256(this.getSecret())).build();
        DecodedJWT jwt = verifier.verify(token);
        return jwt;
    }


    /**
     * 根据发布时间设置过期时间
     *
     * @param issuedAt
     * @param hour
     * @param payload
     */
    public void setIssuedAtAndExpiresAt(Date issuedAt, Integer hour, Payload payload) {
        payload.setIssuedAt(issuedAt);
        payload.setExpiresAt(getAfterDateByHour(issuedAt, hour));
    }

    /**
     * 返回一定时间后的日期
     * date 开始计时的时间
     * year 增加的年
     * month 增加的月
     * day 增加的日
     * hour 增加的小时
     * minute 增加的分钟
     * second 增加的秒
     *
     * @return
     */
    public Date getAfterDateByHour(Date date, int hour) {
        if (date == null) {
            date = new Date();
        }
        Date afterDate = getAfterDate(date, 0, 0, 0, hour, 0, 0);
        return afterDate;
    }

    public Date getAfterDateByMinute(Date date, int minute) {
        if (date == null) {
            date = new Date();
        }
        Date afterDate = getAfterDate(date, 0, 0, 0, 0, minute, 0);
        return afterDate;
    }

    /**
     * 返回一定时间后的日期
     *
     * @param date   开始计时的时间
     * @param year   增加的年
     * @param month  增加的月
     * @param day    增加的日
     * @param hour   增加的小时
     * @param minute 增加的分钟
     * @param second 增加的秒
     * @return
     */
    public Date getAfterDate(Date date, int year, int month, int day, int hour, int minute, int second) {
        if (date == null) {
            date = new Date();
        }

        Calendar cal = new GregorianCalendar();

        cal.setTime(date);
        if (year != 0) {
            cal.add(Calendar.YEAR, year);
        }
        if (month != 0) {
            cal.add(Calendar.MONTH, month);
        }
        if (day != 0) {
            cal.add(Calendar.DATE, day);
        }
        if (hour != 0) {
            cal.add(Calendar.HOUR_OF_DAY, hour);
        }
        if (minute != 0) {
            cal.add(Calendar.MINUTE, minute);
        }
        if (second != 0) {
            cal.add(Calendar.SECOND, second);
        }
        return cal.getTime();
    }


}
