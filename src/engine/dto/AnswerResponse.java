package engine.dto;

public class AnswerResponse {
    private boolean success;
    private String feedback;

    public AnswerResponse(boolean success, String feedback) {
        this.success = success;
        this.feedback = feedback;
    }

    public AnswerResponse() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
