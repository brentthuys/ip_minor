package be.ucll.ip.task.domain;


import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TASKS")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "title cant be empty")
    private String title;

    @NotBlank(message = "descrption cant be empty")
    private String description;

    @OneToMany(mappedBy = "task", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<SubTask> subtasks;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime time;



    public Task (String title, String description, LocalDateTime time ,int id){
        setTitle(title);
        setDescription(description);
        setTime(time);
        setId(id);
        subtasks= new ArrayList<>();
    }

    public Task(){}





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

    public List<SubTask> getSubtasks() {
        return subtasks;
    }

    public void addSubtask(SubTask subtask) {
        System.out.println(subtask.getSubtaskId());
       {subtasks.add(subtask);}

    }



}
