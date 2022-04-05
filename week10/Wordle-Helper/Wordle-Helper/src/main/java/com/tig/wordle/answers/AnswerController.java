package com.tig.wordle.answers;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("answers")
public class AnswerController {
    private AnswerService answerService;
    public AnswerController(AnswerService answerService){
        this.answerService = answerService;
    }
    @GetMapping
    public List<Answer> getAllAnswers(){
        return answerService.getAllAnswers();
    }
    @GetMapping (path = "{id}")
    public Answer getAnswerById (@PathVariable("id") Integer id){
        return answerService.getAnswerById(id);
    }
    @PostMapping (path = "addanswer")
    public Integer addAnswerToTable (@RequestBody Answer answer) {
        return answerService.addAnswerToTable(answer);
    }
    @DeleteMapping (path = "{id}")
    public Integer deleteAnswerById (@PathVariable("id") Integer id) {
        return answerService.deleteAnswerById(id);
    }
    @PutMapping (path = "update/{id}")
    public Integer updateAnswerById(@PathVariable("id") Integer id, @RequestBody Answer answerUpdate) {
        return answerService.updateAnswerById(id, answerUpdate);
    }
}
