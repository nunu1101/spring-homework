package com.ohgiraffers.gymgahomework.user.model.dao;

import com.ohgiraffers.gymgahomework.user.model.dto.LoginDTO;
import com.ohgiraffers.gymgahomework.user.model.dto.SignUpDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    int regist(SignUpDTO signUpDTO);

    LoginDTO findByUserId(String userId);
}
