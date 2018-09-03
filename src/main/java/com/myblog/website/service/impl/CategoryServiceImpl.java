package com.myblog.website.service.impl;

import com.myblog.website.dao.BlogCategoryMapper;
import com.myblog.website.entity.BlogCategory;
import com.myblog.website.entity.BlogCategoryExample;
import com.myblog.website.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private BlogCategoryMapper categoryMapper;

    @Override
    public String getCategoryNameById(String id) {
        BlogCategory category = categoryMapper.selectByPrimaryKey(Byte.valueOf(id));
        return category.getName();
    }

    @Override
    public List<BlogCategory> getCategoryAll() {
        return categoryMapper.selectByExample(new BlogCategoryExample());
    }

    @Override
    public Map<String, String> getCategoryAllForMap() {
        List<BlogCategory> categoryAll = getCategoryAll();
        Map<String, String> res = new HashMap<>();
        for (BlogCategory category : categoryAll) {
            Byte id = category.getId();
            String name = category.getName();
            res.put(id.toString(), name);
        }
        return res;
    }

    @Override
    public BlogCategory getCategoryByName(String category) {
        BlogCategoryExample categoryExample = new BlogCategoryExample();
        BlogCategoryExample.Criteria criteria = categoryExample.createCriteria();
        criteria.andNameEqualTo(category);
        List<BlogCategory> blogCategories = categoryMapper.selectByExample(categoryExample);
        return blogCategories.get(0);
    }

    @Override
    public void addCategory(String categoryName) {
        BlogCategory category = new BlogCategory();
        category.setName(categoryName);
        category.setStatus(new Byte("1"));
        categoryMapper.insert(category);
    }
}
