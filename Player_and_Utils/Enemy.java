package Player_and_Utils;

import org.w3c.dom.CDATASection;

import Mechanism.LevelHandlers.current_user;

public class Enemy extends Cards {
    static int Enemy_health = 1;
    public int player_health;

    public Enemy(int player_health, int total_cards, int player_attack_cards, int player_defense_cards,
            int player_heal_cards, int player_replinish_cards) {

        super(player_health, total_cards, player_attack_cards, player_defense_cards, player_heal_cards,
                player_replinish_cards);

    }

    public Enemy() {
        this(Enemy_health, 4, 1, 1, 1, 1);
    }

    public static boolean[] EnemyAttack(current_user[][] playBoard, int total_e, Player player, Player[] enemies) {
        int random_enemy_attack = (int) (Math.random() * total_e) + 1;
        random_enemy_attack = (random_enemy_attack % 2) + 1;
        // player.setPlayer_Health(player.getPlayer_Health() - random_enemy_attack);

        int total_attacks = 0;
        int i = 0;
        // System.out.println("is attack found:" + random_enemy_attack);
        while (total_attacks < random_enemy_attack && i < enemies.length) {

            if (enemies[i] instanceof Cards) {

                Cards enemy = (Cards) enemies[i];
                // System.out.println("---{ " + enemy.getAttack_cards() + "}");
                if (enemy.getAttack_cards() > 0) {
                    enemy.setAttack_cards(enemy.getAttack_cards() - 1);
                    enemy.setTotal_cards(enemy.getTotal_cards() - 1);
                    player.setPlayer_Health(player.getPlayer_Health() - 1);
                    if (player.getPlayer_Health() <= 0) {

                        System.out.println("You lost!");
                        return new boolean[] { true, false };
                    }
                    System.out.println("EnemyAttack:> player_health:" + player.getPlayer_Health());
                    total_attacks++;
                }
            }
            i++;
        }

        i = 0;

        int count_leftAttacks = 0;
        while (i < enemies.length) {
            if (enemies[i] instanceof Cards) {
                Cards enemy = (Cards) enemies[i];
                if (enemy.getAttack_cards() <= 0) {
                    count_leftAttacks++;
                }
            }
            i++;
        }
        if (count_leftAttacks == enemies.length) {
            System.out.println("Enemies have no resourses: You won!");
            return new boolean[] { false, true };
        }
        return new boolean[] { true, true };
    }

    public static void EnemyDefense(current_user[][] playBoard, int total_e, Player player, Player[] enemies) {

        int random_enemy_defense = (int) (Math.random() * total_e) + 1;
        random_enemy_defense = (random_enemy_defense % 2) + 1;

        int total_defenses = 0;
        int i = 0;
        while (total_defenses < random_enemy_defense && i < enemies.length) {
            if (enemies[i] instanceof Cards) {
                Cards enemy = (Cards) enemies[i];
                if (enemy.getDefense_cards() > 0) {
                    enemy.setDefense_cards(enemy.getDefense_cards() - 1);
                    enemy.setTotal_cards(enemy.getTotal_cards() - 1);
                    enemy.setPlayer_Health(player.getPlayer_Health() + 1);
                    System.out.println("Enemy_health: " + enemy.getPlayer_Health());
                    total_defenses++;
                }
            }
            i++;
        }

        i = 0;
        int count_leftDefenses = 0;
        while (i < enemies.length) {
            if (enemies[i] instanceof Cards) {
                Cards enemy = (Cards) enemies[i];
                if (enemy.getDefense_cards() <= 0) {
                    count_leftDefenses++;
                }
            }
            i++;
        }
        if (count_leftDefenses == enemies.length) {
            System.out.println("Enemies have no defence!");
        }
    }

    public static void EnemyHeal(current_user[][] playBoard, int total_e, Player player, Player[] enemies) {

        int random_enemy_heal = (int) (Math.random() * total_e) + 1;
        random_enemy_heal = (random_enemy_heal % 2) + 1;

        int total_heals = 0;
        int i = 0;
        while (total_heals < random_enemy_heal && i < enemies.length) {
            if (enemies[i] instanceof Cards) {
                Cards enemy = (Cards) enemies[i];
                if (enemy.getHeal_cards() > 0) {
                    enemy.setHeal_cards(enemy.getHeal_cards() - 1);
                    enemy.setTotal_cards(enemy.getTotal_cards() - 1);
                    enemy.setPlayer_Health(enemy.getPlayer_Health() + 1);
                    System.out.println("Enemy_health: " + enemy.getPlayer_Health());
                    total_heals++;
                }
            }
            i++;
        }

        i = 0;
        int count_leftHeals = 0;
        while (i < enemies.length) {
            if (enemies[i] instanceof Cards) {
                Cards enemy = (Cards) enemies[i];
                if (enemy.getHeal_cards() <= 0) {
                    count_leftHeals++;
                }
            }
            i++;
        }
        if (count_leftHeals == enemies.length) {
            System.out.println("Enemies have no heal cards!");
        }
    }

    public static void EnemyReplinish(current_user[][] playBoard, int total_e, Player player, Player[] enemies,
            int choosenCard) {

        int random_enemy_replinish = (int) (Math.random() * total_e) + 1;
        random_enemy_replinish = (random_enemy_replinish % 2) + 1;

        int total_replinish = 0;
        int i = 0;
        while (total_replinish < random_enemy_replinish && i < enemies.length) {
            if (enemies[i] instanceof Cards) {
                Cards enemy = (Cards) enemies[i];
                if (enemy.getReplinish_cards() > 0) {
                    enemy.setReplinish_cards(enemy.getReplinish_cards() - 1);
                    enemy.setTotal_cards(enemy.getTotal_cards() - 1);
                    if (choosenCard == 1) {
                        enemy.setAttack_cards(enemy.getAttack_cards() + 1);
                        System.out.println("LuckyCard: Attack Card +1 updated_Cards :" + enemy.getAttack_cards());
                    } else if (choosenCard == 2) {
                        enemy.setDefense_cards(enemy.getDefense_cards() + 1);
                        System.out.println("LuckyCard: Defense Card +1 updated_Cards :" + enemy.getDefense_cards());
                    } else if (choosenCard == 3) {
                        enemy.setHeal_cards(enemy.getHeal_cards() + 1);
                        System.out.println("LuckyCard: Heal Card +1 updated_Cards :" + enemy.getHeal_cards());
                    } else {
                        enemy.setReplinish_cards(enemy.getReplinish_cards() + 1);
                        System.out
                                .println("LuckyCard: Replinish Card +1 updated_Cards : " + enemy.getReplinish_cards());
                    }
                    total_replinish++;
                }
            }
            i++;
        }

        i = 0;
        int count_leftReplinish = 0;
        while (i < enemies.length) {
            if (enemies[i] instanceof Cards) {
                Cards enemy = (Cards) enemies[i];
                if (enemy.getReplinish_cards() <= 0) {
                    count_leftReplinish++;
                }
            }
            i++;
        }
        if (count_leftReplinish == enemies.length) {
            System.out.println("Enemies have no replinish cards!");
        }
    }

}
