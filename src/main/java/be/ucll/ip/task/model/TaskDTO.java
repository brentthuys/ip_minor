package be.ucll.ip.task.model;


import org.springframework.format.annotation.DateTimeFormat;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class TaskDTO {
    private int id;

    @NotBlank(message = "title cant be empty")
    private String title;
    @NotBlank(message = "descrption cant be empty")
    private String description;
    private List<SubTaskDTO> subtasks =new ArrayList<>();

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime time;

    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d u 'at' h a");

    public String getFormattedDate(){
        return time.format(formatter);
    }



    public TaskDTO(String title, LocalDateTime time, String description, int id) {
        this.title = title;
        this.time = time;
        this.description = description;
        this.id = id;
    }



    public TaskDTO(){

    }




    public String getDescription() {
        return description;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {

        this.title = title;

    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public List<SubTaskDTO> getSubtasks() {
        return subtasks;
    }

    public void addSubtask(SubTaskDTO subtask) {
        subtasks.add(subtask);
    }

    public void setSubTasks(List<SubTaskDTO> subTasks) {
        this.subtasks = subTasks;
    }
}
