package be.ucll.ip.task.model;

import javax.validation.constraints.NotBlank;





public class SubTaskDTO {

    private int subtaskId;


    @NotBlank (message = "{titleNotBlank}")
    private String title;
    @NotBlank (message = "{descriptionNotBlank}")
    private String description;



    public int getSubtaskId() {
        return subtaskId;
    }


    public void setSubtaskId(int subtaskId) {
        this.subtaskId = subtaskId;
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
