package com.ecomsite.api.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomsite.api.models.LoginUser;
import com.ecomsite.api.models.User;
import com.ecomsite.api.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost://5173", allowCredentials = "true")
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	UserService uServ;

	@PostMapping("/register")
	public ResponseEntity <Object> register(@Valid @RequestBody User newUser, 
			BindingResult result,
			HttpSession session) {

		// call a register method in the service
		User regUser = uServ.register(newUser, result);

		if (result.hasErrors()) {
			return ResponseEntity.status(400).body(result.getAllErrors());
		} else {
			session.setAttribute("userId", regUser.getId());
			session.setAttribute("userName", regUser.getFirstName());
			return ResponseEntity.ok().build();

		}

	}

	@PostMapping("/login")
	public ResponseEntity <Object> login(@Valid @RequestBody LoginUser newLogin, 
			BindingResult result, 
			HttpSession session) {

		// Add once service is implemented:
		User logUser = uServ.login(newLogin, result);
		
		if (result.hasErrors()) {
			return ResponseEntity.status(400).body(result.getAllErrors());
		} else {
			session.setAttribute("userId", logUser.getId());
			session.setAttribute("userName", logUser.getFirstName());
			return ResponseEntity.ok().build();

		}
		
//		create admin user from backend??
//	@PostMapping("/create")
		

	}

}
