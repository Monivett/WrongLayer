/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pw03semana07.Patterns;

/**
 * Patron de diseño Singleton, permite usar una instancia por todo el ciclo de
 * vida
 *
 * @author magoc
 */
public class Singleton {

    // Final es para mostrar un delimitador
    private static final Singleton instance;

    // Constructor para atributos estaticos
    static {
        instance = new Singleton();
    }

    public static Singleton getInstance() {
        return instance;
    }

    public Singleton() {
    }

}
