package com.ohgiraffers.gymgahomework.user.model.service;

import com.ohgiraffers.gymgahomework.user.model.dao.UserMapper;
import com.ohgiraffers.gymgahomework.user.model.dto.LoginDTO;
import com.ohgiraffers.gymgahomework.user.model.dto.SignUpDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public int regist(SignUpDTO signUpDTO) {
        signUpDTO.setUserPwd(passwordEncoder.encode(signUpDTO.getUserPwd()));

        int result = 0;

        try {
            result = userMapper.regist(signUpDTO);
        } catch (Exception e) {
            e.printStackTrace();;
        }
        return result;
    }


    public LoginDTO findByUserId(String userId) {
        LoginDTO login = userMapper.findByUserId(userId);

        if (!Objects.isNull(login)) {
            return login;
        } else {
            return null;
        }
    }
}
