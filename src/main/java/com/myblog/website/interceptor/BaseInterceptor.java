package com.myblog.website.interceptor;

import com.myblog.website.entity.BlogUser;
import com.myblog.website.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class BaseInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        String requestURI = request.getRequestURI();
        if (requestURI.equals("/admin/loginVcode") || requestURI.equals("/admin/loginuser") || requestURI.equals("/admin/login")) {
            return true;
        }
        if (requestURI.startsWith("/admin")) {
            String userID = (String) request.getSession().getAttribute("userID");
            BlogUser user = userService.getUserById(userID);
            if (user == null) {
                response.sendRedirect("/admin/login");
                return false;
            }
        }
        return true;
    }
}
