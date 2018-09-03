package com.myblog.website.controller;

import com.myblog.website.entity.BlogContent;
import com.myblog.website.entity.BlogTag;
import com.myblog.website.service.CategoryService;
import com.myblog.website.service.ContentService;
import com.myblog.website.service.TagService;
import com.myblog.website.utils.ContentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {

    @Resource
    private ContentService contentService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private TagService tagService;

    @GetMapping({"/", "/index.html"})
    public String showIndex(HttpServletRequest request) {
        List<BlogContent> contentList = contentService.getPublishContentList();
        List<BlogTag> tags = tagService.getTagAll();
        request.setAttribute("contentList",contentList);
        request.setAttribute("tags", tags);
        return "/index";
    }

    @GetMapping("/info.html")
    public String showInfo(HttpServletRequest request) {
        List<BlogTag> tags = tagService.getTagAll();
        request.setAttribute("tags", tags);
        return "/infopage";
    }

    @GetMapping("/info/{id}.html")
    public String showContent(@PathVariable Integer id, HttpServletRequest request) {
        BlogContent content = contentService.selectById(id);
        List<BlogTag> tags = tagService.getTagAll();
        String categoryId = content.getCategory();
        content.setCategory(categoryService.getCategoryNameById(categoryId));
        ContentUtils.setReadTimes(request.getRemoteAddr() + "-" + id, contentService, new ReadTimesEntity(content.getId(), content.getReadtimes()));
        request.setAttribute("content", content);
        request.setAttribute("tags", tags);
        return "/info";
    }

    public class ReadTimesEntity {
        Integer id;
        Integer readtimes;
        ReadTimesEntity(Integer id, Integer readtimes) {
            this.id = id;
            this.readtimes = readtimes;
        }

        public Integer getId() {
            return id;
        }

        public Integer getReadtimes() {
            return readtimes;
        }
    }

}
