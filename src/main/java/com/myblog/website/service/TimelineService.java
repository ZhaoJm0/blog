package com.myblog.website.service;

import com.myblog.website.entity.BlogTimeline;

import java.util.List;

public interface TimelineService {

    List<BlogTimeline> getTimeline();

    int addTimeline(String title, String content);
}
