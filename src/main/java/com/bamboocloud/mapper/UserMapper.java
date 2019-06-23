package com.bamboocloud.mapper;

import java.util.List;

import com.bamboocloud.webservice.entity.User;

/**
 * 用户表 数据层
 * 
 * @author jiulu
 */
public interface UserMapper
{
    /**
     * 根据条件分页查询用户对象
     * 
     * @param User 用户信息
     * @return 用户信息集合信息
     */
    public List<User> selectUserList();

    /**
     * 新增保存用户信息
     * 
     * @param user 用户信息
     * @return 结果
     */
    public int addUser(User user);
}
