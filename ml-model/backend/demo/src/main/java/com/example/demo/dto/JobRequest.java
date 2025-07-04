 package com.example.demo.dto;

import java.util.List;

public class JobRequest {
    private String jobDescription;
    private List<String> resumes;

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public List<String> getResumes() {
        return resumes;
    }

    public void setResumes(List<String> resumes) {
        this.resumes = resumes;
    }
}
