package Mechanism;

import Player_and_Utils.Boss;
import Player_and_Utils.Cards;
import Player_and_Utils.Enemy;
import Player_and_Utils.Player;
import Player_and_Utils.User;

public class LevelHandlers extends Mechanism {
    // static long currentTimeInSeconds = System.currentTimeMillis() / 1000;

    public LevelHandlers() {
        player = new User();
        boss = new Boss();
        this.initailiazing_enemies();
        System.out.println("Player Health: " + player.getPlayer_Health());
        System.out.println("Boss Health: " + boss.getPlayer_Health());
    }

    public class current_user {
        int user_health;
        Player enemy;
        int current_row_position;

        current_user(int player_health, Player enemy, int current_row_position) {
            this.user_health = player_health;
            this.enemy = enemy;
            this.current_row_position = current_row_position;

        }

    }

    // initailiazing the enemy array
    void initailiazing_enemies() {
        for (int i = 0; i < enemies.length; i++) {
            enemies[i] = new Enemy();
        }
    }

    // Level completion check method
    int total_enemies_dead = 0;

    public boolean isLevelCompleted(current_user[][] Play_Board, int total_enemies) {

        // coment this code below
        System.out.println("iscompleted function check is called<>");
        for (current_user[] e : Play_Board) {
            for (current_user f : e) {
                if (f != null) {
                    if (f.enemy instanceof Cards) {
                        Cards enemy = (Cards) f.enemy;
                        System.out.print(" player_health: " + f.user_health + " e_health: " + f.enemy.getPlayer_Health()
                                + " e_toalCards:" + enemy.getTotal_cards() + " pos:" + f.current_row_position + "\n");

                    }
                }
            }
        }
        int i = 0, j = 0;
        for (current_user[] e : Play_Board) {

            for (current_user f : e) {

                if (f != null) {
                    System.out.println("Player_close_death: " + f.enemy.getPlayer_Health());
                    if (f.enemy.getPlayer_Health() <= 0) {
                        f = null; // set the enemy to null
                        Play_Board[i][j] = null;
                        total_enemies_dead++;
                        System.out.println("total_enemies_dead: " + total_enemies_dead);
                        enemies[j] = null;
                    }
                    if (total_enemies_dead == total_enemies) {
                        System.out.println("All enemies dead huu!{<>}");
                        total_enemies_dead = 0;

                        return true;
                    }

                }
                j++;
            }
            i++;
        }
        return false;

    }

}
