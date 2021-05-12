/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wl.WrongLayer.models;

/**
 *
 * @author monic
 */
public class Pregunta {
 

    private int id; 
    private Categoria category;
    private String pregunta;
     private String imagePath;
     private User user;
    private String description;
    private String Fecha;
   
    public Pregunta() {
    }

    public Pregunta(Categoria category, String pregunta, String imagePath, User user, String description) {
        this.category = category;
        this.pregunta = pregunta;
        this.imagePath = imagePath;
        this.user = user;
        this.description = description;
    }

    public Pregunta(int id, Categoria category, String pregunta, String imagePath, User user, String description, String Fecha) {
        this.id = id;
        this.category = category;
        this.pregunta = pregunta;
        this.imagePath = imagePath;
        this.user = user;
        this.description = description;
        this.Fecha = Fecha;
    }

  

 
    public Pregunta(int id, String title) {
        this.id = id;
        this.pregunta = title;
    }

    public Pregunta(int id, String title, String description, String pathImage, Categoria category) {
       this.id = id;
        this.category = category;
        this.pregunta = title;
        this.imagePath = pathImage;
       
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Categoria getCategory() {
        return category;
    }

    public void setCategory(Categoria category) {
        this.category = category;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }


  
  
  
}
