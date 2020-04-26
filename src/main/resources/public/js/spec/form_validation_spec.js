describe("validate First Name- First Name should not be empty and can contain alphabets, numbers & space.", function() {
	
    beforeEach(function () {
    	var value =  "Some name";
		jasmine.getFixtures('/../../templates/registration.vm');
		setFixtures($('<input id="firstName" type="text" />').val(value));
	    
    	$('<input id="firstName" type="text" />').trigger( "onblur" );
    	
    });
    
    
	it("Validation for First Name. First Name should contain some values.", function() {
		spyEvent = spyOnEvent('#firstName', 'onblur');
	
		expect( validateFirstName() ).toEqual(true); 
	}); 
	
	it("Validation for First Name. First name can contain alphabets, numbers and space.", function() {
		
		expect( validateFirstName() ).toEqual(true); 
	}); 
});

describe("validate First Name - First name field cannot be empty and cannot contain special characters.", function() {
	
    beforeEach(function () {
    	
		jasmine.getFixtures('/../../templates/registration.vm');
		 
    	$('<input id="firstName" type="text" />').trigger( "onblur" );
    	
    });
    
	it("Validation for First Name. First name should not be empty. Show error message.", function() {
		var value =  "";
		setFixtures($('<input id="firstName" type="text" />').val(value));
		$("#firstName").blur();
		var error = "";
		var val = $('<input id="error_first" type="text" />').val();
		expect(val).toContainText(error);
		//expect(error).toEqual("Please enter First name.");
	});
	
	it("Validation for First Name. First name should not be empty. Return false.", function() {
		var value =  "";
		setFixtures($('<input id="firstName" type="text" />').val(value));
		
		var error = $('<input id="error_first" type="text" />');
		expect( validateFirstName() ).toEqual(false); 
	});
	
	it("Validation for First Name. Special characeters are not allowed.", function() {
		var value =  "S&*(";
		setFixtures($('<input id="firstName" type="text" />').val(value));
		expect( validateFirstName() ).toEqual(false); 
	}); 
	
	
	
});

describe("validate Last Name- Last Name should not be empty and can contain alphabets, numbers & space.", function() {
	
    beforeEach(function () {
    	var value =  "last name";
		jasmine.getFixtures('/../../templates/registration.vm');
		setFixtures($('<input id="lastName" type="text" />').val(value));
	    
    	$('<input id="lastName" type="text" />').trigger( "onblur" );
    	
    });
    	
	it("Validation for last Name. Last name should contain some values", function() {
		
	
		expect( validateLastName() ).toEqual(true); 
	}); 
	
	it("Validation for last Name. Last name can contain alphabets, numbers and space.", function() {
		
		expect( validateLastName() ).toEqual(true); 
	}); 
});

describe("validate Last Name - Last name field cannot be empty and canot have special characters.", function() {
	
    beforeEach(function () {
    	
		jasmine.getFixtures('/../../templates/registration.vm');
		var value =  "";
		setFixtures($('<input id="lastName" type="text" />').val(value));
	
    });
    
	
	
	it("Validation for last Name. Last name should not be empty. Return false.", function() {
		
		var value =  "";
		setFixtures($('<input id="lastName" type="text" />').val(value));
	
		$('<input id="lastName" type="text" />').trigger( "onblur" );
		   
		var error = $('<input id="error_first" type="text" />');
		expect( validateLastName() ).toEqual(false); 
	});
	
	it("Validation for last Name. Special characeters are not allowed.", function() {
		var value =  "S&*(";
		setFixtures($('<input id="lastName" type="text" />').val(value));
		expect( validateLastName() ).toEqual(false); 
	}); 
	
	
	
});

describe("validate Email- Email is mandatory and should contain valid email address.", function() {
	
    beforeEach(function () {
    	var value =  "someone@someid.com";
		jasmine.getFixtures('/../../templates/registration.vm');
		setFixtures($('<input id="email" type="email" />').val(value));
	    
    	$('<input id="email" type="email" />').trigger( "onblur" );
    	
    });
    	
	it("Validation for email. Email Id should be filled.", function() {
		
		expect( validateEmail() ).toEqual(true); 
	}); 
	
	it("Validation for email. Email Id should contain valid address.", function() {
		
		expect( validateEmail() ).toEqual(true); 
	}); 
});

describe("Validate Email - Email field should not be empty and should not have invalid Email Address.", function() {
	
    beforeEach(function () {
    	
		jasmine.getFixtures('/../../templates/registration.vm');
		var value =  "";
		setFixtures($('<input id="email" type="email" />').val(value));
	
    });
    
	
	
	it("Validation Email address. Email address field should not be empty. Return false.", function() {
		
		var value =  "";
		setFixtures($('<input id="email" type="email"  />').val(value));
	
		$('<input id="email" type="email" />').trigger( "onblur" );
		   
		var error = $('<input id="error_first" type="text" />');
		expect( validateEmail() ).toEqual(false); 
	});
	
	it("Validation for last Name. Special characeters are not allowed.", function() {
		var value =  "_someaddress";
		setFixtures($('<input id="email" type="email" />').val(value));
		expect( validateEmail() ).toEqual(false); 
	}); 
	
	
	
});

describe("validate Phone Number- Phone number is not mandatory. Phone number should contain only 10 digits.", function() {
	
    beforeEach(function () {
    	var value =  "1234567890";
		jasmine.getFixtures('/../../templates/registration.vm');
		setFixtures($('<input id="phoneNumber" type="text" />').val(value));
	    
    	$('<input id="phoneNumber" type="text" />').trigger( "onblur" );
    	
    });
    
    
	it("Validation for Phone Number. Phone number should contain 10 digits", function() {
		spyEvent = spyOnEvent('#phoneNumber', 'onblur');
	
		expect( validatePhoneNumber() ).toEqual(true); 
	}); 
	
	it("Validation for Phone Number. Phone number field can be empty.", function() {
		var value =  "";
		setFixtures($('<input id="phoneNumber" type="text" />').val(value));
		  
		expect( validatePhoneNumber() ).toEqual(true); 
	}); 
});

describe("validate Phone Number- Phone number cannot contain alphabets, special characters and length has to be 10", function() {
	
    beforeEach(function () {
    	var value =  "12345678901";
		jasmine.getFixtures('/../../templates/registration.vm');
		setFixtures($('<input id="phoneNumber" type="text" />').val(value));
	    
    	$('<input id="phoneNumber" type="text" />').trigger( "onblur" );
    	
    });
    
    
	it("Validation for Phone Number. Phone number should contain only 10 digits", function() {
		spyEvent = spyOnEvent('#phoneNumber', 'onblur');
	
		expect( validatePhoneNumber() ).toEqual(false); 
	}); 
	
	it("Validation for Phone Number. Phone number field cannot contain alphabets, special character.", function() {
		var value =  "mynumber#ss";
		setFixtures($('<input id="phoneNumber" type="text" />').val(value));
		  
		expect( validatePhoneNumber() ).toEqual(false); 
	}); 
});

describe("validate Address- Address field is mandatory. Address can contain alphanumberic, special character and space.", function() {
	
    beforeEach(function () {
    	var value =  "124 street, town.";
		jasmine.getFixtures('/../../templates/registration.vm');
		setFixtures($('<input id="address" type="text" />').val(value));
	    
    	$('<input id="address" type="text" />').trigger( "onblur" );
    	
    });
    
    
	it("Validation for Address. Address field is mandatory.", function() {
		spyEvent = spyOnEvent('#address', 'onblur');
	
		expect( validateAddress() ).toEqual(true); 
	}); 
	
	it("Validation for Address Field. Address can contain alphanumberic, special characters-hash(#), comma (,) and space.", function() {
		var value =  "#125 street-, some town";
		setFixtures($('<input id="address" type="text" />').val(value));
		  
		expect( validateAddress() ).toEqual(true); 
	}); 
});

describe("validate Address- Address field should not be empty and should not contain special characters like $&()", function() {
	
    beforeEach(function () {
    	var value =  "";
		jasmine.getFixtures('/../../templates/registration.vm');
		setFixtures($('<input id="address" type="text" />').val(value));
	    
    	$('<input id="address" type="text" />').trigger( "onblur" );
    	
    });
    
    
	it("Validation for Address. Address field is mandatory.", function() {
		spyEvent = spyOnEvent('#address', 'onblur');
	
		expect( validateAddress() ).toEqual(false); 
	}); 
	
	it("Validation for Address. Address field should not contain special characters like $&()", function() {
		spyEvent = spyOnEvent('#address', 'onblur');
		var value =  "$123 street";
		$('<input id="address" type="text" />').trigger( "onblur" );
    	
		expect( validateAddress() ).toEqual(false); 
	}); 
	
	
});

describe("validate Pincode- Pincode field is mandatory. Pincode should be digit and length 5 or 6.", function() {
	
    beforeEach(function () {
    	var value =  "71723";
		jasmine.getFixtures('/../../templates/registration.vm');
		setFixtures($('<input id="pincode" type="text" />').val(value));
	    
    	$('<input id="pincode" type="text" />').trigger( "onblur" );
    	
    });
    
    
	it("Validation for Pincode. Pincode field is mandatory.", function() {
		spyEvent = spyOnEvent('#pincode', 'onblur');
	
		expect( validatePincode() ).toEqual(true); 
	}); 
	
	it("Validation for Pincode Field. Pincode should be digit and length 5 or 6.", function() {
		  
		expect( validatePincode() ).toEqual(true); 
	}); 
});

describe("validate Pincode- Pincode field should not be empity and should not contain alphabets & sppecial characters.", function() {
	
    beforeEach(function () {
    	var value =  "";
		jasmine.getFixtures('/../../templates/registration.vm');
		setFixtures($('<input id="pincode" type="text" />').val(value));
	    
    	$('<input id="pincode" type="text" />').trigger( "onblur" );
    	
    });
    
    
	it("Validation for Pincode. Pincode field is mandatory.", function() {
		spyEvent = spyOnEvent('#pincode', 'onblur');
	
		expect( validatePincode() ).toEqual(false); 
	}); 
	
	it("Validation for Pincode Field. Pincode should be digit and length 5 or 6.", function() {
		var value =  "pincode";

    	$('<input id="pincode" type="text" />').trigger( "onblur" );
      
		expect( validatePincode() ).toEqual(false); 
	}); 
});

describe("validate City- City field is mandatory. City can contain alphanumeric, space and dot.", function() {
	
    beforeEach(function () {
    	var value =  "St florance";
		jasmine.getFixtures('/../../templates/registration.vm');
		setFixtures($('<input id="city" type="text" />').val(value));
	    
    	$('<input id="city" type="text" />').trigger( "onblur" );
    	
    });
    
    
	it("Validation for city. city field is mandatory.", function() {
		spyEvent = spyOnEvent('#city', 'onblur');
	
		expect( validateCity() ).toEqual(true); 
	}); 
	
	it("Validation for city Field. City can contain alphanumeric, space and dot.", function() {
		  
		expect( validateCity() ).toEqual(true); 
	}); 
});

describe("validate City- City field should not be empty and can contain alphabet, space and dot.", function() {
	
    beforeEach(function () {
    	var value =  "St florance";
		jasmine.getFixtures('/../../templates/registration.vm');
		setFixtures($('<input id="city" type="text" />').val(value));
	    
    	$('<input id="city" type="text" />').trigger( "onblur" );
    	
    });
    
    
	it("Validation for city. city field should not be empty.", function() {
		spyEvent = spyOnEvent('#city', 'onblur');
		var value =  "";
		setFixtures($('<input id="city" type="text" />').val(value));
	    
		expect( validateCity() ).toEqual(false); 
	}); 
	
	it("Validation for city Field. City cannot contain special characters, numbers or start with space", function() {
		var value =  " stutt gart";
		setFixtures($('<input id="city" type="text" />').val(value));
	      
		expect( validateCity() ).toEqual(false); 
	}); 
}); 

describe("validate Country- Country should be selected from the list.", function() {
	
    beforeEach(function () {
    	
		jasmine.getFixtures('/../../templates/registration.vm');
		$('<select id="country" type="text" />').trigger( "onblur" );
    	
    });
    
    
	it("Validation for country. Country field should not be empty.", function() {
		spyEvent = spyOnEvent('#country', 'onblur');
		
		setFixtures($('<select id="country" type="text" />').val('Germany'));
		
		expect( validateCountry() ).toEqual(true); 
	}); 
	
	
}); 

