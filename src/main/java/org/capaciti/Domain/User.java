package org.capaciti.Domain;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.management.relation.Role;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    private String emailUser;
    private String nameUser;
    private String lastNameUser;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role = Role.User;



    public User() {
    }

    public enum Role {
        User,
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

    public Role getRole() {
        return role;
    }

    @Override
    public String getUsername() {
        return String.valueOf(emailUser);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name())) ;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(emailUser, user.emailUser) && Objects.equals(nameUser, user.nameUser) && Objects.equals(lastNameUser, user.lastNameUser) && Objects.equals(password, user.password) && role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(emailUser, nameUser, lastNameUser, password, role);
    }

    @Override
    public String toString() {
        return "User{" +
                "emailUser='" + emailUser + '\'' +
                ", nameUser='" + nameUser + '\'' +
                ", lastNameUser='" + lastNameUser + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
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
