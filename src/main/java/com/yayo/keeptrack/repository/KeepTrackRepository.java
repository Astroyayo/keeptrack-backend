package com.yayo.keeptrack.repository;

import com.yayo.keeptrack.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeepTrackRepository extends JpaRepository<Task, Long> {}
