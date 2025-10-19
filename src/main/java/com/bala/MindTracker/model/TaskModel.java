package com.bala.MindTracker.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import java.util.List;

@Entity
@Table(name ="tasks")
public class TaskModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter
    @Setter
    @Column(name ="task_name" , nullable = false)
    private String taskName;

    @Getter
    @Setter
    @Column(name="task_description" , nullable = false)
    private String taskDescription;

    @Getter
    @Setter
    @Column(name = "task_status" , nullable = false)
    private boolean taskStatus;


    public TaskModel(){
        //no-args constructor
    }

    public TaskModel(String taskName , String taskDescription , boolean taskStatus){
        this.taskName=taskName;
        this.taskDescription=taskDescription;
        this.taskStatus=taskStatus;
    }


    }


