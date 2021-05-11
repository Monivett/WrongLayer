/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pw.pw03semana11.models;

import com.wl.WrongLayer.models.Categoria;

/**
 *
 * @author magoc
 */
public class News {

   

    private int id;
    private String title;
    private String description;
    private String imagePath;
   // private int category;
    private Categoria category;

    public News() {
    }

   public News(String title, String description, String imagePath, Categoria category) {
   //  public News(String title, String description, String imagePath, int category){
        this.title = title;
        this.description = description;
        this.imagePath = imagePath;
        this.category = category;
    }

   public News(int id, String title, String description, String imagePath, Categoria category){
    //public News(int id, String title, String description, String imagePath, int category){
        this.id = id;
        this.title = title;
        this.description = description;
        this.imagePath = imagePath;
        this.category = category;
    }

    public News(int id, String title) {
        this.id = id;
        this.title = title;
    }
   
   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

   public Categoria getCategory() {
        return category;
    }

    public void setCategory(Categoria category) {
        this.category = category;
    }
   /*  public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }*/

}
