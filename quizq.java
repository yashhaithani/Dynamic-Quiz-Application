package com.Aithani.QuizApp.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class quizq
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String questionTitle;
    private String Option1;
    private String Option2;
    private String Option3;
    private String Option4;
    private String rightAnswer;
    private String difficultyLevel;
    private String category;
}
