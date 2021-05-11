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
public class NpcBuilder implements INpc {

    private String name;
    private int age;
    private int money;

    public NpcBuilder() {
    }

    public NpcBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public NpcBuilder withAge(int age) {
        this.age = age;
        return this;
    }

    public NpcBuilder withMoney(int money) {
        this.money = money;
        return this;
    }

    @Override
    public Npc build() {
        // NPC = Non Player Character
        Npc npc = new Npc();
        npc.setAge(age);
        npc.setMoney(money);
        npc.setName(name);
        return npc;
    }

}
