package com.ecomsite.api.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.ecomsite.api.models.LoginUser;
import com.ecomsite.api.models.User;
import com.ecomsite.api.repositories.UserRepository;



@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepo;
    
    // TO-DO: Write register and login methods!
    public User register(User newUser, BindingResult result) {
        // find if user is in database
    	Optional <User> optionalUser = userRepo.findByEmail(newUser.getEmail());
//    	if email is present - reject
    	if(optionalUser.isPresent()) {
    		result.rejectValue("email", "unique", "this email already has an account");
    	}
    
//    	if results exist return null
    	if(result.hasErrors()) {
    		return null;
    	}
    	
//    	if no errors register
    	String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    	newUser.setPassword(hashed);
    	
    	return userRepo.save(newUser);
    	
    }
    
    public User login(LoginUser newLoginObject, BindingResult result) {
        // TO-DO: Additional validations!
    	Optional <User> optionalUser = userRepo.findByEmail(newLoginObject.getEmail());
    	if(result.hasErrors()) {
    		return null;
    	}
    	if(!optionalUser.isPresent()) {
    		result.rejectValue("email", "exists", "This email does not have an account");
    		return null;
    	}
    	User loggedUser = optionalUser.get();
    	if(!BCrypt.checkpw(newLoginObject.getPassword(), loggedUser.getPassword())) {
    	    result.rejectValue("password", "matches", "Invalid Password!");
    	    return null;
    	}
    	
    	return loggedUser;

        
    }
    
    public User getOne(Long id) {
    	return userRepo.findById(id).orElse(null);
    }
    
}
