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
public class PlayerController extends CharacterController {

    public PlayerController() {
    }

    public PlayerController(double health, boolean isDeath) {
        super(health, isDeath);
    }
        
    @Override
    public void move() {
        System.out.println("Move");
    }

    @Override
    public void attack() {
        System.out.println("Attack");
    }

    @Override
    public void takeDamage(double amount) {
        super.takeDamage(amount); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Player take " + amount + " damage");
    }
    
    
    
}
