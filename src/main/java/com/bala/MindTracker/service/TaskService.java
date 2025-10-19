package com.bala.MindTracker.service;

import com.bala.MindTracker.model.TaskModel;
import com.bala.MindTracker.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository=taskRepository;
    }


    public List<TaskModel> listTask(){
        return taskRepository.findAll();
    }

    public TaskModel getTaskByID(Long id){
        return taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public String  addTask(TaskModel taskModel){
         taskRepository.save(taskModel);
         return "Task has been saved successfully";
    }

    public String deleteTask(Long id){
      if (taskRepository.findById(id).isPresent()){
          taskRepository.deleteById(id);
      }else {
          throw new RuntimeException("Task ID not found");
      }
      return "Task has been deleted";
    }

    public String updateTask(Long id , TaskModel existingTask) {
        TaskModel isTaskInDB = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));

        isTaskInDB.setTaskName(existingTask.getTaskName());
        isTaskInDB.setTaskDescription(existingTask.getTaskDescription());
        isTaskInDB.setTaskStatus(existingTask.isTaskStatus());

        taskRepository.save(isTaskInDB);

        return "Task has been updated successfully";
    }
}
