package in.chandanpal.todo.tasks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.chandanpal.todo.tasks.model.Task;

@Repository("userRepository")
public interface TaskRepository extends JpaRepository<Task, Long>{

	List<Task> findByTaskIdAndUserEmail(long taskId, String userEmail);

	List<Task> findByUserEmail(String userEmail);
	
}
