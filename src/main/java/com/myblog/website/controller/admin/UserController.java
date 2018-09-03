package com.myblog.website.controller.admin;

import com.myblog.website.entity.BlogUser;
import com.myblog.website.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/profile")
    public String showProfile(HttpServletRequest request) {
        BlogUser user = userService.getUser();
        request.setAttribute("user", user);
        return "/admin/profile";
    }
}
