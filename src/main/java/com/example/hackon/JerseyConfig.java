package com.example.hackon;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

import com.example.hackon.registration.RegistrationResource;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Path;


@Configuration
@ApplicationPath("/rest")
public class JerseyConfig extends ResourceConfig {

    @Autowired private ApplicationContext applicationContext;


    @PostConstruct
    public void registerResourcesAndProviders() {
        applicationContext.getBeansWithAnnotation(Path.class).values().forEach(this::register);
    }

    public JerseyConfig() {
    	register(RegistrationResource.class);

    }
}
