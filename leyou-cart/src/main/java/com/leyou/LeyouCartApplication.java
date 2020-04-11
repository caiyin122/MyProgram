package com.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Auther xcai
 * @Date 2020/2/26
 */

@SpringBootApplication
@EnableDiscoveryClient    //让注册中心能够发现该微服务
@EnableFeignClients
public class LeyouCartApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeyouCartApplication.class);
    }
}
