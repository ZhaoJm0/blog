package com.myblog.website.service.impl;

import com.myblog.website.dao.BlogTagMapper;
import com.myblog.website.entity.BlogContent;
import com.myblog.website.entity.BlogTag;
import com.myblog.website.entity.BlogTagExample;
import com.myblog.website.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private BlogTagMapper tagMapper;

    @Override
    public List<BlogTag> getTagAll() {
        return tagMapper.selectByExample(new BlogTagExample());
    }

    @Override
    public Map<String, String> getTagAllForMap() {
        List<BlogTag> tagAll = getTagAll();
        Map<String, String> res = new HashMap<>();
        for (int i = 0; i < tagAll.size(); i++) {
            BlogTag tag = tagAll.get(i);
            Integer id = tag.getId();
            String name = tag.getName();
            res.put(id.toString(), name);
        }
        return res;
    }

    @Override
    public String getTagNameById(String tagId) {
        BlogTag tag = tagMapper.selectByPrimaryKey(Integer.valueOf(tagId));
        return tag.getName();
    }

    @Override
    public Integer getTagIdByName(String tagName) {
        BlogTagExample tagExample = new BlogTagExample();
        BlogTagExample.Criteria criteria = tagExample.createCriteria();
        criteria.andNameEqualTo(tagName);
        List<BlogTag> tags = tagMapper.selectByExample(tagExample);
        if (tags.size() == 0) {
            BlogTag newTag = new BlogTag();
            newTag.setName(tagName);
            tagMapper.insertAndGetId(newTag);
            return newTag.getId();
        }
        return tags.get(0).getId();
    }
}
