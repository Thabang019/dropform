package org.capaciti.DTO;

import java.util.Objects;

public class SignInRequest {

    private String loginEmail;
    private String loginPassword;

    public SignInRequest() {
    }

    private SignInRequest(Builder builder) {
        this.loginEmail = builder.loginEmail;
        this.loginPassword = builder.loginPassword;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public String getLoginEmail() {
        return loginEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SignInRequest that = (SignInRequest) o;
        return Objects.equals(loginEmail, that.loginEmail) && Objects.equals(loginPassword, that.loginPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loginEmail, loginPassword);
    }

    @Override
    public String toString() {
        return "SignInRequest{" +
                "loginEmail='" + loginEmail + '\'' +
                ", loginPassword='" + loginPassword + '\'' +
                '}';
    }

    public static class Builder{
        private String loginEmail;
        private String loginPassword;

        public Builder setLoginEmail(String loginEmail){
            this.loginEmail = loginEmail;
            return this;
        }

        public Builder setLoginPassword(String loginPassword){
            this.loginPassword = loginPassword;
            return this;
        }
         public Builder copy(SignInRequest signInRequest){
            this.loginEmail = signInRequest.loginEmail;
            this.loginPassword = signInRequest.loginPassword;
            return this;
         }

         public SignInRequest build(){
            return new SignInRequest(this);
        }
    }
}
