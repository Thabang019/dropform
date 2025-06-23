package org.capaciti.DTO;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class EmailToken {

        @Id
        private String token;

        @OneToOne
        @JoinColumn(name = "email_user")
        private User userEmail;

        @Column(name = "time")
        private LocalDateTime time = LocalDateTime.now();


        public EmailToken() {
        }

        private EmailToken(Builder builder) {
                this.token = builder.token;
                this.userEmail = builder.userEmail;
        }

        public String getToken() {
                return token;
        }

        public User getUserEmail() {
                return userEmail;
        }

        @Override
        public boolean equals(Object o) {
                if (o == null || getClass() != o.getClass()) return false;
                EmailToken that = (EmailToken) o;
                return Objects.equals(token, that.token) && Objects.equals(userEmail, that.userEmail);
        }

        @Override
        public int hashCode() {
                return Objects.hash(token, userEmail);
        }

        @Override
        public String toString() {
                return "EmailToken{" +
                        "token=" + token +
                        ", email='" + userEmail + '\'' +
                        '}';
        }


        public static class Builder {

                private String token;
                private User userEmail;

                public Builder setToken(String token) {
                        this.token = token;
                        return this;
                }

                public Builder setUserEmail(User userEmail) {
                        this.userEmail = userEmail;
                        return this;
                }

                public Builder copy(EmailToken emailToken) {
                        this.token = emailToken.token;
                        this.userEmail = emailToken.userEmail;
                        return this;
                }

                public EmailToken build(){
                        return new EmailToken(this);
                }
        }
}
