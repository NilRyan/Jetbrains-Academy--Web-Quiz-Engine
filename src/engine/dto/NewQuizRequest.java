package engine.dto;

import javax.validation.constraints.NotBlank;

public class NewQuizRequest {
    @NotBlank
    private String title;
    @NotBlank
    private String text;
    private String[] options;
    private int answer;

    public NewQuizRequest(String title, String text,String[] options, int answer) {
        this.title = title;
        this.text = text;
        this.options = options;
        this.answer = answer;
    }

    public NewQuizRequest() {
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
