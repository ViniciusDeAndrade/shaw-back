package com.shaw.partners.proxy.control;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.shaw.partners.proxy.model.Repo;
import com.shaw.partners.proxy.model.User;
import com.shaw.partners.proxy.service.RestService;

@RestController
public class Control {

	private RestService restService = new RestService();

	@CrossOrigin("http://localhost:4200")
	@GetMapping("/users/{since}")
	public List<User> getUser(@PathVariable(value = "since") int since) {
		return this.restService.getUsers(since);
	}
	
	@CrossOrigin("http://localhost:4200")
	@GetMapping("/user/{username}")
	public User getUser(@PathVariable (value = "username") String username) {
		return this.restService.getUser(username);
	}
	
	@CrossOrigin("http://localhost:4200")
	@GetMapping("/user/{username}/repo")
	public List<Repo> getUserRepo(@PathVariable (value = "username") String username) {
		return this.restService.getUserRepo(username);
	}	

}
