package com.quiz.demoQuiz.service;

import com.quiz.demoQuiz.dao.QuestionDao;
import com.quiz.demoQuiz.dao.QuizDao;
import com.quiz.demoQuiz.model.QuestionWraper;
import com.quiz.demoQuiz.model.Questions;
import com.quiz.demoQuiz.model.Quiz;
import com.quiz.demoQuiz.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;
    @Autowired
    QuestionDao questionDao;

    public  ResponseEntity<List<QuestionWraper>> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz= quizDao.findById(id);
        List<Questions> questionsDB = quiz.get().getQuestions();
        List<QuestionWraper> questionsForUsers = new ArrayList<>();
        for (Questions q :questionsDB){
            QuestionWraper qw = new QuestionWraper(q.getId(),q.getQuestionText(),q.getOption_a(),q.getOption_b(),q.getOption_c());
            questionsForUsers.add(qw);
        }
        return new ResponseEntity<>(questionsForUsers,HttpStatus.OK);
    }

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Questions> questions = questionDao.findRandomQuestionsByCategory(category,numQ);
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<Integer> submitQuiz(Integer id, List<Response> responses) {
        try {
            Quiz quiz =quizDao.findById(id).get();
            List<Questions>questionsDB = quiz.getQuestions();
            int right=0;int i=0;
            for (Response r : responses){
                if (r.getResponse().equals(questionsDB.get(i).getCorrectAnswer()))
                    right++;
                i++;
            }
            return new ResponseEntity<>(right,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(0,HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
