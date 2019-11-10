package in.chandanpal.todo.tasks.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.chandanpal.todo.tasks.model.UserTasks;
import in.chandanpal.todo.tasks.repository.TaskRepository;

@RestController
@RequestMapping("/")
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	
	@GetMapping("user/{userId}/tasks")
	public UserTasks getTaskForUser(@PathVariable("userId") long userId) {
		UserTasks userTasks = new UserTasks();
		userTasks.setUserTasks(taskRepository.findByUserId(userId));
		return userTasks;
		
	}
}
