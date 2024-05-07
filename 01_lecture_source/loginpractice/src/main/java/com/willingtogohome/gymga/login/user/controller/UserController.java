package com.willingtogohome.gymga.login.user.controller;

import com.willingtogohome.gymga.login.user.model.dto.RegistDTO;
import com.willingtogohome.gymga.login.user.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/regist")
    public void regist(){}

    @PostMapping("/regist")
    public ModelAndView regist(ModelAndView mv, @ModelAttribute RegistDTO registDTO) {

        int result = userService.regist(registDTO);

        String message = "";
        if (result > 0) {
            message = "회원가입 완료";
        } else {
            message = "회원가입 실패";
        }

        mv.addObject("message", message);

        return mv;
    }
}
