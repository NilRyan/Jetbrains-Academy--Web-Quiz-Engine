package engine.controller;

import engine.dto.AnswerResponse;
import engine.dto.QuizResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/quiz")
public class QuizController {
    String[] options = {"a", "b", "c", "d"};
    QuizResponse quiz = new QuizResponse("The Java Logo", "?", options);

    @GetMapping
    public QuizResponse getQuiz() {
        return quiz;
    }

    @PostMapping
    public AnswerResponse answerQuiz(@RequestParam int answer) {
        if (answer != 2) {
            AnswerResponse failed = new AnswerResponse(false, "Wrong answer! Please, try again.");
            return failed;
        }
        AnswerResponse success = new AnswerResponse(true, "Congratulations, you're right!");
        return success;


    }

}
