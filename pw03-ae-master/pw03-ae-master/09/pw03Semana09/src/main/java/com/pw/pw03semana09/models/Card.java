/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pw.pw03semana09.models;

/**
 * Modelo de las Tarjetas
 *
 * @author magoc
 */
public class Card {

    private String imgUrl;
    private String title;
    private String description;
    private String linkRef;

    public Card() {
    }

    public Card(String imgUrl, String title, String description, String linkRef) {
        this.imgUrl = imgUrl;
        this.title = title;
        this.description = description;
        this.linkRef = linkRef;
    }
    
    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLinkRef() {
        return linkRef;
    }

    public void setLinkRef(String linkRef) {
        this.linkRef = linkRef;
    }

}
