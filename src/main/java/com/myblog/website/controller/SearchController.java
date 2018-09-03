package com.myblog.website.controller;

import com.myblog.website.entity.BlogContent;
import com.myblog.website.entity.BlogTag;
import com.myblog.website.service.SearchService;
import com.myblog.website.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class SearchController {
    @Autowired
    private SearchService searchService;

    @Autowired
    private TagService tagService;

    @PostMapping("/searchkeyword")
    public String searchContentByKeyword(String keyword, HttpServletRequest request) {
        List<BlogContent> blogContents = searchService.searchByKeyword(keyword);
        List<BlogTag> tags = tagService.getTagAll();
        request.setAttribute("tags", tags);
        request.setAttribute("contentList", blogContents);
        return "/index";
    }

    @GetMapping("/searchtag/{id}")
    public String searchContentByTag(@PathVariable("id") String name, HttpServletRequest request) {
        List<BlogTag> tags = tagService.getTagAll();
        List<BlogContent> blogContents = searchService.searchByName(name);
        request.setAttribute("contentList", blogContents);
        request.setAttribute("tags", tags);
        return "/index";
    }
}
