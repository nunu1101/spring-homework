package com.ohgiraffers.gymgahomework.auth.controller;

import com.ohgiraffers.gymgahomework.user.model.dto.LoginDTO;
import com.ohgiraffers.gymgahomework.user.model.dto.SignUpDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/login")
    public void login(){}

    @GetMapping("/fail")
    public ModelAndView loginFail(ModelAndView mv, @RequestParam String message) {

        mv.addObject("message", message);
        mv.setViewName("/auth/fail");

        return mv;
    }

//    @PostMapping("find")
//        public String serachId(HttpServletRequest req, Model model, SignUpDTO signUpDTO,
//                               @RequestParam String userName,
//                               @RequestParam String userPhone) {
//                signUpDTO.setUserName(userName);
//    }
//    return;
}
