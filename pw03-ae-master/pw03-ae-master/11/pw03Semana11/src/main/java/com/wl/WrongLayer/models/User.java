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
public class User {
     private int id;
    private String name;
    private String ap;
    private String date;
    private String mail;
    private String username;
    private String password;
    private String urlImage;

    public User() {
    }

    public User(String Nombre,String Apellido, String date,String email, String username, String password, String urlImage) {
         
        this.name = Nombre;
        this.ap = Apellido;
        this.date = date;
        this.mail = email;
        this.username = username;
        this.password = password;
        this.urlImage = urlImage;
        
    }
        public User(int id, String username) {
        this.id = id;
        this.username = username;
    }
         public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }


       //Nombre----------------
   public String getNombre() {
        return name;
    }

    public void setNombre(String Nombre) {
        this.name = Nombre;
    }
    //Apellido----------------
   public String getApellido() {
        return ap;
    }

    public void setApellido(String Apellido) {
        this.ap = Apellido;
    }
    //FECHA DE NACIMIENTO
       public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
   //CORREO----------------
   public String getEmail() {
        return mail;
    }

    public void setEmail(String email) {
        this.mail = email;
    }
    //USUARIO------------------
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    //CONTRASEÑA------------------
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    //IMAGEN----------------------
    
    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
    //ID


   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
