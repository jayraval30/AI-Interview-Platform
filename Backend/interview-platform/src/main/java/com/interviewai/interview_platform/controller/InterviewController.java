package com.interviewai.interview_platform.controller;

import com.interviewai.interview_platform.model.InterviewSession;
import com.interviewai.interview_platform.model.Question;
import com.interviewai.interview_platform.service.InterviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/interview")
public class InterviewController {

    private final InterviewService interviewService;

    public InterviewController(InterviewService interviewService) {
        this.interviewService = interviewService;
    }

    // POST /api/interview/start
    // Body: { "jobRole": "Java Developer" }
    @PostMapping("/start")
    public ResponseEntity<InterviewSession> startInterview(
            @RequestBody Map<String, String> body
    ) {
        String jobRole = body.get("jobRole");
        InterviewSession session = interviewService.startSession(jobRole);
        return ResponseEntity.ok(session);
    }

    // GET /api/interview/{id}/questions
    @GetMapping("/{id}/questions")
    public ResponseEntity<List<Question>> getQuestions(
            @PathVariable Long id
    ) {
        List<Question> questions = interviewService.getSession(id)  .getQuestions();
        return ResponseEntity.ok(questions);
    }

    // GET /api/interview/my-sessions
    @GetMapping("/my-sessions")
    public ResponseEntity<List<InterviewSession>> getMySessions() {
        List<InterviewSession> sessions = interviewService.getUserSessions();
        return ResponseEntity.ok(sessions);
    }
}