package be.ucll.ip.task.model.service;


import be.ucll.ip.task.model.TaskDTO;
import be.ucll.ip.task.repository.SubTaskRepository;
import be.ucll.ip.task.service.TaskService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TaskServiceTests {


    @Autowired
    private TaskService taskService;



    public int dbid=0;

    @BeforeAll
    void setup(){
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 05, 30, 17, 45);
        TaskDTO task = new TaskDTO("task1", localDateTime1, "task 1 description",1);
        taskService.addTask(task);
        dbid++;


    }



    @Test
    void getTasksTest(){

        assertEquals(dbid,taskService.getTasks().size());


    }


    @Test
    void addTask(){
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 05, 30, 17, 45);
        TaskDTO task = new TaskDTO("task2", localDateTime1, "task 2 description",2);

        int intitialSize = taskService.getTasks().size();

        taskService.addTask(task);

        TaskDTO dbTask = taskService.getTasks().get(dbid);
        dbid++;

        assertEquals( 2, taskService.getTasks().size());


        assertEquals(dbTask.getDescription(),task.getDescription());
        assertEquals(dbTask.getTime(),task.getTime());
        assertEquals(dbTask.getTitle(),task.getTitle());


    }


    @Test
    @Transactional
    void getTaskTest(){
        TaskDTO taskDTO = taskService.getTask(1);
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 05, 30, 17, 45);
        TaskDTO taskDTO1 = new TaskDTO("task1", localDateTime1, "task 1 description",1);

        assertNotNull(taskDTO);
        assertEquals(taskDTO1.getTitle(),taskDTO.getTitle());
        assertEquals(taskDTO1.getDescription(),taskDTO.getDescription());
        assertEquals(taskDTO1.getTime(),taskDTO.getTime());

    }


    @Test
    @Transactional
    void editTaskTest(){
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 05, 30, 17, 45);
        TaskDTO taskDTO1 = new TaskDTO("task2", localDateTime1, "task 2 description",1);

        taskService.editTask(taskDTO1);

        TaskDTO taskDTO = taskService.getTask(1);

        assertNotNull(taskDTO);
        assertEquals(taskDTO1.getTitle(),taskDTO.getTitle());
        assertEquals(taskDTO1.getDescription(),taskDTO.getDescription());
        assertEquals(taskDTO1.getTime(),taskDTO.getTime());

    }



}
