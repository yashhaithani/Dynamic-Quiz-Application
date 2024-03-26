package com.Aithani.QuizApp.dao;

import com.Aithani.QuizApp.model.quizq;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<quizq, Integer>
{
    List<quizq> findByCategory(String category );
    @Query(value = "SELECT * FROM quizq q Where q.category=:category ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
    List<quizq> findRandomQuestionsByCategory(String category, int numQ);
}
