package com.bala.MindTracker.repository;

import com.bala.MindTracker.model.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<TaskModel , Long> {
    List<TaskModel> findAllById(Long id);
}
