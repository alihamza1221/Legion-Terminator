package Mechanism;

import Mechanism.LevelHandlers.current_user;
import Player_and_Utils.*;

public class Mechanism extends Player {
    public Player player;
    public Player boss;
    public Player[] enemies = new Player[1];

    enum cardType {
        ATTACK, DEFENSE, HEAL, REPLENISH
    }

    public Mechanism() {
   
        if (super.current_level > enemies.length) {
            enemy_Array_length_Adjutment(current_level);
        } else if (current_level < enemies.length) {
            enemy_Array_length_Adjutment(current_level);
        }
    }

    void enemy_Array_length_Adjutment(int level) {
        if (level < 1)
            return;
        Player[] temp = new Player[level];

        for (int i = 0; i < temp.length; i++) {
            temp[i] = new Enemy();
        }
        current_level = level;

        enemies = temp;
    }

    public int EnemyCardPicker() {
        int choosenCard = (int) (Math.random() * 4) + 1;
        return (choosenCard % 3) + 1;
    }

    boolean[] e_turn_res = new boolean[2];

    protected void HandleEnemyTurn(current_user[][] playBoard, int total_e) {
        int cardNo = EnemyCardPicker();
        System.out.println("EnemyCardPicker Card No: " + cardNo);

        if (cardNo == 1) {
            e_turn_res = Enemy.EnemyAttack(playBoard, total_e, player, enemies);
        } else if (cardNo == 2) {
            Enemy.EnemyDefense(playBoard, total_e, player, enemies);
        } else if (cardNo == 3) {
            Enemy.EnemyHeal(playBoard, total_e, player, enemies);
        } else if (cardNo == 4) {
            int choosenCard = EnemyCardPicker();
            Enemy.EnemyReplinish(playBoard, total_e, player, enemies, choosenCard);
        }
    }

    public int ReplanishCardUse(Player CurrentPlayer) {
        if (CurrentPlayer instanceof Cards) {
            Cards curPlayer = (Cards) CurrentPlayer;
            curPlayer.setReplinish_cards(player_replinish_cards - 1);
        }
        int choosenCard = (int) (Math.random() * 3) + 1;
        Cards PLayer_Instance = (Cards) CurrentPlayer;
        if (choosenCard == 1) {

            PLayer_Instance.setAttack_cards(PLayer_Instance.getAttack_cards() + 1);
            System.out.println("LuckyCard: Attack Card +1 updated_Cards :" + PLayer_Instance.getAttack_cards());
        } else if (choosenCard == 2) {
            PLayer_Instance.setDefense_cards(PLayer_Instance.getDefense_cards() + 1);
            System.out.println("LuckyCard: Defense Card +1 updated_Cards :" + PLayer_Instance.getDefense_cards());
        } else if (choosenCard == 3) {
            PLayer_Instance.setHeal_cards(PLayer_Instance.getHeal_cards() + 1);
            System.out.println("LuckyCard: Heal Card +1 updated_Cards :" + PLayer_Instance.getHeal_cards());
        }

        return choosenCard;
    }

}
