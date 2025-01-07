package com.yayo.keeptrack.service;

import com.yayo.keeptrack.models.Task;
import com.yayo.keeptrack.repository.KeepTrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class KeepTrackService {

    private final KeepTrackRepository keepTrackRepository;

    @Autowired
    public KeepTrackService(KeepTrackRepository keepTrackRepository){
        this.keepTrackRepository = keepTrackRepository;
    }

    public Task getTaskById(Long id){
        return keepTrackRepository.findById(id).orElse(null);
    }

    public List<Task> getTasks(){
        return keepTrackRepository.findAll();
    }

    public Task addTask(Task task){
        return keepTrackRepository.save(task);
    }

    public Task updateTask(Long id, String newDescription, LocalDateTime newDueDate){
        Task task = keepTrackRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setDescription(newDescription);
        task.setDueDate(newDueDate);

        return keepTrackRepository.save(task);
    }

    public void deleteTask(Long id){
        keepTrackRepository.deleteById(id);
    }
}
