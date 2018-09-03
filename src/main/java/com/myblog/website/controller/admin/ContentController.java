package com.myblog.website.controller.admin;

import com.myblog.website.constant.BlogConstant;
import com.myblog.website.service.TagService;
import com.myblog.website.service.TimelineService;
import com.myblog.website.utils.ContentUtils;
import com.myblog.website.entity.BlogCategory;
import com.myblog.website.entity.BlogContent;
import com.myblog.website.service.CategoryService;
import com.myblog.website.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/admin")
public class ContentController {

    @Autowired
    private ContentService contentService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private TagService tagService;

    @Autowired
    private TimelineService timelineService;

    /**
     * 创建一篇新的文章
     * @param content
     * @return
     */
    @PostMapping("/content/add")
    @ResponseBody
    public String createContent(BlogContent content) {
        //补全文章属性
        contentService.contentAugment(content);

        //判断文章是否完整，完整返回null，不完整返回相应信息
        String result = ContentUtils.contentQuqlified(content);
        timelineService.addTimeline("发布文章", "发布了文章：《" + content.getTitle() + "》");
        if (result != null) {
            return result;
        }
        contentService.addContent(content);
        return "success";
    }

    @GetMapping("/content_publish")
    public String showPublish(HttpServletRequest request) {
        List<BlogCategory> categorys = categoryService.getCategoryAll();
        request.setAttribute("categoryList", categorys);
        return "admin/content_publish";
    }

    @GetMapping("/content_manage")
    public String showContentList(HttpServletRequest request) {
        List<BlogContent> contentList = contentService.getContentList();
        request.setAttribute("contents",contentList);
        System.out.println(contentList);
        return "admin/content_manage";
    }

    @GetMapping("/content/show/{id}")
    public String showContent(@PathVariable("id")Integer id, HttpServletRequest request) {
        BlogContent content = contentService.selectById(id);
        request.setAttribute("cont",content);
        return "/admin/content_show";
    }

    @GetMapping("/content/modify/{id}")
    public String editContent(@PathVariable("id")Integer id, HttpServletRequest request) {
        BlogContent content = contentService.selectById(id);
        List<BlogCategory> categorys = categoryService.getCategoryAll();
        String tagId = content.getTags();
        String tagName = tagService.getTagNameById(tagId);
        content.setTags(tagName);
        request.setAttribute("cont",content);
        request.setAttribute("categoryList", categorys);
        return "/admin/content_modify";
    }

    /**
     * 更新文章
     * @param content
     * @return
     */
    @PostMapping("/content/update")
    @ResponseBody
    public String updateContent(BlogContent content) {
        content.setUpdatetime(new Date());
        Integer tagId = tagService.getTagIdByName(content.getTags());
        content.setTags(String.valueOf(tagId));
        String message = ContentUtils.contentQuqlified(content);
        timelineService.addTimeline("修改文章", "修改了文章：《" + content.getTitle() + "》");
        if(message != null)
            return message;
        boolean result = contentService.updateContent(content);
        if(result)
            return "success";
        else
            return "更新失败";
    }

    @GetMapping("/content/delete/{id}")
    public String deleteContent(@PathVariable("id")Integer id) {
        BlogContent content = contentService.selectById(id);
        timelineService.addTimeline("删除文章", "删除了文章：《" + content.getTitle() + "》");
        contentService.deleteById(id);
        return "redirect:/admin/content_manage";
    }

    @GetMapping("/content/cancel/{id}")
    public String cancelContent(@PathVariable("id")Integer id) {
        contentService.modifyContent(id, BlogConstant.CONTENT_CONCEL);
        return "redirect:/admin/content_manage";
    }

    @GetMapping("/content/publish/{id}")
    public String publishContent(@PathVariable("id")Integer id) {
        contentService.modifyContent(id, BlogConstant.CONTENT_PUBLISH);
        return "redirect:/admin/content_manage";
    }

}
