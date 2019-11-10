package in.chandanpal.todo.model;

import java.util.List;

public class UserTasks {
	private List<Task> tasks;

	public List<Task> getUserTasks() {
		return tasks;
	}

	public void setUserTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
}
