package com.bamboocloud.webservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bamboocloud.mapper.UserMapper;
import com.bamboocloud.webservice.entity.User;
import com.bamboocloud.webservice.service.UserRestService;

@Service("userRestService")
public class UserRestServiceImpl implements UserRestService{

	@Autowired
    UserMapper userMapper;
	
	@Override
	@Transactional
	public int addUser(User user) {
		int rows = userMapper.addUser(user);
		 return rows;
	}

}
