package com.example.whatsapp.Models;

public class User {
    String profilePic ,userName,mail,password,userId,lastMessagel;
    public User(String profilePic, String userName, String mail, String password, String userId, String lastMessagel) {
        this.profilePic = profilePic;
        this.userName = userName;
        this.mail = mail;
        this.password = password;
        this.userId = userId;
        this.lastMessagel = lastMessagel;
    }
    public User(){}//this need for because of firebase
    //SignUp constructor with the help of this constructor we send data to firebase Database
    public User( String userName, String mail, String password ) {

        this.userName = userName;
        this.mail = mail;
        this.password = password;

    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLastMessagel() {
        return lastMessagel;
    }

    public void setLastMessagel(String lastMessagel) {
        this.lastMessagel = lastMessagel;
    }


}
