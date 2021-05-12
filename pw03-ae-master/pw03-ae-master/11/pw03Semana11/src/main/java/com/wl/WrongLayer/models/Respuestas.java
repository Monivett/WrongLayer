/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wl.WrongLayer.models;

import java.util.List;
import javax.enterprise.inject.New;

/**
 *
 * @author monic
 */
public class Respuestas {
    private int id;
    private String respuesta;
    private User user; //Usuario que puso la respuesta
    private int Preguntas; //Pregunta  a la que pertence
    private int parent; //Respuesta al que pertencemos
     private String imagePath;// private int category;
    private List<Respuestas> answers; //Relación inversa de las respuestas
    private String Fecha;

    public Respuestas() {
    }

    public Respuestas(int id) {
        this.id = id;
    }

    public Respuestas(int id, String respuesta, User user, int Preguntas, List<Respuestas> answers, String imagePath,String Fecha) {
        this.id = id;
        this.respuesta = respuesta;
        this.user = user;
        this.Preguntas = Preguntas;
        this.answers = answers;
         this.Fecha = Fecha;
    }

    public Respuestas(int id, String respuesta, User user, int Preguntas, int parent, String imagePath,String Fecha) {
        this.id = id;
        this.respuesta = respuesta;
        this.user = user;
        this.Preguntas = Preguntas;
        this.parent = parent;
         this.Fecha = Fecha;
    }
        public Respuestas( String respuesta, User user, int Preguntas,String imagePath) {
       
        this.respuesta = respuesta;
        this.user = user;
        this.Preguntas = Preguntas;
     
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getPreguntas() {
        return Preguntas;
    }

    public void setPreguntas(int Preguntas) {
        this.Preguntas = Preguntas;
    }

   

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public List<Respuestas> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Respuestas> answers) {
        this.answers = answers;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }
    
    
    
}
