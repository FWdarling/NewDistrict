package com.example.demo.utils.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.demo.dbstatus.dao.UserRepo;
import com.example.demo.dbstatus.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * description: JWTInterceptor
 * date: 4/23/21 5:35 PM
 * author: fourwood
 */
@Service
public class JWTInterceptor implements HandlerInterceptor {

    @Autowired
    public JWTInterceptor(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    private final UserRepo userRepo;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        try {
            DecodedJWT decodedJWT = JWT.decode(token);
            Long userId = decodedJWT.getClaim("userId").asLong();
            User user = userRepo.findById(userId.longValue());
            JWTUtil.verify(token, user);
        }catch (SignatureVerificationException e){
            e.printStackTrace();
            System.out.println("Invalid signature");
            postInterceptor(response, "Invalid signature");
            return false;
        }catch (TokenExpiredException e){
            e.printStackTrace();
            System.out.println("token overdue");
            postInterceptor(response, "token overdue");
            return false;
        }catch (AlgorithmMismatchException e){
            e.printStackTrace();
            System.out.println("token algorithm inconsistency");
            postInterceptor(response, "token algorithm inconsistency");
            return false;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("token invalid");
            postInterceptor(response, "token invalid");
            return false;
        }
        return true;
    }

    protected void postInterceptor(HttpServletResponse response, String errorMsg) throws Exception {
        // 如果被拦截，返回信息
        response.setStatus(400);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(new String("{\"msg: " + errorMsg + "\"}"));
        response.getWriter().flush();
    }
}
