package com.willingtogohome.gymga.login.auth.controller;

import com.willingtogohome.gymga.login.user.model.dto.LoginDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static com.willingtogohome.gymga.login.common.UserRole.ADMIN;

@Controller
public class AuthController {

    @GetMapping("/login/auth/login")
    public void login() {}

    @PostMapping("/login/auth/login")
    public String loginPost(@ModelAttribute LoginDTO loginDTO) {
        List<String> role = loginDTO.getRole();
        System.out.println(loginDTO);
        if (ADMIN.equals(role)) {
            return "redirect:/login/admin/admin";
        } else {
            return "redirect:/login/user/user";
        }
    }

    @GetMapping(value = "/login/auth/fail")
    public ModelAndView loginFail(@RequestParam String message) {
        ModelAndView mv = new ModelAndView("/login/auth/fail");
        mv.addObject("message", message);
        mv.setViewName("/login/auth/fail");
        return mv;
    }
}
