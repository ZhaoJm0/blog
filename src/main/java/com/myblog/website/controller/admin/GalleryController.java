package com.myblog.website.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class GalleryController {

    @RequestMapping("/gallery")
    public String showGallery() {
        return "/admin/gallery";
    }
}
