package com.example.hackon.registration;

import java.io.IOException;
import java.io.StringWriter;

import java.net.URISyntaxException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.hackon.model.RegisteredUser;
import com.example.hackon.model.UsersRepository;
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

	@Autowired
	UsersRepository userRepo;

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/Employees")
	public List<RegisteredUser> getEmployee() {

		List<RegisteredUser> empList = (List<RegisteredUser>) userRepo.findAll();
		return empList;
	}

	@Autowired
	private VelocityEngine velocityEngine;

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/register")
	public Response save(MultivaluedMap<String, String> formParams, @Context HttpServletResponse servletRes)
			throws IOException, URISyntaxException {

		RegisteredUser regUser = new RegisteredUser();

		regUser.setFirst_name(formParams.getFirst("firstName"));
		regUser.setLastname(formParams.getFirst("lastName"));
		regUser.setEmail(formParams.getFirst("email"));
		regUser.setPassword(formParams.getFirst("password"));
		regUser.setConfirmpassword(formParams.getFirst("confirmPassword"));
		regUser.setAddress(formParams.getFirst("address"));
		regUser.setPincode(Integer.parseInt(formParams.getFirst("pincode")));
		regUser.setCity(formParams.getFirst("city"));
		regUser.setCountry(formParams.getFirst("country"));
		regUser.setPhonenumber(Integer.parseInt(formParams.getFirst("phoneNumber")));
		// Save the registered user details to registered_user table
		userRepo.save(regUser);
		// Save the registered user details to hashmap - To be removed
		registrationService.updateUserDetails(regUser);
		return Response.ok(getHtmlResponse(regUser)).build();

	}

	private String getHtmlResponse(RegisteredUser regUser) {

		Template template = velocityEngine.getTemplate("templates/registerSuccessful.vm");

		VelocityContext context = new VelocityContext();
		StringWriter writer = new StringWriter();

		context.put("firstName", regUser.getFirst_name());
		context.put("lastName", regUser.getLastname());
		context.put("email", regUser.getEmail());
		context.put("phoneNumber", regUser.getPhonenumber());
		context.put("address", regUser.getAddress());
		context.put("pincode", regUser.getPincode());
		context.put("city", regUser.getCity());
		context.put("country", regUser.getCountry());
		template.merge(context, writer);
		return writer.toString();

	}

}
