package com.bolsadeideas.app.web;

import com.bolsadeideas.app.web.interceptors.HorarioInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MVCConfig implements WebMvcConfigurer {
    @Autowired
    @Qualifier("horario")
    private HandlerInterceptor horario;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(horario).excludePathPatterns("/cerrado");
    }
}
