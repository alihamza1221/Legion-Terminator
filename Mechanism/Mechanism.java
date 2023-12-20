package Mechanism;

import Player_and_Utils.*;

public class Mechanism extends Player {
    public Player player;
    public Player boss;
    public Player[] enemies = new Player[1];

    enum cardType {
        ATTACK, DEFENSE, HEAL, REPLENISH
    }

    public Mechanism() {
        // dynamic array for the count of num of enemies according to the Level
        System.out.println("lenArr:" + enemies.length + " level:" + current_level);
        if (super.current_level > enemies.length) {
            enemy_Array_length_Adjutment();
        } else if (current_level < enemies.length) {
            enemy_Array_length_Adjutment();
        }
        System.out.println("-->lenArr:" + enemies.length + " level:" + current_level);
    }

    void enemy_Array_length_Adjutment() {
        Player[] temp = new Player[current_level];
        for (int i = 0; i < current_level; i++) {
            temp[i] = new Enemy();
        }
        int i = 0;
        for (Player cur : enemies) {
            if (cur != null && i < current_level)
                temp[i++] = cur;
        }
        enemies = temp;
    }

    public int EnemyCardPicker(Player enemy) {
        int choosenCard = (int) Math.random() * 4 + 1;
        return choosenCard;
    }

    public int ReplanishCardUse(Player CurrentPlayer) {
        int choosenCard = (int) Math.random() * 3 + 1;
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