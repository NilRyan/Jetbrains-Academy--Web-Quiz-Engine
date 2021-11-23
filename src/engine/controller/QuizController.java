package engine.controller;

import engine.dto.AnswerResponse;
import engine.dto.NewQuizRequest;
import engine.dto.NewQuizResponse;
import engine.model.QuizEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api/quizzes")
public class QuizController {
    String[] options = {"a", "b", "c", "d"};
    List<QuizEntity> quizzes = new ArrayList<>();

    @GetMapping("/{id}")
    public QuizEntity getQuiz(@PathVariable int id) {
        if (id < 0  || id > quizzes.size()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return quizzes.get(id);
    }

    @PostMapping("/{id}/solve")
    public AnswerResponse answerQuiz(@PathVariable int id, @RequestParam int answer) {
        QuizEntity quiz = quizzes.get(id);
        if (answer != quiz.getAnswer()) {
            AnswerResponse failed = new AnswerResponse(false, "Wrong answer! Please, try again.");
            return failed;
        }
        AnswerResponse success = new AnswerResponse(true, "Congratulations, you're right!");
        return success;
    }

    @PostMapping
    public NewQuizResponse createNewQuiz(@RequestBody @Valid NewQuizRequest newQuiz) {
        Long id = (long) quizzes.size();
        quizzes.add(new QuizEntity(id, newQuiz.getTitle(), newQuiz.getText(), newQuiz.getOptions(), newQuiz.getAnswer()));
        NewQuizResponse newQuizResponse = new NewQuizResponse(id, newQuiz.getTitle(), newQuiz.getText(), newQuiz.getOptions());
        return newQuizResponse;
    }

    @GetMapping
    public List<QuizEntity> getAllQuizzes() {
        return quizzes;
    }
}
