package com.leyou.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @Auther xcai
 * @Date 2020/1/28
 */

@Configuration
public class LeyouCorsConfiguration {

    @Bean
    public CorsFilter corsFilter(){

        //初始化Cors配置对象
        CorsConfiguration configuration = new CorsConfiguration();

        //允许跨域的域名，如果需要携带cookie,就不能写*。 *：表示所有的域名都可以跨域
        configuration.addAllowedOrigin("http://manage.leyou.com");
        configuration.addAllowedOrigin("http://www.leyou.com");
        configuration.setAllowCredentials(true);  //允许携带cookie
        configuration.addAllowedMethod("*");      //代表所有的请求方法: GET PUT POST Delete...
        configuration.addAllowedHeader("*");      //允许携带任何头信息

        //初始化Cors配置
        UrlBasedCorsConfigurationSource configurationSource = new UrlBasedCorsConfigurationSource();
        configurationSource.registerCorsConfiguration("/**", configuration);

        //返回CorsFilter实例
        return new CorsFilter(configurationSource);
    }
}
