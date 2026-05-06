package com.interviewai.interview_platform.service;

import com.interviewai.interview_platform.model.*;
import com.interviewai.interview_platform.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InterviewService {

    private final SessionRepository sessionRepository;
    private final QuestionBankRepository questionBankRepository;
    private final UserRepository userRepository;

    public InterviewSession startSession(String jobRole) {

        // 1. Get logged in user
        String email = SecurityContextHolder.getContext()
                .getAuthentication().getName();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // 2. Pick 10 random questions from question bank
        List<QuestionBank> randomQuestions =
                questionBankRepository.findRandomByJobRole(jobRole, 10);

        // 3. Create new session
        InterviewSession session = new InterviewSession();
        session.setUser(user);
        session.setJobRole(jobRole);
        session.setTotalQuestions(randomQuestions.size());
        session.setStatus(InterviewSession.Status.IN_PROGRESS);

        // 4. Convert QuestionBank → Question and link to session
        List<Question> questions = new ArrayList<>();
        for (int i = 0; i < randomQuestions.size(); i++) {
            QuestionBank qb = randomQuestions.get(i);
            Question q = new Question();
            q.setQuestiontext(qb.getQuestionText());
            q.setQuestionNumber(i + 1);
            q.setSession(session);
            questions.add(q);
        }
        session.setQuestions(questions);

        // 5. Save session (cascades to questions automatically)
        return sessionRepository.save(session);
    }

    public InterviewSession getSession(Long sessionId) {
        return sessionRepository.findById(sessionId)
                .orElseThrow(() -> new RuntimeException("Session not found"));
    }

    public List<InterviewSession> getUserSessions() {
        String email = SecurityContextHolder.getContext()
                .getAuthentication().getName();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return sessionRepository.findByUserOrderByStartedAtDesc(user);
    }
}