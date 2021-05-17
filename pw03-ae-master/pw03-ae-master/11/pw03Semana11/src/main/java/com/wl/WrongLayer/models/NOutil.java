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
public class NOutil {
      private int Contador; 

    private boolean NOutil;
    private int Pregunta;
    private int Respuesta;
     private User user;

    public NOutil() {
    }

    public NOutil(int Contador, int Pregunta) {
        this.Contador = Contador;
        this.Pregunta = Pregunta;
    }

    public NOutil(int Contador, boolean NOutil, int Pregunta, User user) {
        this.Contador = Contador;
        this.NOutil = NOutil;
        this.Pregunta = Pregunta;
        this.user = user;
    }

    public NOutil(boolean NOutil, int Pregunta, int Respuesta, User user) {
        this.NOutil = NOutil;
        this.Pregunta = Pregunta;
        this.Respuesta = Respuesta;
        this.user = user;
    }
    

    public NOutil(boolean NOutil, int Pregunta, User user) {
        this.NOutil = NOutil;
        this.Pregunta = Pregunta;
        this.user = user;
    }

    
    public NOutil(int Contador, boolean NOutil, int Pregunta, int Respuesta, User user) {
        this.Contador = Contador;
        this.NOutil = NOutil;
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

    public boolean isNOutil() {
        return NOutil;
    }

    public void setNOutil(boolean NOutil) {
        this.NOutil = NOutil;
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
