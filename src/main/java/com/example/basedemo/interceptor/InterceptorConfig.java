package com.example.basedemo.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈拦截器配置〉
 *
 * @author Chkl
 * @create 2020/4/25
 * @since 1.0.0
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor ;

    //请求无需验证登录的url
    List<String> passingUrl = new ArrayList<String>(){
        {
            //登录
            add("/login");
            //未登录跳转提醒
            add("/toLogin");

            //swagger 相关
            add("/swagger-ui.html");
            add("/webjars/**");
            add("/v2/**");
            add("/swagger-resources/**");
            add("/doc.html/**");
        }
    };

    /**
     * 拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).
                addPathPatterns("/**").
                excludePathPatterns(passingUrl);
    }
    /**
     * 配置跨域和支持restoful接口
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }

    /**
     * 设置图片映射
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //addResourceHandler是指你想在url请求的路径
        //addResourceLocations是图片存放的真实路径
        registry.addResourceHandler("/image/**").addResourceLocations("file:"+System.getProperty("user.dir")+"/image/");
    }
}
