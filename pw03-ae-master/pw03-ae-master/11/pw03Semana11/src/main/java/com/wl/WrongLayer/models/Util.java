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
public class Util {
    
    private int Contador; 

    private boolean Util;
    private int Pregunta;
    private int Respuesta;
     private User user;

    public Util() {
    }
    

    public Util(int Contador, int Pregunta) {
        this.Contador = Contador;
        this.Pregunta = Pregunta;
    }

 
    public Util(int Contador, boolean Util, int Pregunta) {
        this.Contador = Contador;
        this.Util = Util;
        this.Pregunta = Pregunta;
    
    }

    public Util(boolean Util, int Pregunta, User user) {
      
        this.Util = Util;
        this.Pregunta = Pregunta;
        this.user = user;
       
    }

    public Util(int Contador, int Pregunta, int Respuesta) {
        this.Contador = Contador;
        this.Pregunta = Pregunta;
        this.Respuesta = Respuesta;
    }

    public Util(int Contador, boolean Util, int Pregunta, int Respuesta, User user) {
        this.Contador = Contador;
        this.Util = Util;
        this.Pregunta = Pregunta;
        this.Respuesta = Respuesta;
        this.user = user;
    }

    public int getContador() {
        return Contador;
    }

    public void setContador(int Contador) {
        this.Contador = Contador;
    }

    public boolean isUtil() {
        return Util;
    }

    public void setUtil(boolean Util) {
        this.Util = Util;
    }

    public int getPregunta() {
        return Pregunta;
    }

    public void setPregunta(int Pregunta) {
        this.Pregunta = Pregunta;
    }

    public int getRespuesta() {
        return Respuesta;
    }

    public void setRespuesta(int Respuesta) {
        this.Respuesta = Respuesta;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

   
}
