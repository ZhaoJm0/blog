package com.myblog.website.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class ShowPageController {

    @GetMapping({"", "/index"})
    public String showIndex() {
        return "admin/index";
    }



//    @GetMapping("/content_manage")
//    public String showManage() {
//        return "admin/content_manage";
//    }

}
