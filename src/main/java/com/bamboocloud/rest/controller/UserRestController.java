package com.bamboocloud.rest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bamboocloud.framework.domain.SysResult;
import com.bamboocloud.webservice.entity.User;
import com.bamboocloud.webservice.service.UserRestService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户信息
 * 
 * @author jiulu
 */
@Api("用户信息管理")
@Controller
@RequestMapping("/user")
public class UserRestController extends BaseController
{

    @Autowired
    private UserRestService userRestService;


    /**
     * 新增保存用户
     */
    @RequestMapping(value="/add",method=RequestMethod.POST)
    @ResponseBody
    public SysResult addSave(@RequestBody User user)
    {
    	user.setUserid(UUID.randomUUID()+"");
        userRestService.addUser(user);
        return SysResult.oK();
    }
    
     @RequestMapping(value="/test",method=RequestMethod.GET)
     @ResponseBody
	 Map<String,Object> list() {
		 Map<String,Object> map = new HashMap<String,Object>();
		 map.put("func", "test");
		 map.put("name", "king");
		 return map;
	 }
     
     @ApiOperation("获取列表")
     @GetMapping("list")
     @ResponseBody
     public List<String> testList()
     {
    	 List<String> testList = new ArrayList<String>();
    	 testList.add("aaa");
    	 testList.add("bbb");
    	 testList.add("ccc");
         return testList;
     }

}