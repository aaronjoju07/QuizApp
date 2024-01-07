package com.quiz.demoQuiz.controller;

import com.quiz.demoQuiz.model.Questions;
import com.quiz.demoQuiz.service.QuestionSrevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("question")
@CrossOrigin("http://localhost:3000/")
public class QuestionController {
    @Autowired
    QuestionSrevice questionSrevice;
    @GetMapping("allQuestions")
    public ResponseEntity<List<Questions>> getAllQuestion(){
        return questionSrevice.getAllQuestions();
    }
    @GetMapping("getQuestion/{category}")
    public List<Questions> getQuestionByCategory(@PathVariable String category){
        return questionSrevice.getQuestionByCategory(category);
    }
    @PostMapping("add")
    public String addQuestion(@RequestBody Questions questions){
        return questionSrevice.addQuestion(questions);
    }

}
