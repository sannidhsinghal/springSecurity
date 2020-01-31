package com.sannidh.practice.domain.dto;

public class UserDTO {

    Long id;

    String emailId;

    String username;

    String password;


    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }


    public String getName() {
        return username;
    }

    public void setName(String username) {
        this.username = username;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
