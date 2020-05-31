package be.ucll.ip.task.controller;


import be.ucll.ip.task.domain.Task;
import be.ucll.ip.task.model.SubTaskDTO;
import be.ucll.ip.task.model.TaskDTO;
import be.ucll.ip.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

@Controller
@RequestMapping(value={"/tasks","/"})
public class TaskController {
    @Autowired
    private TaskService taskService;


    @GetMapping
    public String getTasks(Model model) {
        model.addAttribute("tasks", taskService.getTasks());
        return "tasks";
    }

    @GetMapping("/{id}")
    public String getTask(Model model, @PathVariable("id") Integer id) {
        if(taskService.getTask(id)!=null) {
            TaskDTO task = taskService.getTask(id);
            model.addAttribute("task", task);
            model.addAttribute("subtasks", task.getSubtasks());
            return "task";
        }

        model.addAttribute("task", null);
        model.addAttribute("subtasks", null);
        return "task";
    }
    @GetMapping("/new")
    public String addTaskPage(Model model) {
        model.addAttribute("taskDTO",new Task());
        return "addTask";
    }


    @PostMapping("/new")
    public String addTask(@ModelAttribute @Valid TaskDTO task,BindingResult bindingresult, Model model){


        if(bindingresult.hasErrors()){
            return "addTask";
        }


        taskService.addTask(task);

        return "redirect:/tasks";
    }

    @PostMapping("/{id}/sub/createsubtask")
    public String addSubTask(@ModelAttribute @Valid SubTaskDTO subtaskDTO,BindingResult bindingresult,@PathVariable Integer id, Model model){

        if(id==null){
            return this.getTasks(model);
        }


        if(bindingresult.hasErrors()){
            model.addAttribute("task", taskService.getTask(id));
            return "addSubTask";
        }
    taskService.addSubtask(id, subtaskDTO);
       return "redirect:/tasks/" + id;
    }



    @GetMapping("/{id}/sub/create")
    public String addSubTaskPage(Model model, @PathVariable Integer id) {

        if(taskService.getTask(id)==null){
            return this.getTasks(model);
        }
        TaskDTO task = taskService.getTask(id);
        model.addAttribute("task", task);
        model.addAttribute("subtaskDTO",new SubTaskDTO());

        return "addSubTask";
    }


 @GetMapping("/edit/{id}")
    public String editTaskPage(Model model, @PathVariable Integer id) {
        model.addAttribute("task",taskService.getTask(id));
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String editTask(@PathVariable Integer id, @RequestParam("title")String title, @RequestParam("description") String description, @RequestParam("time")LocalDateTime time, Model model) {

        if(title.trim().isEmpty() || description.trim().isEmpty()){
            model.addAttribute("task",taskService.getTask(id));
            return "edit";

        }
        TaskDTO t=taskService.getTask(id);
        t.setTitle(title);
        t.setDescription(description);
        t.setTime(time);

        taskService.editTask(t);

        return "redirect:/tasks/" + id;
    }







}


