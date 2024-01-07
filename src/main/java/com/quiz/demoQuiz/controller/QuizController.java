package com.quiz.demoQuiz.controller;

import com.quiz.demoQuiz.model.QuestionWraper;
import com.quiz.demoQuiz.model.Questions;
import com.quiz.demoQuiz.model.Response;
import com.quiz.demoQuiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
@CrossOrigin("http://localhost:3000/")
public class QuizController {
    @Autowired
    QuizService quizService;
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int numQ,@RequestParam String title){
        return quizService.createQuiz(category,numQ,title);
    }
    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWraper>> getQuizQuestions(@PathVariable Integer id){
            return quizService.getQuizQuestions(id);
    }
    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id,@RequestBody List<Response> responses){
        return quizService.submitQuiz(id,responses);
    }
}
