/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pw03semana06.models;

/**
 *
 * @author magoc
 */
public class CharacterController {

    private String name;
    private long size;
    private int age;

    public CharacterController() {
    }

    public CharacterController(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public CharacterController(String name, long size, int age) {
        this.name = name;
        this.size = size;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public void move() {
        System.out.println("CharacterController Move");
    }

}
