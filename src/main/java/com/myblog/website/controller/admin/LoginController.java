package com.myblog.website.controller.admin;

import com.myblog.website.entity.BlogUser;
import com.myblog.website.service.UserService;
import com.myblog.website.utils.VerifyCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLogin() {
        return "/admin/login";
    }

    @RequestMapping("/loginVcode")
    public void getVerifyCodeUtils(HttpServletRequest request, HttpServletResponse response) throws IOException {
        VerifyCodeUtils.validateCode(request, response);
    }

    @PostMapping("/loginuser")
    @ResponseBody
    public String login(String username, String password, String vcode, HttpServletRequest request) {
        BlogUser user = userService.getUser();
        if(!user.getUsername().equals(username)) {
            return "用户名错误";
        }
        if(!user.getPassword().equals(password)) {
            return "密码错误";
        }

        if (!vcode.equalsIgnoreCase((String) request.getSession().getAttribute("vcode"))) {
            return "验证码错误";
        }
        request.getSession().setAttribute("userID", user.getId());
        return "success";
    }

}
