package com.example.jobservice.repositories;

import com.example.jobservice.dto.request.job.CreateJobRequestBody;
import com.example.jobservice.dto.response.job.CreateJobResponseBody;
import com.example.jobservice.entities.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
}
