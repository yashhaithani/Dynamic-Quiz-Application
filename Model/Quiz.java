package com.Aithani.QuizApp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Quiz
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Integer id;
       private  String title;

       @ManyToMany
       private  List<quizq> questions;
}
