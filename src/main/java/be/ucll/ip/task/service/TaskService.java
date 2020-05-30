package be.ucll.ip.task.service;

import be.ucll.ip.task.model.SubTaskDTO;
import be.ucll.ip.task.model.TaskDTO;

import java.util.List;

public interface TaskService {
     List<TaskDTO> getTasks();
     TaskDTO getTask(int id);
    void addTask(TaskDTO task);
    void editTask(TaskDTO task);
    void addSubtask(int id, SubTaskDTO subtask);


}
