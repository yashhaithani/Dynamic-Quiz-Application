package com.Aithani.QuizApp.Srevice;

import com.Aithani.QuizApp.dao.QuestionDao;
import com.Aithani.QuizApp.dao.QuizDao;
import com.Aithani.QuizApp.model.QuestionWrapper;
import com.Aithani.QuizApp.model.Quiz;
import com.Aithani.QuizApp.model.Response;
import com.Aithani.QuizApp.model.quizq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService
{
    @Autowired
    QuizDao quizDao;
    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        List<quizq> questions = questionDao.findRandomQuestionsByCategory(category, numQ);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("Successfully Created", HttpStatus.CREATED);
    }
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id)
    {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<quizq> questionsFromDB = quiz.get().getQuestions();
        List<QuestionWrapper> questionForUser = new ArrayList<>();
        for(quizq q: questionsFromDB)
        {
            QuestionWrapper qw= new QuestionWrapper(q.getId(),q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
            questionForUser.add(qw);
        }
        return  new ResponseEntity<>(questionForUser,HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses)
    {
        Quiz quiz = quizDao.findById(id).get();
        List<quizq> questions =quiz.getQuestions();

        int right = 0, i=0;
        for(Response response : responses)
        {
            if(response.getResponses().equals(questions.get(i).getRightAnswer()))
                right++;
            i++;
        }
        return  new ResponseEntity<>(right, HttpStatus.OK);
    }
}
