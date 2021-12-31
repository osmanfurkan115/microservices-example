package io.github.osmanfurkan115.product.model;

public class SendEmailRequest {
    private final String email;
    private final String subject;
    private final String message;

    public SendEmailRequest(String email, String subject, String message) {
        this.email = email;
        this.subject = subject;
        this.message = message;
    }

    public String getEmail() {
        return email;
    }

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return message;
    }
}
