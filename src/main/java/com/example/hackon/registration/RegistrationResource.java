package com.example.hackon.registration;

import java.io.IOException;
import java.io.StringWriter;

import java.net.URISyntaxException;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.hackon.model.RegistrationFormDetails;
import com.example.hackon.service.RegistrationService;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;



/**
 * @author jjh2kor
 *
 */
@Path("/registration")

public class RegistrationResource {

   
  // Extend the current resource to receive and store the data in memory.
  // Return a success information to the user including the entered information.
  // In case of the address split the information into a better format/structure
  // for better handling later on.
  @Autowired
  private RegistrationService registrationService;
  @Autowired private VelocityEngine velocityEngine;
  
  @POST
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  @Path("/register")

  public Response save(MultivaluedMap<String, String> formParams, @Context HttpServletResponse servletRes )throws IOException, URISyntaxException 
  {
	
	RegistrationFormDetails registrationFormDetails = new RegistrationFormDetails();
	
	registrationFormDetails.setFirstName(formParams.getFirst("firstName"));
	registrationFormDetails.setLastName(formParams.getFirst("lastName"));
	registrationFormDetails.setEmail(formParams.getFirst("email"));
	registrationFormDetails.setPassword(formParams.getFirst("password"));
	registrationFormDetails.setConfirmPassword(formParams.getFirst("confirmPassword"));
	registrationFormDetails.setAddress(formParams.getFirst("address"));
	registrationFormDetails.setPincode(formParams.getFirst("pincode"));
	registrationFormDetails.setCity(formParams.getFirst("city"));
	registrationFormDetails.setCountry(formParams.getFirst("country"));
	registrationFormDetails.setPhoneNumber(formParams.getFirst("phoneNumber"));
	
	registrationService.updateUserDetails(registrationFormDetails);
    return Response.ok(getHtmlResponse(registrationFormDetails)).build();
	
  }

  
  private String getHtmlResponse(RegistrationFormDetails registrationFormDetails) {
	  
	  Template template = velocityEngine.getTemplate("templates/registerSuccessful.vm");
      
      VelocityContext context = new VelocityContext();
      StringWriter writer = new StringWriter();
      
      context.put("firstName", registrationFormDetails.getFirstName());
      context.put("lastName", registrationFormDetails.getLastName());
      context.put("email", registrationFormDetails.getEmail());
      context.put("phoneNumber", registrationFormDetails.getPhoneNumber());
      context.put("address", registrationFormDetails.getAddress());
      context.put("pincode", registrationFormDetails.getPincode());
      context.put("city", registrationFormDetails.getCity());
      context.put("country", registrationFormDetails.getCountry());
      template.merge(context, writer);
      return writer.toString();
      
  }

}
