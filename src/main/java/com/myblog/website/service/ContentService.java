package com.myblog.website.service;

import com.myblog.website.entity.BlogContent;

import java.util.List;

public interface ContentService {

    void addContent(BlogContent content);

    List<BlogContent> getContentList();

    List<BlogContent> getPublishContentList();

    BlogContent selectById(Integer id);

    void deleteById(Integer id);

    boolean updateContent(BlogContent content);

    void contentAugment(BlogContent content);

    void updateReadtimes(Integer id, Integer readtimes);

    void modifyContent(Integer id, String status);

    void settingCategoryAndTag(List<BlogContent> contentList);
}
