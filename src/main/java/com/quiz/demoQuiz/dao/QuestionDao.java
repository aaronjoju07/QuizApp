package com.quiz.demoQuiz.dao;

import com.quiz.demoQuiz.model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Questions,Integer> {
    List<Questions> findBycategory(String category);
    @Query(value = "SELECT * FROM questions q Where q.category=:category ORDER BY RANDOM() LIMIT :numQ",nativeQuery = true)
    List<Questions> findRandomQuestionsByCategory(String category, int numQ);
}
