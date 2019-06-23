package com.bamboocloud.webservice.service;

import com.bamboocloud.webservice.entity.User;

public interface UserRestService {


	/**
     * 新增保存用户信息
     * 
     * @param user 用户信息
     * @return 结果
     */
	int addUser(User user);
	
}
