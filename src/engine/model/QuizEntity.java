package engine.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class QuizEntity {
    @NotBlank
    private Long id;
    @NotBlank
    private String title;
    @NotBlank
    private String text;
    @NotBlank
    private String[] options;
    @NotBlank
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int answer;

    public QuizEntity(Long id, String title, String text, @NotBlank String[] options, int answer) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.options = options;
        this.answer = answer;
    }

    public QuizEntity(Long id, String title, String text, @NotBlank String[] options) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.options = options;
    }

    public QuizEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }
}
