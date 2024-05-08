package com.willingtogohome.gymga.login.auth.controller;

import com.willingtogohome.gymga.login.user.model.dto.LoginDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static com.willingtogohome.gymga.login.common.UserRole.ADMIN;

@Controller
public class MainController {

    @GetMapping(value = "/login")
    public String loginPage(){
        return "/login";
    }




    @GetMapping("/admin/page")
    public String adminPage() {
        return "/login/admin/admin";
    }

    @GetMapping("/user/page")
    public String userPage() {
        return "/login/user/user";
    }



}
