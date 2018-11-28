package com.shaw.partners.proxy.service;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.shaw.partners.proxy.model.Repo;
import com.shaw.partners.proxy.model.User;

@Component
public class RestService { // implements CommandLineRunner {

	private static final String BASE_URL = "https://api.github.com/users";

	// private static void callRestService() {}

	public List<User> getUsers(int since) {
		if (since < 0)
			since = 0;
		RestTemplate rest = new RestTemplate();

		ResponseEntity<List<User>> response = rest.exchange(BASE_URL + "?since=" + String.valueOf(since),
				HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {
				});

		List<User> users = response.getBody();
		return users;
	}
	public List<Repo> getUserRepo(String username) {
		if (username.isEmpty())
			return null;
		RestTemplate rest = new RestTemplate();
		
		ResponseEntity<List<Repo>> response = rest.exchange(BASE_URL + "/" + username + "/repos",
				HttpMethod.GET, 
				null, 
				new ParameterizedTypeReference<List<Repo>>() {});
		
		List<Repo> repos = response.getBody();
		return repos;

		
	}

	public User getUser(String username) {
		if (username.isEmpty())
			return null;

		RestTemplate rest = new RestTemplate();
		User user = rest.getForObject(BASE_URL + "/" + username, User.class);
		return user;
	}


	/*
	 * @Override public void run(String... args) throws Exception {
	 * callRestService();
	 * 
	 * }
	 */
}
