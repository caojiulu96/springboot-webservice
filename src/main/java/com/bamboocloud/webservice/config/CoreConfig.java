package com.bamboocloud.webservice.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.bamboocloud.webservice.service.UserSoapService;
import com.bamboocloud.webservice.service.impl.UserSoapServiceImpl;
/**
 * 发布soap与rest webservice核心类
 * 
 * 1.如果只需要rest webservice  直接去掉该类
 * 2.如果只需要soap webservice  注释掉 dispatcherRestServlet方法
 * 3.如果同时需要 ，则两个都需要
 * @author jiulu
 *
 */
@Configuration
public class CoreConfig {

	/**
	 * 针对soap方法发布   
	 * @return
	 */
	@Bean
	public ServletRegistrationBean<CXFServlet> dispatcherServlet() {
		return new ServletRegistrationBean<CXFServlet>(new CXFServlet(), "/cxf/*");// 发布服务名称 localhost:8080/cxf
																		
	}
	
	/**
     * 针对于rest接口发布服务  
    * @return
    */
    @Bean
    public ServletRegistrationBean<DispatcherServlet> dispatcherRestServlet() {
        AnnotationConfigWebApplicationContext context
                = new AnnotationConfigWebApplicationContext();
        //替换成自己想发布的controller包路径
        context.scan("com.bamboocloud.rest.controller");
        DispatcherServlet disp = new DispatcherServlet(context);
        ServletRegistrationBean<DispatcherServlet> registrationBean = new ServletRegistrationBean<DispatcherServlet>(disp);
        registrationBean.setLoadOnStartup(1);
        //映射路径自定义,必须设置一个不重复的名称
        registrationBean.addUrlMappings("/rest/*");
        registrationBean.setName("rest");
        return registrationBean;
    }
	
 
	@Bean(name = Bus.DEFAULT_BUS_ID)
	public SpringBus springBus() {
		return new SpringBus();
	}

	
    /*
    @Autowired
    UserService userService;*/
    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(),userService());
        endpoint.publish("/UserService");//// 接口访问地址
        return endpoint;
    }
    @Bean
     public UserSoapService userService() {
            return new UserSoapServiceImpl();
     }
  	@Bean
  	public Endpoint hello() {
  		EndpointImpl endpoint = new EndpointImpl(springBus(), userService());// 绑定要发布的服务实现类
  		endpoint.publish("/hello"); // 接口访问地址
  		return endpoint;
  	}


}
