/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pw03semana07.NPC;

/**
 *
 * @author magoc
 */
public class Npc {

    private String name;
    private int age;
    private int money;

    public Npc() {
    }

    public Npc(String name, int age, int money) {
        this.name = name;
        this.age = age;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Npc{" + "name=" + name + ", age=" + age + ", money=" + money + '}';
    }

}
