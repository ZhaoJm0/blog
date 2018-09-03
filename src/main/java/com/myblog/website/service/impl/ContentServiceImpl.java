package com.myblog.website.service.impl;

import com.myblog.website.constant.BlogConstant;
import com.myblog.website.dao.BlogContentMapper;
import com.myblog.website.entity.BlogCategory;
import com.myblog.website.entity.BlogContent;
import com.myblog.website.entity.BlogContentExample;
import com.myblog.website.service.CategoryService;
import com.myblog.website.service.ContentService;
import com.myblog.website.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private BlogContentMapper contentMapper;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private TagService tagService;


    /**
     * 添加一篇文章
     * @param content
     */
    @Override
    public void addContent(BlogContent content) {
        contentMapper.insert(content);
    }

    /**
     * 查询所有文章但不分页
     * @return
     */
    @Override
    public List<BlogContent> getContentList() {
        BlogContentExample example = new BlogContentExample();
        BlogContentExample.Criteria criteria = example.createCriteria();
        List<BlogContent> contentList = contentMapper.selectByExample(new BlogContentExample());
        settingCategoryAndTag(contentList);
        return contentList;
    }

    @Override
    public List<BlogContent> getPublishContentList() {
        List<BlogContent> blogContents = contentMapper.selectPublishDesc();
        settingCategoryAndTag(blogContents);
        return blogContents;
    }

    /**
     * 根据id查找
     * @param id
     * @return
     */
    @Override
    public BlogContent selectById(Integer id) {
        return contentMapper.selectByPrimaryKey(id);
    }

    /**
     * 根据id删除
     * @param id
     */
    @Override
    public void deleteById(Integer id) {
        contentMapper.deleteByPrimaryKey(id);
    }

    /**
     * 更新文章
     * @param content
     * @return
     */
    @Override
    public boolean updateContent(BlogContent content) {
        int count = contentMapper.updateByPrimaryKeySelective(content);
        return count == 1 ? true : false;
    }

    /**
     * 补全文章内容
     * @param content
     */
    @Override
    public void contentAugment(BlogContent content) {
        //作者后期从session中获取
        content.setAuthor("Zhao JM");
        Integer tagId = tagService.getTagIdByName(content.getTags());

        content.setTags(String.valueOf(tagId));
        content.setStatus(Byte.valueOf("0"));
        content.setCreatetime(new Date());
        content.setUpdatetime(new Date());
        content.setReadtimes(0);
    }

    @Override
    public void updateReadtimes(Integer id, Integer readtimes) {
        BlogContent content = new BlogContent();
        content.setId(id);
        content.setReadtimes(readtimes + 1);
        contentMapper.updateByPrimaryKeySelective(content);
    }

    @Override
    public void modifyContent(Integer id, String status) {
        String temp = "0";
        BlogContent content = new BlogContent();
        content.setId(id);
        if (status == BlogConstant.CONTENT_PUBLISH) {
            temp = "1";
        } else if (status == BlogConstant.CONTENT_CONCEL) {
            temp = "-1";
        } else if (status == BlogConstant.CONTENT_EXAMINE) {
            temp = "0";
        }
        content.setStatus(new Byte(temp));
        contentMapper.updateByPrimaryKeySelective(content);
    }

    /**
     * 按照标签和分类id查询标签和分类name属性，并将id替换为name
     * @param contentList
     */
    @Override
    public void settingCategoryAndTag(List<BlogContent> contentList) {
        Map<String, String> categorys = categoryService.getCategoryAllForMap();
        Map<String, String> tags = tagService.getTagAllForMap();
        for (int i = 0; i < contentList.size(); i++) {
            BlogContent content = contentList.get(i);

            String categoryId = content.getCategory();
            String categoryName = categorys.get(categoryId);

            String tag = content.getTags();
            String tagName = tags.get(tag);

            contentList.get(i).setCategory(categoryName);
            contentList.get(i).setTags(tagName);
        }
    }
}
