package com.willingtogohome.gymga.login.user.model.service;

import com.willingtogohome.gymga.login.user.model.dao.UserMapper;
import com.willingtogohome.gymga.login.user.model.dto.LoginDTO;
import com.willingtogohome.gymga.login.user.model.dto.RegistDTO;
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

   public int regist(RegistDTO registDTO) {

       registDTO.setUserPwd(passwordEncoder.encode(registDTO.getUserPwd()));

       int result = 0;

       try {
       result = userMapper.regist(registDTO);
       } catch (Exception e) {
           e.printStackTrace();
       }
       return result;
   }

    public LoginDTO findByUserId(String userId) {

        LoginDTO login = userMapper.findByUserId(userId);

        if(!Objects.isNull(login)) {
            return login;
        } else {
            return null;
        }
    }
}
