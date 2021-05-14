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
    private int Edad;
    private int Estado;

    public User() {
    }

    public User(int id, String name, String ap, String date, String mail, String password, String urlImage) {
        this.id = id;
        this.name = name;
        this.ap = ap;
        this.date = date;
        this.mail = mail;
        this.password = password;
        this.urlImage = urlImage;
    }
    

    public User(int id, String name, String ap, String date, String mail, String username, String password, String urlImage, int Edad, int Estado) {
        this.id = id;
        this.name = name;
        this.ap = ap;
        this.date = date;
        this.mail = mail;
        this.username = username;
        this.password = password;
        this.urlImage = urlImage;
        this.Edad = Edad;
        this.Estado = Estado;
    }

    

    public User(int id, String name, String ap, String date, String mail, String username, String password, String urlImage) {
        this.id = id;
        this.name = name;
        this.ap = ap;
        this.date = date;
        this.mail = mail;
        this.username = username;
        this.password = password;
        this.urlImage = urlImage;
        
    }
        public User(int id, String name, String ap, String date, String mail, String username, String password, String urlImage, String user) {
        this.id = id;
        this.name = name;
        this.ap = ap;
        this.date = date;
        this.mail = mail;
        this.username = username;
        this.password = password;
        this.urlImage = urlImage;
         this.username = user;
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
            public User(int id) {
        this.id = id;

    }
  public User(String username, String password) {
        this.username = username;
        this.password = password;
    
    }
    public User(String username, String password, String foto) {
        this.username = username;
        this.password = password;
          this.urlImage = foto;
    }
            
         public User(int id, String username, String foto) {
        this.id = id;
        this.username = username;
        this.urlImage = foto;
    }


       //Nombre----------------
   public String getNombre() {
        return name;
    }

    public void setNombre(String Nombre) {
        this.name = Nombre;
    }
       //Apellido----------------
    public String getAp() {
        return ap;
    }


    public void setAp(String ap) {
        this.ap = ap;
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

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int Estado) {
        this.Estado = Estado;
    }
    
    
}
