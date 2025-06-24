package org.capaciti.Domain;

public class ContactRequest {

    private String name;
    private String email;
    private String subject;
    private String message;
    private String token;

    public ContactRequest() {
    }

    public ContactRequest(Builder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.subject = builder.subject;
        this.message = builder.message;
        this.token = builder.token;
    }

    public String getName() {
        return name;
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

    public String getToken() {
        return token;
    }

    public static class Builder{
        private String name;
        private String email;
        private String subject;
        private String message;
        private String token;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setSubject(String subject) {
            this.subject = subject;
            return this;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setToken(String token) {
            this.token = token;
            return this;
        }

        public ContactRequest build(){
            return new ContactRequest();
        }
    }
}