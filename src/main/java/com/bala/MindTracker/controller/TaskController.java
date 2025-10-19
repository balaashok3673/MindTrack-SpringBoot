package com.bala.MindTracker.controller;

import com.bala.MindTracker.model.TaskModel;
import com.bala.MindTracker.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService=taskService;
    }

    @GetMapping("/get/{id}")
    public TaskModel getTaskByID(@PathVariable Long id ){
        return taskService.getTaskByID(id);
    }

    @GetMapping("/get/list")
    public List<TaskModel> listAllTask(){
        return taskService.listTask();
    }

    @PostMapping("/post")
    public String addTask(@RequestBody TaskModel taskModel){
        taskService.addTask(taskModel);
        return "Task has been added";
    }

    @PutMapping("/update/task/{id}")
    public String updateTask(@PathVariable Long id , @RequestBody TaskModel taskModel){
        taskService.updateTask(id, taskModel);
        return "Task has been updated";
    }

}
