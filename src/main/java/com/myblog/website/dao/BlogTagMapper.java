package com.myblog.website.dao;

import com.myblog.website.entity.BlogTag;
import com.myblog.website.entity.BlogTagExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface BlogTagMapper {
    int countByExample(BlogTagExample example);

    int deleteByExample(BlogTagExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BlogTag record);

    int insertAndGetId(BlogTag record);

    int insertSelective(BlogTag record);

    List<BlogTag> selectByExample(BlogTagExample example);

    BlogTag selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BlogTag record, @Param("example") BlogTagExample example);

    int updateByExample(@Param("record") BlogTag record, @Param("example") BlogTagExample example);

    int updateByPrimaryKeySelective(BlogTag record);

    int updateByPrimaryKey(BlogTag record);
}