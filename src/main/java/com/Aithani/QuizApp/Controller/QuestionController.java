package com.Aithani.QuizApp.Controller;
import com.Aithani.QuizApp.model.quizq; // Corrected package name

import com.Aithani.QuizApp.Service.QuestionService; // Corrected package name
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List; // Added import for List

@RestController
@RequestMapping("quizq") // Added a base path for the controller
public class QuestionController
{
    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions") // Mapping path
    public ResponseEntity<List<quizq>> getAllQuestions()
    { // return type and method name
        return questionService.getAllQuestion(); // Method call
    }

    @GetMapping("category/{category}") //  mapping path
    public ResponseEntity<List<quizq>> getQuestionsByCategory(@PathVariable String category) {
        return questionService.getQuestionsByCategory(category);
    }
    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody quizq newq){
        return  questionService.addQuestion(newq);
    }
    @DeleteMapping("delete")
    public ResponseEntity<String> deleteQuestion(@RequestBody Integer id)
    {
        return questionService.deleteQuestion(id);
    }
}
