package com.myblog.website.dao;

import com.myblog.website.entity.BlogTimeline;
import com.myblog.website.entity.BlogTimelineExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface BlogTimelineMapper {
    int countByExample(BlogTimelineExample example);

    int deleteByExample(BlogTimelineExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BlogTimeline record);

    int insertSelective(BlogTimeline record);

    List<BlogTimeline> selectByExample(BlogTimelineExample example);

    BlogTimeline selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BlogTimeline record, @Param("example") BlogTimelineExample example);

    int updateByExample(@Param("record") BlogTimeline record, @Param("example") BlogTimelineExample example);

    int updateByPrimaryKeySelective(BlogTimeline record);

    int updateByPrimaryKey(BlogTimeline record);

    List<BlogTimeline> selectLimitByExample(BlogTimelineExample example);
}