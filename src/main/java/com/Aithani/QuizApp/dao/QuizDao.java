package com.Aithani.QuizApp.dao;

import com.Aithani.QuizApp.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<Quiz,Integer>
{
}