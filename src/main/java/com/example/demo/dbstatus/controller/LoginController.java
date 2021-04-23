package com.example.demo.dbstatus.controller;

import com.example.demo.dbstatus.dao.UserRepo;
import com.example.demo.dbstatus.entity.User;
import com.example.demo.dbstatus.request.RequestUser;
import com.example.demo.utils.jwt.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: LoginController
 * date: 4/23/21 5:50 PM
 * author: fourwood
 */
@RestController
public class LoginController {

    @Autowired
    public LoginController(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    private UserRepo userRepo;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody RequestUser requestUser){
        String userName = requestUser.getUserName();
        User user = userRepo.findByUserName(userName);
        if(user == null) {
            return new ResponseEntity<>("UserName not existed!", HttpStatus.NOT_FOUND);
        }
        if(!user.checkUser(requestUser)) {
            return new ResponseEntity<>("UserName not existed!", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(JWTUtil.getToken(user), HttpStatus.OK);
    }
}
