package com.myblog.website.utils;

import com.myblog.website.controller.IndexController;
import com.myblog.website.entity.BlogContent;
import com.myblog.website.service.ContentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ContentUtils {

    private static Map<String, Date> lookContent = new ConcurrentHashMap<>();

    /**
     * 判断文章的完整性
     * @param content
     * @return
     */
    public static String contentQuqlified(BlogContent content) {
        String title = content.getTitle();
        if (title == null || title.trim().equals("")) {
            return "文章标题不能为空";
        }
        String tagId = content.getTags();
        if (tagId == null) {
            return "标签不能为空";
        }
        String category = content.getCategory();
        if (category == null || category.trim().equals("")) {
            return "请选择分类";
        }
        return null;
    }

    /**
     * 文章阅读次数
     * @param ip    访问者ip加上文章id构成唯一主键
     * @param contentService
     * @param entity
     */
    public static void setReadTimes(String ip, ContentService contentService, IndexController.ReadTimesEntity entity) {
        clearLookContent();
        if (!lookContent.containsKey(ip)) {
            contentService.updateReadtimes(entity.getId(), entity.getReadtimes());
        }
        lookContent.put(ip, new Date());
    }

    /**
     * 每十分钟执行一次清理访问文章的ip
     * 限制文章阅读次数随页面刷新而无限制增加
      */
     @Scheduled(cron = "0 0/10 * * * ? ")
    private static void clearLookContent(){
        Set<Map.Entry<String, Date>> entries = lookContent.entrySet();
        Iterator<Map.Entry<String, Date>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Date> ele = iterator.next();
            Date preDate = ele.getValue();
            if (System.currentTimeMillis() - preDate.getTime() >= 3600000) {
                iterator.remove();
            }
        }
    }
}
