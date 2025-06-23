package org.capaciti.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    @Id
    private String emailUser;
    private String nameUser;
    private String lastNameUser;
    private String password;



    public User() {
    }

    private User(Builder builder) {
        this.emailUser = builder.emailUser;
        this.nameUser = builder.nameUser;
        this.lastNameUser = builder.lastNameUser;
        this.password = builder.password;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public String getLastNameUser() {
        return lastNameUser;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(emailUser, user.emailUser) && Objects.equals(nameUser, user.nameUser) && Objects.equals(lastNameUser, user.lastNameUser) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emailUser, nameUser, lastNameUser, password);
    }

    @Override
    public String toString() {
        return "User{" +
                "emailUser='" + emailUser + '\'' +
                ", name_user='" + nameUser + '\'' +
                ", lastName_user='" + lastNameUser + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static class Builder{
        private String emailUser;
        private String nameUser;
        private String lastNameUser;
        private String password;

        public Builder setEmailUser(String email) {
            this.emailUser = email;
            return this;
        }

        public Builder setNameUser(String name) {
            this.nameUser = name;
            return this;
        }

        public Builder setLastNameUser(String lastName) {
            this.lastNameUser = lastName;
            return this;
        }

        public Builder setPassword(String password){
            this.password = password;
            return this;
        }

        public Builder copy(User user){
            this.emailUser = user.emailUser;
            this.nameUser = user.nameUser;
            this.lastNameUser = user.lastNameUser;
            this.password = user.password;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }
}
