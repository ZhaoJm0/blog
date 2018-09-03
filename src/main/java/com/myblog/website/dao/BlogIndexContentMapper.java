package com.myblog.website.dao;

import com.myblog.website.entity.BlogIndexContent;
import com.myblog.website.entity.BlogIndexContentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface BlogIndexContentMapper {
    int countByExample(BlogIndexContentExample example);

    int deleteByExample(BlogIndexContentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BlogIndexContent record);

    int insertSelective(BlogIndexContent record);

    List<BlogIndexContent> selectByExample(BlogIndexContentExample example);

    BlogIndexContent selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BlogIndexContent record, @Param("example") BlogIndexContentExample example);

    int updateByExample(@Param("record") BlogIndexContent record, @Param("example") BlogIndexContentExample example);

    int updateByPrimaryKeySelective(BlogIndexContent record);

    int updateByPrimaryKey(BlogIndexContent record);
}