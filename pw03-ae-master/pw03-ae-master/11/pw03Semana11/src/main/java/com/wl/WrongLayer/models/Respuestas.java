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
     private String imagePath;// FOTO
       private boolean Modificada;
     private boolean Eliminada;
     private boolean Correcta;
    private String Fecha;

    public Respuestas() {
    }

    public Respuestas(int id) {
        this.id = id;
    }

    public Respuestas(int id, int Preguntas) {
        this.id = id;
        this.Preguntas = Preguntas;
    }

    public Respuestas(int id, String respuesta, String imagePath, boolean Modificada, boolean Eliminada, boolean Correcta) {
        this.id = id;
        this.respuesta = respuesta;
        this.imagePath = imagePath;
        this.Modificada = Modificada;
        this.Eliminada = Eliminada;
        this.Correcta = Correcta;
    }

    public Respuestas(int id, String respuesta, User user, int Preguntas, String imagePath,String Fecha, boolean Modificada, boolean Eliminada, boolean Correcta) {
        this.id = id;
        this.respuesta = respuesta;
        this.user = user;
        this.Preguntas = Preguntas;
        this.imagePath = imagePath;
        this.Modificada = Modificada;
        this.Eliminada = Eliminada;
        this.Correcta = Correcta;
        this.Fecha = Fecha;
    }
    


  
    public Respuestas(int id, String respuesta, User user, int Preguntas, String imagePath,String Fecha) {
        this.id = id;
        this.respuesta = respuesta;
        this.user = user;
        this.Preguntas = Preguntas;
         this.Fecha = Fecha;
         this.imagePath = imagePath;
    }
        public Respuestas( String respuesta, User user, int Preguntas,String imagePath) {
       
        this.respuesta = respuesta;
        this.user = user;
        this.Preguntas = Preguntas;
        this.imagePath = imagePath;
     
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

    public boolean isModificada() {
        return Modificada;
    }

    public void setModificada(boolean Modificada) {
        this.Modificada = Modificada;
    }

    public boolean isEliminada() {
        return Eliminada;
    }

    public void setEliminada(boolean Eliminada) {
        this.Eliminada = Eliminada;
    }

    public boolean isCorrecta() {
        return Correcta;
    }

    public void setCorrecta(boolean Correcta) {
        this.Correcta = Correcta;
    }
    
    
    
}
