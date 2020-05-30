package be.ucll.ip.task.model.domain;

import be.ucll.ip.task.domain.SubTask;
import be.ucll.ip.task.domain.Task;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class SubTaskTests {
    private SubTask subTask = new SubTask();

    @Test
    public void setAndGetIdTest(){
        subTask.setSubtaskId(123);
        assertEquals(123,subTask.getSubtaskId());
    }

    @Test
    public void setAndGetTitleTest(){
        subTask.setTitle("Title");
        assertNotNull(subTask.getTitle());
        assertEquals("Title",subTask.getTitle());
    }

    @Test
    public void setAndGetDescriptionTest(){
        subTask.setDescription("desc");
        assertNotNull(subTask.getDescription());
        assertEquals("desc",subTask.getDescription());
    }

    @Test
    public void setAndGetTaskTest(){
        Task t =new Task();

        assertNull(subTask.getTask());
        subTask.setTask(t);
        assertNotNull(subTask.getTask());



    }




}
