package com.example.jobservice.controllers;

import com.example.jobservice.dto.request.job.CreateJobRequestBody;
import com.example.jobservice.dto.response.job.CreateJobResponseBody;
import com.example.jobservice.dto.response.job.GetJobResponseBody;
import com.example.jobservice.entities.Job;
import com.example.jobservice.services.JobService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {
    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping("")
    public ResponseEntity<CreateJobResponseBody> createJob(@RequestBody CreateJobRequestBody requestBody){
        return ResponseEntity.ok().body(jobService.createJob(requestBody));
    }
    @GetMapping("")
    public ResponseEntity<List<Job>> getAllJob(){
        return ResponseEntity.ok().body(jobService.getAllJob());
    }
    @GetMapping("/{id}")
    public ResponseEntity<GetJobResponseBody> getJob(@PathVariable Long id){
        return ResponseEntity.ok().body(jobService.getJob(id));
    }
}
