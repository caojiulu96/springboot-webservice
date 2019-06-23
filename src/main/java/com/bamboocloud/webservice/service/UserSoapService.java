package com.bamboocloud.webservice.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.bamboocloud.webservice.entity.User;

@WebService(targetNamespace = "http://service.webservice.bamboocloud.com")
public interface UserSoapService {

    @WebMethod//标注该方法为webservice暴露的方法,用于向外公布，它修饰的方法是webservice方法，去掉也没影响的，类似一个注释信息。
    public User getUser(@WebParam(name = "userId") String userId);

    @WebMethod
    @WebResult(name="String",targetNamespace="")
    public String getUserName(@WebParam(name = "userId") String userId);
   
    @WebMethod
    @WebResult(name="String",targetNamespace="")
    public List<User> getUserList(@WebParam(name = "pageNum") Integer pageNum, @WebParam(name = "pageSize") Integer pageSize);

    
    @WebMethod
    @WebResult(name="String",targetNamespace="")
    public List<User> getUserList1(@WebParam(name = "pageNum") Integer pageNum, @WebParam(name = "pageSize") Integer pageSize);

}

