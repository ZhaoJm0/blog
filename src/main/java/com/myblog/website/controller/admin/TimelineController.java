package com.myblog.website.controller.admin;

import com.myblog.website.entity.BlogTimeline;
import com.myblog.website.service.TimelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequestMapping("/admin")
public class TimelineController {

    @Autowired
    private TimelineService timelineService;

    @RequestMapping("/timeline")
    public String showTimeline(HttpServletRequest request) {
        List<BlogTimeline> timelines = timelineService.getTimeline();
        request.setAttribute("timelines", timelines);
        return "/admin/timeline";
    }

}
