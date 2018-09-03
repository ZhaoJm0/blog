package com.myblog.website.service;

import com.myblog.website.entity.BlogTag;

import java.util.List;
import java.util.Map;

public interface TagService {
    List<BlogTag> getTagAll();

    Map<String, String> getTagAllForMap();

    String getTagNameById(String tagId);

    Integer getTagIdByName(String tags);
}
