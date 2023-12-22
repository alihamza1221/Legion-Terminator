package Mechanism;

import Player_and_Utils.Cards;
import java.util.Scanner;

import Player_and_Utils.Cards;
import Player_and_Utils.Player;

public class UserPlayMenu extends LevelHandlers {
    public UserPlayMenu() {
        System.out.println("Welcome to Legion Terminator");
        char choice;
        Scanner sc = new Scanner(System.in);
        System.out.println("Play game : (y/n)");
        choice = sc.next().charAt(0);

        while ((choice != 'n') || (choice != 'N')) {
            if ((choice == 'y') || (choice == 'Y')) {
                System.out.println("Enter your name: ");
                String name = sc.next();
                System.out.println("Welcome " + name + " to Legion Terminator");
                System.out.println("Choose your level: ");
                System.out.println("1. Easy");
                System.out.println("2. Medium");
                System.out.println("3. Hard");
                System.out.println("4. Exit");
                int level = sc.nextInt();
                // level == Speed of the enemy approching towards the end
                // currentTimeInSeconds = currentTimeInSeconds + level;

                current_user[][] Play_Board = new current_user[10][10];
                while (level < 10) {
                    System.out.println("You are in:" + current_level + " level");
                    System.out.println("You have " + current_level + " enemy");
                    setCurrentLevel(current_level);
                    System.out.println("after_passing_setcurrnet_level:" + current_level + " \n");

                    PlaceEnemies(Play_Board, enemies.length);
                    System.out.println("enemies length_check> " + enemies.length);
                    // Game rules and gamePlay starts from here
                    gamePlay(Play_Board, enemies.length);

                }

                Cards card = (Cards) player;
                System.out.println("Player Health: " + player.getPlayer_Health() + " Heal_Cards:" + card.getHeal_cards()
                        + " Attack_Cards:" + card.getAttack_cards() + " Defense_Cards:" + card.getDefense_cards()
                        + " Replinish_Cards:" + card.getReplinish_cards() + " Total_Cards:" + card.getTotal_cards());
                System.out.println("Boss Health: " + boss.getPlayer_Health());

                DisplayEnemycharacteristics(Play_Board);
            }
        }
    }

    public void setCurrentLevel(int level) {
        System.out.println("Current Level_inside_setcurrent: " + current_level + "level:" + level + "\n");

        current_level = level;

        enemy_Array_length_Adjutment(level);
    }

    public void gamePlay(current_user[][] Play_Board, int size) {
        int level_in_progress = current_level;
        while (player.getPlayer_Health() > 0 && boss.getPlayer_Health() > 0 && level_in_progress == current_level) {
            System.out.println("Choose your card: ");
            System.out.println("1. Attack");
            System.out.println("2. Defense");
            System.out.println("3. Heal");
            System.out.println("4. Replinish");

            Scanner sc = new Scanner(System.in);
            int cardChoice = sc.nextInt();
            Cards userPlayer = (Cards) player;
            boolean result = false;
            switch (cardChoice) {

                case 1:

                    if (userPlayer.getAttack_cards() <= 0) {
                        System.out.println("You have no Attack cards left!");
                        break;
                    }
                    System.out.println("Enemy Health loss : -1");

                    userPlayer.setAttack_cards(userPlayer.getAttack_cards() - 1);
                    userPlayer.setTotal_cards(userPlayer.getTotal_cards() - 1);
                    System.out.println("userPlayer_Health: " + player.getPlayer_Health());
                    // That's Ninja's turn all enemies are gonna share the consequences

                    enemyHealthDecreaseOnAttack(Play_Board, size);

                    // check that if all enemies are dead level completed
                    result = super.isLevelCompleted(Play_Board, size);
                    if (result) {
                        System.out.println("Level: " + current_level + " Completed 🏆");
                        current_level++;
                        // call init func for enemy
                        // setCurrentLevel(current_level);
                        System.out.println("dummy check gameplay complete condtion: current_level: " + current_level);
                        break;
                    }
                    System.out.println("Player Health: " + player.getPlayer_Health() + " Heal_Cards:"
                            + userPlayer.getHeal_cards() + " Attack_Cards:" + userPlayer.getAttack_cards()
                            + " Defense_Cards:" + userPlayer.getDefense_cards() + " Replinish_Cards:"
                            + userPlayer.getReplinish_cards() + " Total_Cards:" + userPlayer.getTotal_cards());

                    DisplayEnemycharacteristics(Play_Board);

                    break;
                case 2:
                    System.out.println("You have chosen Defense card");
                    if (userPlayer.getDefense_cards() <= 0) {
                        System.out.println("You have no Defence cards left!");
                        break;
                    }
                    System.out.println("Extra Attack defend +1");
                    userPlayer.setPlayer_Health(userPlayer.getPlayer_Health() + 1);
                    userPlayer.setTotal_cards(userPlayer.getTotal_cards() - 1);
                    userPlayer.setDefense_cards(userPlayer.getDefense_cards() - 1);
                    System.out.println("Updated_Defend_Power: " + player.getPlayer_Health());

                    break;
                case 3:
                    System.out.println("You have chosen Heal card");
                    if (userPlayer.getHeal_cards() <= 0) {
                        System.out.println("You have no Heal cards left!");
                        break;
                    }
                    if (userPlayer.getPlayer_Health() >= 3) {
                        System.out.println("You have max health:" + userPlayer.getPlayer_Health());
                        break;
                    }
                    userPlayer.setPlayer_Health(userPlayer.getPlayer_Health() + 1);
                    userPlayer.setTotal_cards(userPlayer.getTotal_cards() - 1);
                    userPlayer.setHeal_cards(userPlayer.getHeal_cards() - 1);
                    System.out.println("Health restored +1");
                    System.out.println("Update_Health: " + player.getPlayer_Health());

                    break;

                case 4:
                    System.out.println("You have chosen Replinish card");
                    if (userPlayer.getReplinish_cards() <= 0) {
                        System.out.println("You have no Replinish cards left!");
                        break;
                    }
                    ReplanishCardUse(player);// The randomization methods are defined in the Mechanism Class
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
            if (result)
                break;
            HandleEnemyTurn(Play_Board, size);

        }
    }

    void PlaceEnemies(current_user[][] Play_Board, int size) {
        for (int i = 0; i < enemies.length; i++) {
            System.out.println("Inside enemy placement>(" + enemies.length);

            if (enemies != null && enemies[i] != null) {
                Play_Board[0][i] = new current_user(player.player_health, enemies[i], 0);
                System.out.println("Inside enemy placement" + enemies[i].getPlayer_Health());
            }

        }
    }

    void enemyHealthDecreaseOnAttack(current_user[][] Play_Board, int size) {
        System.out.println("current_level:{" + current_level + "}");
        int attackPowerCount = current_level / 2 + 1;
        for (current_user[] e : Play_Board) {
            for (current_user f : e) {
                if (f != null)
                    if (f.enemy instanceof Cards) {
                        Cards enemyCards = (Cards) f.enemy;
                        enemyCards.setPlayer_Health(enemyCards.getPlayer_Health() - 1);
                        System.out.println("e_health: {" + enemyCards.getPlayer_Health() + "}");
                        attackPowerCount--;
                        if (enemyCards.getPlayer_Health() == 0) {
                            System.out.println("Enemy is dead");
                            // f = null;
                        }
                        if (attackPowerCount == 0) {
                            break;
                        }

                    }
            }
        }
    }

    void DisplayEnemycharacteristics(current_user[][] Play_Board) {
        for (current_user[] e : Play_Board) {
            for (current_user f : e) {
                if (f != null)
                    if (f.enemy instanceof Cards) {
                        Cards enemyCards = (Cards) f.enemy;
                        System.out.print("e_health:" + enemyCards.getPlayer_Health() + "e_toalCards:"
                                + enemyCards.getTotal_cards() + " pos:" + f.current_row_position + "\n");
                    }
            }
        }
    }
}