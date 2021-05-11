/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pw03semana06.models;

/**
 * Es una clase para generar controladores de jugadores
 * @author magoc
 */
public class PlayerController extends CharacterController {

    private int controllerNumber;

    public PlayerController() {
    }

    public PlayerController(String name, int age) {
        super(name, age);
    }

    public PlayerController(String name, long size, int age) {
        super(name, size, age);
    }

    public PlayerController(int controllerNumber) {
        this.controllerNumber = controllerNumber;
    }

    public PlayerController(int controllerNumber, String name, int age) {
        super(name, age);
        this.controllerNumber = controllerNumber;
    }

    /**
     * Constructor para generar PlayerController y contructor de clase super
     * @param controllerNumber Numero de Jugador
     * @param name Nombre del jugador
     * @param size Tamanio del jugador
     * @param age Edad del jugador
     */
    public PlayerController(int controllerNumber, String name, long size, int age) {
        super(name, size, age);
        this.controllerNumber = controllerNumber;
    }

    /**
     * Funcion para mover al jugador
     */
    @Override
    public void move() {
        super.move(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("PlayerController Move");
    }

    /**
     * Retorna el numero del jugador
     * @return Numero de jugador
     */
    public int getControllerNumber() {
        return controllerNumber;
    }

    public void setControllerNumber(int controllerNumber) {
        this.controllerNumber = controllerNumber;
    }

}
