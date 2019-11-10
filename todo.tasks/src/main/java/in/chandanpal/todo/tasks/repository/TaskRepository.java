package in.chandanpal.todo.tasks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.chandanpal.todo.tasks.model.Task;

@Repository("userRepository")
public interface TaskRepository extends JpaRepository<Task, Long>{

	List<Task> findByTaskIdAndUserId(long taskId, long userId);

	List<Task> findByUserId(long userId);
	
}
