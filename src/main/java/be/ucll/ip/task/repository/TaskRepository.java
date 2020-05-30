package be.ucll.ip.task.repository;

import be.ucll.ip.task.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TaskRepository extends JpaRepository<Task, Integer> {


}