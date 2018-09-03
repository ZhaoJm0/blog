package com.myblog.website.service;

import com.myblog.website.entity.BlogUser;

public interface UserService {

    BlogUser getUser();

    BlogUser getUserById(String userID);
}
