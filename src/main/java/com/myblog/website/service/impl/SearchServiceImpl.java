package com.myblog.website.service.impl;

import com.myblog.website.dao.BlogContentMapper;
import com.myblog.website.entity.BlogContent;
import com.myblog.website.entity.BlogContentExample;
import com.myblog.website.service.ContentService;
import com.myblog.website.service.SearchService;
import com.myblog.website.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    private BlogContentMapper contentMapper;

    @Autowired
    private ContentService contentService;

    @Autowired
    private TagService tagService;

    @Override
    public List<BlogContent> searchByKeyword(String keyword) {
        BlogContentExample example = new BlogContentExample();
        BlogContentExample.Criteria criteria = example.createCriteria();
        criteria.andTitleLike("%" + keyword + "%");
        List<BlogContent> blogContents = contentMapper.selectByExample(example);
        contentService.settingCategoryAndTag(blogContents);
        return blogContents;
    }

    @Override
    public List<BlogContent> searchByName(String name) {
        BlogContentExample example = new BlogContentExample();
        Integer tagId = tagService.getTagIdByName(name);
        BlogContentExample.Criteria criteria = example.createCriteria();
        criteria.andTagsEqualTo(String.valueOf(tagId));
        List<BlogContent> blogContents = contentMapper.selectByExample(example);
        contentService.settingCategoryAndTag(blogContents);
        return blogContents;
    }
}
