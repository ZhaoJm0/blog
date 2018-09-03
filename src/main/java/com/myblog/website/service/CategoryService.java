package com.myblog.website.service;

import com.myblog.website.entity.BlogCategory;

import java.util.List;
import java.util.Map;

public interface CategoryService {

    String getCategoryNameById(String id);

    List<BlogCategory> getCategoryAll();

    Map<String, String> getCategoryAllForMap();

    BlogCategory getCategoryByName(String category);

    void addCategory(String categoryName);
}
