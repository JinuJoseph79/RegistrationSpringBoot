package com.example.hackon.registration;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.ext.RuntimeDelegate;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.VelocityException;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.glassfish.jersey.server.ResourceConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.ui.velocity.VelocityEngineFactoryBean;

import com.example.hackon.ApplicationBootstrap;
import com.example.hackon.JerseyConfig;
import com.example.hackon.model.RegistrationFormDetails;
import com.example.hackon.service.RegistrationService;


//@RunWith(SpringJUnit4ClassRunner.class)
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationBootstrap.class) 
@ContextConfiguration(classes = JerseyConfig.class)
@WebAppConfiguration   // 3
@IntegrationTest("server.port:0")

public class RegistrationResourceTest extends JerseyTest {
	
	@Autowired 
	private ApplicationContext applicationContext;
	
	
	@Override
	public Application configure() {
	   
		return new JerseyConfig();
	 }
	

    @Before
    public void setUp() throws Exception{
        super.setUp();
    }
    
    @Test
    public void TestupdateUserDetails() {
    	RegistrationService service = new RegistrationService();
    	Map <String, RegistrationFormDetails > userHM = new HashMap<String, RegistrationFormDetails>();
    	RegistrationFormDetails registrationFormDetails = new RegistrationFormDetails();
		registrationFormDetails.setFirstName("name");
		registrationFormDetails.setEmail("someone@gmail.com");
	
    	
    	service.updateUserDetails(registrationFormDetails);	
    	RegistrationFormDetails userdetails = service.getUserDetails("someone@gmail.com");
    	assertEquals("Check the returned values from hashmap", "name", userdetails.getFirstName());
    	
    	
    }
  
    /*@Test
	public void TestSave () {
		//Create object of RegistrationFormDetails
		RegistrationFormDetails registrationFormDetails = new RegistrationFormDetails();
		registrationFormDetails.setFirstName("name");
		registrationFormDetails.setEmail("someone@gmail.com");
		Form form = new Form();
	    form.param("firstName", "name");
	    form.param("lastName", "name2");
	    form.param("email", "name@gmail.com");
	    form.param("city", "city1");
	    form.param("lastName", "");
	    form.param("lastName", "");
	    form.param("lastName", "");
	    form.param("lastName", "");
	  	//Post to target and get the response 
	    Response response = target("rest/registration/register").request().post(Entity.form(form));
	    //Validate response
	    assertEquals("Should return status 201", 201, response.getStatus());
		
	}
	
	//@Test
	public void registrationTest() {
		VelocityEngine velocityEngine = new VelocityEngine();
		
		velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "class,file");
	    velocityEngine.setProperty(RuntimeConstants.RUNTIME_LOG_LOGSYSTEM_CLASS, "org.apache.velocity.runtime.log.Log4JLogChute");
	    velocityEngine.setProperty("runtime.log.logsystem.log4j.logger", "VELLOGGER");
	    velocityEngine.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
	    velocityEngine.setProperty("runtime.log.logsystem.class", "org.apache.velocity.runtime.log.NullLogSystem");
	    velocityEngine.init();
	    //Generate the html from template
		Template template = velocityEngine.getTemplate("templates/registration.vm");
	     VelocityContext context = new VelocityContext();
	     StringWriter writer = new StringWriter();
	     template.merge(context, writer);
	     //Save registration html page in resources folder
	     //Compare HTML generated from template with saved template
	     BufferedReader bufferRd = null;
	     StringReader stringRd = null;
	     try {
			bufferRd = new BufferedReader(new FileReader("/../resource/registration.html"));
		 } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
		 }
            
         String inputLine = null;
         StringBuilder builder = new StringBuilder();
         stringRd = new StringReader(builder.toString());
          //Compare HTML generated from template with saved template
	      
	     assertEquals("Comparing resulting page",stringRd, writer.toString());
		
	}*/
}
