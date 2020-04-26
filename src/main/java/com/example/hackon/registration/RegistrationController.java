package com.example.hackon.registration;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.StringWriter;


/**
 * @author jjh2kor
 *
 */
@RestController
public class RegistrationController {

    @Autowired private VelocityEngine velocityEngine;
    
       
    @RequestMapping("/registration")
    public String registration() {

        Template template = velocityEngine.getTemplate("templates/registration.vm");
        VelocityContext context = new VelocityContext();
        StringWriter writer = new StringWriter();
        template.merge(context, writer);
       
        return writer.toString();
        
    }
 
}
