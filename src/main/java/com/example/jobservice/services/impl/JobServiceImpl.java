package com.example.jobservice.services.impl;

import com.example.jobservice.dto.request.job.CreateJobRequestBody;
import com.example.jobservice.dto.response.job.CreateJobResponseBody;
import com.example.jobservice.dto.response.job.GetJobResponseBody;
import com.example.jobservice.entities.Job;
import com.example.jobservice.exception.exceptions.BadRequestException;
import com.example.jobservice.repositories.JobRepository;
import com.example.jobservice.services.JobService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {
    private final JobRepository jobRepository;
    private final ModelMapper modelMapper;

    public JobServiceImpl(JobRepository jobRepository, ModelMapper modelMapper) {
        this.jobRepository = jobRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CreateJobResponseBody createJob(CreateJobRequestBody requestBody) {
        Job job = modelMapper.map(requestBody, Job.class);
        jobRepository.save(job);
        return modelMapper.map(job, CreateJobResponseBody.class);
    }

    @Override
    public GetJobResponseBody getJob(Long id) {
        Optional<Job> job = jobRepository.findById(id);
        if(job.isEmpty())throw new BadRequestException();
        return modelMapper.map(job, GetJobResponseBody.class);
    }

    @Override
    public List<Job> getAllJob() {
        return jobRepository.findAll();
    }
}
