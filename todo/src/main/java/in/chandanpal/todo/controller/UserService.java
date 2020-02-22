package in.chandanpal.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import in.chandanpal.todo.model.User;

@Service
public class UserService {
	
	@Autowired
	public RestTemplate restTemplate;

	public UserService() {
	}
	
	@HystrixCommand(
			fallbackMethod = "fallbackUserInfo",
			threadPoolKey = "userInfoPool",
			threadPoolProperties = {
				@HystrixProperty(name = "coreSize", value = "20"),
				@HystrixProperty(name = "maxQueueSize", value ="10")
			}
	) 
	public User getUserInfo(String userEmail) {
		return restTemplate.getForObject("http://user-service/users/" + userEmail, User.class);
	}
	
	
	//fallback method for circuit breaker
	public User fallbackUserInfo(String userEmail) {
		System.out.println("inside fallbackUserInfo userEmail=" + userEmail);
		return null;
	}
}