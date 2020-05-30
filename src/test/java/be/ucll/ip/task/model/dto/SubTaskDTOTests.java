package be.ucll.ip.task.model.dto;

import be.ucll.ip.task.domain.SubTask;
import be.ucll.ip.task.model.SubTaskDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SubTaskDTOTests {

        private SubTaskDTO subTask = new SubTaskDTO();

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

    }
