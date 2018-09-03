package com.myblog.website.dao;

import com.myblog.website.entity.BlogUser;
import com.myblog.website.entity.BlogUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface BlogUserMapper {
    int countByExample(BlogUserExample example);

    int deleteByExample(BlogUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(BlogUser record);

    int insertSelective(BlogUser record);

    List<BlogUser> selectByExampleWithBLOBs(BlogUserExample example);

    List<BlogUser> selectByExample(BlogUserExample example);

    BlogUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BlogUser record, @Param("example") BlogUserExample example);

    int updateByExampleWithBLOBs(@Param("record") BlogUser record, @Param("example") BlogUserExample example);

    int updateByExample(@Param("record") BlogUser record, @Param("example") BlogUserExample example);

    int updateByPrimaryKeySelective(BlogUser record);

    int updateByPrimaryKeyWithBLOBs(BlogUser record);

    int updateByPrimaryKey(BlogUser record);
}