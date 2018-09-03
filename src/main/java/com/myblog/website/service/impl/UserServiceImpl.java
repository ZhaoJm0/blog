package com.myblog.website.service.impl;

import com.myblog.website.dao.BlogUserMapper;
import com.myblog.website.entity.BlogUser;
import com.myblog.website.entity.BlogUserExample;
import com.myblog.website.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private BlogUserMapper userMapper;

    @Override
    public BlogUser getUser() {
        List<BlogUser> users = userMapper.selectByExampleWithBLOBs(new BlogUserExample());
        return users.get(0);
    }

    @Override
    public BlogUser getUserById(String userID) {
        return userMapper.selectByPrimaryKey(userID);
    }
}
