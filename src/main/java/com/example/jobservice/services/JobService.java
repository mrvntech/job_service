package com.example.jobservice.services;

import com.example.jobservice.dto.request.job.CreateJobRequestBody;
import com.example.jobservice.dto.response.job.CreateJobResponseBody;
import com.example.jobservice.dto.response.job.GetJobResponseBody;
import com.example.jobservice.entities.Job;
import jakarta.transaction.Transactional;

import java.util.List;

public interface JobService {
    @Transactional
    CreateJobResponseBody createJob(CreateJobRequestBody requestBody);
    @Transactional
    GetJobResponseBody getJob(Long id);
    @Transactional
    List<Job> getAllJob();
}
