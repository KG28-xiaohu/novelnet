package com.novelnet.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private int uid;
    private String account;
    private String username;
    private String password;
    private int gard;
    private String email;
    private String sex;
    private String qq;
    private String microblog;
    private String enrollTime;
    private String userIntegral;
    private int messageNum;
    private int bookMaxNum;
    private int collectTicketNum;
    private String personalWeb;
    private List<Book> books;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getGard() {
        return gard;
    }

    public void setGard(int gard) {
        this.gard = gard;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getMicroblog() {
        return microblog;
    }

    public void setMicroblog(String microblog) {
        this.microblog = microblog;
    }

    public String getEnrollTime() {
        return enrollTime;
    }

    public void setEnrollTime(String enrollTime) {
        this.enrollTime = enrollTime;
    }

    public String getUserIntegral() {
        return userIntegral;
    }

    public void setUserIntegral(String userIntegral) {
        this.userIntegral = userIntegral;
    }

    public int getMessageNum() {
        return messageNum;
    }

    public void setMessageNum(int messageNum) {
        this.messageNum = messageNum;
    }

    public int getBookMaxNum() {
        return bookMaxNum;
    }

    public void setBookMaxNum(int bookMaxNum) {
        this.bookMaxNum = bookMaxNum;
    }

    public int getCollectTicketNum() {
        return collectTicketNum;
    }

    public void setCollectTicketNum(int collectTicketNum) {
        this.collectTicketNum = collectTicketNum;
    }

    public String getPersonalWeb() {
        return personalWeb;
    }

    public void setPersonalWeb(String personalWeb) {
        this.personalWeb = personalWeb;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
