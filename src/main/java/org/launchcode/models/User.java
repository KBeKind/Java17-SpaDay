package org.launchcode.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class User {

    @NotBlank(message = "username cant be blank")
    @Size(min=5, max = 15, message = "username must be between 5 and 15 char")
    private String username;

    @Email
    private String email;

    @Size(min=6, message = "password must be at least 6 char")
    @NotBlank(message = "password cant be blank")
    private String password;

    @NotNull(message = "Passwords do not match")
    private String verifyPassword;


    public User() {

    }

    public User(String username, String email, String password) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        checkPassword();
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkPassword();

    }

    private void checkPassword(){
        if (this.password != null && this.verifyPassword != null){
            if(this.password.equals(this.verifyPassword)){
                //Passwords good
            } else {
                this.verifyPassword = null;
            }
        }
    }

}

