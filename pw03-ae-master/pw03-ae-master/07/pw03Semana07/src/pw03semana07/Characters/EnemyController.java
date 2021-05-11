/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pw03semana07.Characters;

import pw03semana07.Managers.GameManager;

/**
 *
 * @author magoc
 */
public class EnemyController extends AICharacter {

    private int points;

    public EnemyController() {
    }

    public EnemyController(int points) {
        this.points = points;
    }

    public EnemyController(int points, double health, boolean isDeath) {
        super(health, isDeath);
        this.points = points;
    }

    @Override
    public void attack() {
        System.out.println("Attack Enemy");
        GameManager.getInstance().getPlayer().takeDamage(5);
    }

    @Override
    public void move() {
        System.out.println("Move Enemy");
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public void death() {
        super.death();
        GameManager.getInstance().setScore(points);
    }

}
