package in.chandanpal.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import in.chandanpal.todo.model.User;
import in.chandanpal.todo.model.UserTasks;

@Controller
public class ViewController {

	@Autowired
	UserService userService;
	
	@Autowired
	TasksService taskService;
	
	@GetMapping(value = { "/", "/MyTasks" })
	public ModelAndView getMyTasksView() {
		return new ModelAndView("view/MyTasks");

	}

	@PostMapping("/MyTasks")
	public ModelAndView myTasksView(@RequestParam("userEmail") String userEmail) {
		ModelAndView myTasks = new ModelAndView();
		User user = userService.getUserInfo(userEmail);
		UserTasks userTasks = taskService.getTasksInfo(userEmail);
		myTasks.addObject("user", user);
		myTasks.addObject("userTasks", userTasks);
		myTasks.setViewName("view/MyTasks");
		return myTasks;
	}

	
	public ModelAndView fallbackMyTasksView(@RequestParam("userEmail") String userEmail) {
		System.out.println("Inside fallback method...");
		ModelAndView myTasks = new ModelAndView();
		myTasks.setViewName("view/MyTasks");
		return myTasks;
	}
}
