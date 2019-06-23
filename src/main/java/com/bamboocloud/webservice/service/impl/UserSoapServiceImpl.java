package com.bamboocloud.webservice.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bamboocloud.framework.annotation.DataSource;
import com.bamboocloud.framework.config.DataSourceType;
import com.bamboocloud.mapper.UserMapper;
import com.bamboocloud.webservice.entity.User;
import com.bamboocloud.webservice.service.UserSoapService;
import com.github.pagehelper.PageHelper;

@WebService(serviceName = "UserService", // 对外发布的服务名
targetNamespace = "http://service.webservice.bamboocloud.com", // 指定你想要的名称空间，通常使用使用包名反转
endpointInterface = "com.bamboocloud.webservice.service.UserSoapService") // 服务接口全路径,
															// 指定做SEI（Service
															// EndPoint
															// Interface）服务端点接口
@Component
public class UserSoapServiceImpl implements UserSoapService {

	private Map<String, User> userMap = new HashMap<String, User>();

	@Autowired
    UserMapper userMapper;
	
	@Override
	public String getUserName(String userId) {
		return "userId为：" + userId;
	}

	@Override
	public User getUser(String userId) {
		System.out.println("userMap是:" + userMap);
		return userMap.get(userId);
	}
	

	@Override
	@DataSource(value = DataSourceType.SLAVE)
	public List<User> getUserList(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return userMapper.selectUserList();
	}
	
	@Override
	public List<User> getUserList1(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return userMapper.selectUserList();
	}

}
