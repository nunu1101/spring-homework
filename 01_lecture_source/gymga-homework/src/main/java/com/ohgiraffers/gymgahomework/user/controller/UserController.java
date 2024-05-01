package com.ohgiraffers.gymgahomework.user.controller;

import com.ohgiraffers.gymgahomework.user.model.dto.SignUpDTO;
import com.ohgiraffers.gymgahomework.user.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/signup")
    public void signup(){}

    @PostMapping("/signup")
    public ModelAndView signup(ModelAndView mv, @ModelAttribute SignUpDTO signUpDTO) {

        int result = userService.regist(signUpDTO);

        String message = "";

        if (result > 0) {
            message = "회원가입에 성공하였습니다.";
        } else {
            message = "회원가입에 실패하였습니다.";
        }

        mv.addObject("message", message);

        return mv;
    }
}
