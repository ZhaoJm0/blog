package com.myblog.website.dao;

import com.myblog.website.entity.BlogCategoryDictionary;
import com.myblog.website.entity.BlogCategoryDictionaryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface BlogCategoryDictionaryMapper {
    int countByExample(BlogCategoryDictionaryExample example);

    int deleteByExample(BlogCategoryDictionaryExample example);

    int deleteByPrimaryKey(Byte id);

    int insert(BlogCategoryDictionary record);

    int insertSelective(BlogCategoryDictionary record);

    List<BlogCategoryDictionary> selectByExample(BlogCategoryDictionaryExample example);

    BlogCategoryDictionary selectByPrimaryKey(Byte id);

    int updateByExampleSelective(@Param("record") BlogCategoryDictionary record, @Param("example") BlogCategoryDictionaryExample example);

    int updateByExample(@Param("record") BlogCategoryDictionary record, @Param("example") BlogCategoryDictionaryExample example);

    int updateByPrimaryKeySelective(BlogCategoryDictionary record);

    int updateByPrimaryKey(BlogCategoryDictionary record);
}