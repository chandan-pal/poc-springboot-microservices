package in.chandanpal.todo.users.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.chandanpal.todo.users.model.User;
import in.chandanpal.todo.users.repository.UserRepository;

@RestController
@RequestMapping("/")
public class UserDetailsService {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/users/{userId}")
	public User getUser(@PathVariable("userId") String userId) {
		return userRepository.findByEmail(userId);
	}
	
}
