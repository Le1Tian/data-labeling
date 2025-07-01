package com.tl.datalabeling.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * ClassName: WebConfig
 * Package: com.tl.datalabeling.config
 * Description:如果你想自定义 URL 前缀，比如 /static/img/，可以加一个配置类：这样，http://localhost:8090/static/img/cat1.jpg 就能访问 E:/项目/data/cat1.jpg。
 *
 * 后端返回的图片路径必须是前端能访问的 HTTP URL，而不是本地磁盘路径。
 * Spring Boot 静态资源映射可以轻松实现本地文件夹到 URL 的映射。
 * 数据库 imagePath 字段建议存 URL 路径，或者前端收到后做一次路径转换。
 *
 * @Author Taylin
 * @Create 2025/7/1 21:51
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/img/**")
                .addResourceLocations("file:E:/项目/data/");
    }
}