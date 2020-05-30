package be.ucll.ip.task.repository;

import be.ucll.ip.task.domain.SubTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubTaskRepository extends JpaRepository<SubTask, Integer> {
}
