package be.ucll.ip.task.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;




@Entity
@Table(name = "SUB_TASKS")
public class SubTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subtaskId;

    @NotBlank
    private String title;
    @NotBlank
    private String description;


    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Task.class)
    @JoinColumn(name ="taskid", nullable = false)
    private Task task;




    public SubTask(String title, String description, int subtaskId){
        setTitle(title);
        setDescription(description);
        setSubtaskId(subtaskId);
            }

    public SubTask(){}



    public int getSubtaskId() {
        return subtaskId;
    }

    public void setSubtaskId(int subtaskId) {
        this.subtaskId = subtaskId;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
