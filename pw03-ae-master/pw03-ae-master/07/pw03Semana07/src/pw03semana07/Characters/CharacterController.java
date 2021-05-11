/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pw03semana07.Characters;

/**
 *
 * @author magoc
 */
public abstract class CharacterController {

    private double health;
    private boolean isDeath;

    public CharacterController() {
    }

    public CharacterController(double health, boolean isDeath) {
        this.health = health;
        this.isDeath = isDeath;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public boolean isIsDeath() {
        return isDeath;
    }

    public void setIsDeath(boolean isDeath) {
        this.isDeath = isDeath;
    }
    
    public abstract void move();
    
    public abstract void attack();
    
    public void heal(double amount) {
        this.health += amount;
    }
    
    public void takeDamage(double amount) {
        this.health -= amount;
        if (this.health <= 0) {
            death();
        }
    }
    
    public void death() {
        this.isDeath = true;
    }

}
