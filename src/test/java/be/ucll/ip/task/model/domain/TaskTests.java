package be.ucll.ip.task.model.domain;

import be.ucll.ip.task.domain.Task;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTests {

    private Task task = new Task();


    @Test
    public void setAndGetIdTest(){
        task.setId(1);
        assertEquals(1,task.getId());
    }
  @Test
    public void setAndGetTitleTest(){
        task.setTitle("Title");
        assertEquals("Title",task.getTitle());
    }
  @Test
    public void setAndGetTimeTest(){
      LocalDateTime t =  LocalDateTime.now();
        task.setTime(t);
        assertEquals(t,task.getTime());
    }
  @Test
    public void setAndGetDescriptionTest(){
        task.setDescription("Description");
        assertEquals("Description",task.getDescription());
    }












}
