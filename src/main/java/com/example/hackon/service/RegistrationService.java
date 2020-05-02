package com.example.hackon.service;

import java.util.HashMap;
import java.util.Map;

import org.jvnet.hk2.annotations.Service;
import org.springframework.stereotype.Component;

import com.example.hackon.model.RegisteredUser;


@Service
@Component
public class RegistrationService {
    private Map <String, RegisteredUser > userHM = new HashMap<String, RegisteredUser>();
	

	
       
    
	public void updateUserDetails(RegisteredUser registrationFormDetails) {
		if(!registrationFormDetails.getEmail().isEmpty()) 
			userHM.put(registrationFormDetails.getEmail(), registrationFormDetails);
	       
       return;
    }
	
	public RegisteredUser getUserDetails (String strID) {
			
		 if(userHM != null) {
			 return userHM.get(strID);
		}
		
		 return new RegisteredUser();
	}
}
