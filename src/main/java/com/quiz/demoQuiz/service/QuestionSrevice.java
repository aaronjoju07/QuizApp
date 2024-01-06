package com.quiz.demoQuiz.service;

import com.quiz.demoQuiz.dao.QuestionDao;
import com.quiz.demoQuiz.model.Questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class QuestionSrevice {
    @Autowired
    QuestionDao questionDao;
    public ResponseEntity<List<Questions>> getAllQuestions() {
      try {
          return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
      }catch (Exception e){
          e.printStackTrace();
      }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
    public List<Questions> getQuestionByCategory(String category) {
        return questionDao.findBycategory(category);
    }

    public String addQuestion(Questions questions) {
         questionDao.save(questions);
         return "Success";
    }
}
