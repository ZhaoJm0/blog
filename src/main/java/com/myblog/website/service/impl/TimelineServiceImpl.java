package com.myblog.website.service.impl;

import com.myblog.website.dao.BlogTimelineMapper;
import com.myblog.website.entity.BlogTimeline;
import com.myblog.website.entity.BlogTimelineExample;
import com.myblog.website.entity.BlogTimelineExampleExtend;
import com.myblog.website.service.TimelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TimelineServiceImpl implements TimelineService {

    @Autowired
    private BlogTimelineMapper timelineMapper;

    @Override
    public List<BlogTimeline> getTimeline() {
        BlogTimelineExampleExtend timelineExampleExtend = new BlogTimelineExampleExtend();
        timelineExampleExtend.setOrderByClause("event_date");
        timelineExampleExtend.setOffset(0);
        timelineExampleExtend.setLimit(20);
        List<BlogTimeline> timelines = timelineMapper.selectLimitByExample(timelineExampleExtend);
        return timelines;
    }

    @Override
    public int addTimeline(String title, String content) {
        BlogTimeline timeline = new BlogTimeline();
        timeline.setEventName(title);
        timeline.setEventContent(content);
        timeline.setEventDate(new Date());
        timeline.setEventTime(new Date());
        timeline.setUser("Zhao");
        return timelineMapper.insert(timeline);
    }
}
