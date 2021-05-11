/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pw03semana07;

import pw03semana07.Characters.EnemyController;
import pw03semana07.Characters.PlayerController;
import pw03semana07.Managers.GameManager;
import pw03semana07.NPC.NpcBuilder;
import pw03semana07.NPC.Npc;

/**
 *
 * @author magoc
 */
public class Pw03Semana07 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GameManager.getInstance().loadGame();
        System.out.println("Level: " + GameManager.getInstance().getActualLevel());
        GameManager.getInstance().loadTutorial();
        System.out.println("Level: " + GameManager.getInstance().getActualLevel());
        GameManager.getInstance().initGame();
        System.out.println("Level: " + GameManager.getInstance().getActualLevel());

        EnemyController enemy01 = new EnemyController(10, 10, false);
        EnemyController enemy02 = new EnemyController(20, 20, false);

        PlayerController player = GameManager.getInstance().getPlayer();
        player.heal(10);

        System.out.println("Health Player: " + player.getHealth());
        System.out.println("GM Player: " + GameManager.getInstance().getPlayer().getHealth());

        for (int i = 0; i < 10; i++) {
            player.move();
        }

        enemy01.attack();
        enemy01.attack();

        for (int i = 0; i < 2; i++) {
            player.attack();
        }

        enemy01.takeDamage(10);

        System.out.println("Health Player: " + player.getHealth());
        System.out.println("Score: " + GameManager.getInstance().getScore());

        NpcBuilder npcBuilder = new NpcBuilder();
        NpcBuilder npcBuilder02 = new NpcBuilder();
        Npc npc01 = npcBuilder.withAge(26)
                .withMoney(200)
                .withName("Jose")
                .build();
        Npc npc02 = npcBuilder02.withAge(27)
                .withName("Aimee")
                .build();
        Npc npc03 = npcBuilder02.build();
        System.out.println("NPC01 " + npc01);
        System.out.println("NPC02 " + npc02);
        System.out.println("NPC03 " + npc03);

    }

}
