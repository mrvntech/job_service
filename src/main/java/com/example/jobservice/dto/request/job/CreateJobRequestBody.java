package com.example.jobservice.dto.request.job;

import java.util.Set;

public class CreateJobRequestBody {
    private String name;
    private Double budget;
    private String information;
//    private Set<Long> categoryIds;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }
}
