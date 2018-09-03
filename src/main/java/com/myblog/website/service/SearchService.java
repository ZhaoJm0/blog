package com.myblog.website.service;

import com.myblog.website.entity.BlogContent;

import java.util.List;

public interface SearchService {

    List<BlogContent> searchByKeyword(String keyword);

    List<BlogContent> searchByName(String name);
}
