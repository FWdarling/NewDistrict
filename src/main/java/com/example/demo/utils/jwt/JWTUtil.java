package com.example.demo.utils.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.demo.dbstatus.dao.UserRepo;
import com.example.demo.dbstatus.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;

/**
 * description: JWTutil
 * date: 4/23/21 4:52 PM
 * author: fourwood
 */
public class JWTUtil {


    public static String getToken(User user) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);

        JWTCreator.Builder builder = JWT.create();
        builder.withClaim("userId", user.getId()).withClaim("userName", user.getUserName());

        return builder.withExpiresAt(calendar.getTime()).sign(Algorithm.HMAC256(user.getPassword()));
    }

    public static DecodedJWT verify(String token, User user){
        String password = user.getPassword();
        JWTVerifier build = JWT.require(Algorithm.HMAC256(password)).build();
        DecodedJWT verify = build.verify(token);
        return verify;
    }
}
