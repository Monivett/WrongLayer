/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pw.pw03semana11.models;

import java.util.List;

/**
 *
 * @author magoc
 */
public class Commentary {

    private int id;
    private String content;
    private User user;
    private int idNews;
    private Integer parent;
    private List<Commentary> answers;

    public Commentary() {
    }

    public Commentary(int id) {
        this.id = id;
    }

    public Commentary(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public Commentary(String content, User user, int idNews, Integer parent) {
        this.content = content;
        this.user = user;
        this.idNews = idNews;
        this.parent = parent;
    }

    public Commentary(int id, String content, User user, int idNews, Integer parent) {
        this.id = id;
        this.content = content;
        this.user = user;
        this.idNews = idNews;
        this.parent = parent;
    }

    public Commentary(int id, String content, User user, int idNews, Integer parent, List<Commentary> answers) {
        this.id = id;
        this.content = content;
        this.user = user;
        this.idNews = idNews;
        this.parent = parent;
        this.answers = answers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getIdNews() {
        return idNews;
    }

    public void setIdNews(int idNews) {
        this.idNews = idNews;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public List<Commentary> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Commentary> answers) {
        this.answers = answers;
    }

}
