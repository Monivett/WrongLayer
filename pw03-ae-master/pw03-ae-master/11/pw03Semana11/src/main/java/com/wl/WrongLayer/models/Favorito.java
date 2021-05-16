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
public class Favorito {
          private int Contador; 

    private boolean Favorito;
    private int Pregunta;
 
     private User user;

    public Favorito() {
    }

    public Favorito(int Contador, int Pregunta) {
        this.Contador = Contador;
        this.Pregunta = Pregunta;
    }

    
    public Favorito(boolean Favorito, int Pregunta, User user) {
        this.Favorito = Favorito;
        this.Pregunta = Pregunta;
        this.user = user;
    }

    
    public int getContador() {
        return Contador;
    }

    public void setContador(int Contador) {
        this.Contador = Contador;
    }

    public boolean isFavorito() {
        return Favorito;
    }

    public void setFavorito(boolean Favorito) {
        this.Favorito = Favorito;
    }

    public int getPregunta() {
        return Pregunta;
    }

    public void setPregunta(int Pregunta) {
        this.Pregunta = Pregunta;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
     
}
