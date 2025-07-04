 package com.example.demo.service;

public class MatchingResult {
    private String candidateName;
    private double score;

    public MatchingResult() {}

    public MatchingResult(String candidateName, double score) {
        this.candidateName = candidateName;
        this.score = score;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public double getScore() {
        return score;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
