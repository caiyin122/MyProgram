package com.leyou.gateway.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @Auther xcai
 * @Date 2020/2/25
 */

@ConfigurationProperties(prefix = "leyou.filter")
public class FilterProperties {

    public List<String> getAllowPaths() {
        return allowPaths;
    }

    public void setAllowPaths(List<String> allowPaths) {
        this.allowPaths = allowPaths;
    }

    private List<String> allowPaths;


}
