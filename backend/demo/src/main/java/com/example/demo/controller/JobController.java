 package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.JobRequest;
import com.example.demo.service.JobMatchingService;
import com.example.demo.service.MatchingResult;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/jobs")
public class JobController {

    @Autowired
    private JobMatchingService jobMatchingService;

    @PostMapping("/match")
    public List<MatchingResult> matchJob(@RequestBody JobRequest jobRequest) {
        return jobMatchingService.match(jobRequest.getJobDescription(), jobRequest.getResumes());
    }
}
