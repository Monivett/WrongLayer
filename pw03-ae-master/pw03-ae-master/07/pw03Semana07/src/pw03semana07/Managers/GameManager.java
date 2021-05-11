/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pw03semana07.Managers;

import pw03semana07.Characters.PlayerController;
import pw03semana07.Enums.Levels;

/**
 *
 * @author magoc
 */
public final class GameManager {

    private static final GameManager instance;

    static {
        instance = new GameManager();
    }

    public static GameManager getInstance() {
        return instance;
    }

    private Levels actualLevel;
    private int score;
    private PlayerController player;

    public Levels getActualLevel() {
        return actualLevel;
    }

    public void setActualLevel(Levels actualLevel) {
        this.actualLevel = actualLevel;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score += score;
    }

    public PlayerController getPlayer() {
        return player;
    }

    public void setPlayer(PlayerController player) {
        this.player = player;
    }
    
    public void loadGame() {
        actualLevel = Levels.Main_Screen;
    }
    
    public void loadTutorial() {
        actualLevel = Levels.Tutorial_Screen;
    }
    
    public void initGame() {
        actualLevel = Levels.Water_Level;
        player = new PlayerController(100, false);
        score = 0;
    }
    
    public void loadWaterBoss() {
        actualLevel = Levels.Water_Boss_Level;
    }

}
