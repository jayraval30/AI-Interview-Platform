package com.interviewai.interview_platform.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "question_bank")
@Data
public class QuestionBank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String questionText;

    @Column(columnDefinition = "TEXT")
    private String expectedAnswer;

    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    private String category;   // "Core Java", "OOP", "Collections", "Spring"
    private String jobRole;    // "JAVA_DEVELOPER", "REACT_DEVELOPER" etc.

    public enum Difficulty {
        EASY, MEDIUM, HARD
    }
}