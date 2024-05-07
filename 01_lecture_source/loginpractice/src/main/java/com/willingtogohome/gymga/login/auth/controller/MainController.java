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
        return "login";
    }

    @PostMapping(value = "/login")
    public String loginPost(@ModelAttribute LoginDTO loginDTO){
        List<String> role = loginDTO.getRole();

        if (ADMIN.equals(role)){
            return "redirect:/login/admin/admin";
        } else {
            return "redirect:/login/user/user";
        }
    }



}
