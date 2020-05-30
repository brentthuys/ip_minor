package be.ucll.ip.task.service;

import be.ucll.ip.task.domain.SubTask;
import be.ucll.ip.task.domain.Task;
import be.ucll.ip.task.model.SubTaskDTO;
import be.ucll.ip.task.model.TaskDTO;
import be.ucll.ip.task.repository.SubTaskRepository;
import be.ucll.ip.task.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private  TaskRepository repository;

    @Autowired
    private  SubTaskRepository subTaskRepository;





    @Override
    public List<TaskDTO> getTasks() {

        return repository.findAll().stream().map(h -> taskConverter(h)).collect(Collectors.toList());
    }

    @Override
    public TaskDTO getTask(int id) {


        try {
            Task h = repository.getOne(id);
            return this.taskConverter(h);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;



    }

    @Override
    public void addTask(TaskDTO taskdto) {
        Task t = new Task();

        t.setTime(taskdto.getTime());
        t.setId(t.getId());
        t.setDescription(taskdto.getDescription());
        t.setTitle(taskdto.getTitle());

        repository.save(t);
    }

    @Override
    public void editTask(TaskDTO taskdto) {
        Task t = repository.getOne(taskdto.getId());

        t.setTime(taskdto.getTime());
        t.setId(t.getId());
        t.setDescription(taskdto.getDescription());
        t.setTitle(taskdto.getTitle());
        repository.save(t);

    }


    @Override
    public void addSubtask(int id, SubTaskDTO subtaskdto) {
        Task task= repository.getOne(id);

        SubTask t = new SubTask();
        t.setDescription(subtaskdto.getDescription());
        t.setTitle(subtaskdto.getTitle());
        t.setSubtaskId(subtaskdto.getSubtaskId());
        t.setTask(task);



        subTaskRepository.save(t);


    }


    private SubTaskDTO subTaskConverter(SubTask subTask){
        SubTaskDTO subTaskDTO = new SubTaskDTO();
        subTaskDTO.setSubtaskId(subTask.getSubtaskId());
        subTaskDTO.setTitle(subTask.getTitle());
        subTaskDTO.setDescription(subTask.getDescription());
        return subTaskDTO;
    }

    private TaskDTO taskConverter(Task task){
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(task.getId());
        taskDTO.setTitle(task.getTitle());
        taskDTO.setDescription(task.getDescription());
        taskDTO.setTime(task.getTime() );
        if(task.getSubtasks() !=null) {
            taskDTO.setSubTasks(task.getSubtasks().stream().map(subTask -> subTaskConverter(subTask)).collect(Collectors.toList()));
        }
        return taskDTO;
    }


}


