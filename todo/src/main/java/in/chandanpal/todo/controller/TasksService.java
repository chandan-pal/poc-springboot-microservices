package in.chandanpal.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import in.chandanpal.todo.model.UserTasks;

@Service
public class TasksService {
	@Autowired
	public RestTemplate restTemplate;

	public TasksService() {
	}
	
	@HystrixCommand(
			fallbackMethod = "fallbackTasksInfo",
			threadPoolKey = "userInfoPool",
			threadPoolProperties = {
				@HystrixProperty(name = "coreSize", value = "20"),
				@HystrixProperty(name = "maxQueueSize", value ="10")
			}
	)
	public UserTasks getTasksInfo(String userEmail) {
		return restTemplate.getForObject("http://tasks-service/user/" + userEmail + "/tasks", UserTasks.class);
	}
	
	//fallback method for circuit breaker
	public UserTasks fallbackTasksInfo(String userEmail) {
		System.out.println("inside fallbackTasksInfo userEmail=" + userEmail);
		return null;
	}
}