package com.vits.EventCalendar.services.auth;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;
@Service
public class UserEmailValidation {
	String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
	        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
	
	public boolean validateEmail(String emailAddress) {
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(emailAddress);
        return matcher.matches();
	}
}
