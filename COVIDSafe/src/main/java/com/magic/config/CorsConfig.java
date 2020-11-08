package com.magic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


@Configuration
@SuppressWarnings("unused")
public class CorsConfig {
    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        // 1 Allow any domain to be used
        corsConfiguration.addAllowedOrigin("*");
        // 2 Allow any head
        corsConfiguration.addAllowedHeader("*");
        // 3 Allow ajax asynchronous requests with cookie information
        corsConfiguration.setAllowCredentials(true);
        // 4 Allow any method (post, get, etc.)
        corsConfiguration.addAllowedMethod("*");
        return corsConfiguration;
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig());
        return new CorsFilter(source);
    }
}
