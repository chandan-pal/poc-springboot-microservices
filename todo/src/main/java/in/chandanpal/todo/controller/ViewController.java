package in.chandanpal.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import in.chandanpal.todo.model.User;
import in.chandanpal.todo.model.UserTasks;

@Controller
public class ViewController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/MyTasks")
	public ModelAndView getMyTasksView() {
		return new ModelAndView("view/MyTasks");
		
	}
	
	@PostMapping("/MyTasks")
	public ModelAndView myTasksView(@RequestParam("userEmail") String userEmail) {
		ModelAndView myTasks = new ModelAndView();
		User user = restTemplate.getForObject("http://localhost:8032/users/" + userEmail, User.class);
		UserTasks userTasks = restTemplate.getForObject("http://localhost:8031/user/" + user.getUser_id() + "/tasks", UserTasks.class);
		myTasks.addObject("user", user);
		myTasks.addObject("userTasks", userTasks);
		return new ModelAndView("view/MyTasks");
		
	}
}
