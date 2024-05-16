package Mechanism;

import Player_and_Utils.Cards;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import Game_Frontend_GUI.Card_Graphics;
import Game_Frontend_GUI.Enemy_Postions;
import Player_and_Utils.Cards;
import Player_and_Utils.Player;
import Player_and_Utils.User;

public class UserPlayMenu extends LevelHandlers {
    public int cardChoice = 0;
    DefaultTableModel player_model = new DefaultTableModel();
    DefaultTableModel enemy_model = new DefaultTableModel();
    DefaultTableModel level_model = new DefaultTableModel();

    JTable player_tabel;
    JTable enemy_tabel;
    JTable level_tabel;

    JScrollPane scrollPane;
    JFrame menu_frame;

    public current_user[][] Play_Board = null;

    public UserPlayMenu() {
    };

    public UserPlayMenu(JFrame frame, JPanel hero_section_panel, JPanel panel_bottom) throws InterruptedException {
        menu_frame = new JFrame("Menu");

        System.out.println("Welcome to Legion Terminator");
        JPanel enemy_layout_panel;
        try {
            enemy_layout_panel = e_layout_add();
            hero_section_panel.add(enemy_layout_panel, BorderLayout.CENTER);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ImageIcon diolog_image = new ImageIcon("Game_Frontend_GUI\\Images\\startDiolgimage.jpg");
        Image scaledImage = diolog_image.getImage().getScaledInstance(-1, 250, Image.SCALE_SMOOTH);
        diolog_image = new ImageIcon(scaledImage);

        JPanel yes_no_panel = new JPanel(new BorderLayout());
        JLabel messageLabel = new JLabel("Play Legion Terminaotr!");
        messageLabel.setFont(new Font("Arial", Font.BOLD, 20));
        messageLabel.setIcon(diolog_image);
        messageLabel.setHorizontalTextPosition(JLabel.CENTER);
        messageLabel.setVerticalTextPosition(JLabel.BOTTOM);
        yes_no_panel.add(messageLabel, BorderLayout.CENTER);

        int response = JOptionPane.YES_NO_OPTION;

        Scanner sc = new Scanner(System.in);

        while (response == JOptionPane.YES_OPTION) {
            response = JOptionPane.showOptionDialog(null, yes_no_panel, "Legion Terminator", JOptionPane.YES_NO_OPTION,
                    JOptionPane.PLAIN_MESSAGE, null, null, null);
            if (response == JOptionPane.NO_OPTION)
                return;
            if (response == JOptionPane.YES_OPTION) {
                String name = JOptionPane.showInputDialog("Enter your name: ");
                User user = (User) player;
                user.player_name = name;
                JOptionPane.showMessageDialog(null, "Welcome " + name + " to Legion Terminator");

                String[] level_choices = { "Easy", "Medium", "Hard", "Exit" };
                int level = JOptionPane.showOptionDialog(null, "Choose your level: ", "Legion Terminator",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, level_choices, level_choices[0]);
                level = level + 1;

                Play_Board = new current_user[10][10];
                current_level = level;
        
                while (level < 10 && current_level > 0 && current_level < 10) {
                    System.out.println("((( You are in:" + current_level + " level )))");
          
                    JOptionPane.showMessageDialog(null, "WELCOME YOU ARE IN " + current_level + "LEVEL");

                    setCurrentLevel(current_level);
                    PlaceEnemies(Play_Board, enemies.length);
            
                    gamePlay(Play_Board, enemies.length);

                    Cards temp = (Cards) player;
                    if (player.getPlayer_Health() <= 0 || temp.getAttack_cards() <= 0 || temp.getTotal_cards() <= 0) {
                        System.out.println("Game over you dead!");
                        JOptionPane.showMessageDialog(null, "Game Over you are dead!", "Game Over",
                                JOptionPane.ERROR_MESSAGE);
                        break;
                    }

                    temp.setAttack_cards(temp.getAttack_cards() + 1);
                    System.out.println("New Level: " + current_level);

                    DisplayEnemycharacteristics(Play_Board);
                }
                Cards card = (Cards) player;

            }
        }
    }

    JPanel e_layout_add() throws Exception {
        JPanel enemy_layout_panel = new JPanel();
        enemy_layout_panel.setLayout(new FlowLayout());

        for (int i = 0; i < current_level || i < 4

        ; i++) {
            Enemy_Postions.PlaceEnemiesInstances(enemy_layout_panel);
        }
        return (enemy_layout_panel);
    }

    public void setCurrentLevel(int level) {

        current_level = level;
        enemy_Array_length_Adjutment(level);
    }

    public void gameplay_trigger() {
        gamePlay(Play_Board, current_level);
    }

    public void gamePlay(current_user[][] Play_Board, int size) {
        int level_in_progress = current_level;
        while (player.getPlayer_Health() > 0 && boss.getPlayer_Health() > 0 && level_in_progress == current_level) {
            String[] card_choices = { "Attack", "Defense", "Heal", "Replinish" };
            int cardChoice = JOptionPane.showOptionDialog(null, "Choose your card: ",
                    "Legion Terminator",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, card_choices,
                    card_choices[0]);
            Scanner sc = new Scanner(System.in);
            Cards userPlayer = (Cards) player;
            boolean result = false;
            cardChoice += 1;
            String[] fields = { "Player Health", "Attack Cards", "Health Cards", "Defence Cards", "Replenish Cards",
                    "Total Cards" };
            for (String field : fields)
                player_model.addColumn(fields);
            player_tabel = new JTable(player_model);
            Cards player_Instance = (Cards) player;

            System.out.println("[ Player Health: " + player.getPlayer_Health() + " Attack Cards: "
                    + player_Instance.getAttack_cards() + " Heal Cards: " + player_Instance.getAttack_cards()
                    + " Defence Cards: " + player_Instance.getDefense_cards() + " Replenish Cards: "
                    + player_Instance.getReplinish_cards() + " Total Cards: " + player_Instance.getTotal_cards()
                    + " ]");
            switch (cardChoice) {

                case 1:

                    if (userPlayer.getAttack_cards() <= 0) {
                        System.out.println("You have no Attack cards left!");
                        break;
                    }
                    System.out.println("Enemy Health loss : -1");

                    userPlayer.setAttack_cards(userPlayer.getAttack_cards() - 1);
                    userPlayer.setTotal_cards(userPlayer.getTotal_cards() - 1);

                    enemyHealthDecreaseOnAttack(Play_Board, size);

                    // check that if all enemies are dead level completed
                    result = super.isLevelCompleted(Play_Board, size);
                    if (result) {
                        System.out.println("Level: " + current_level + " Completed 🏆");
                        current_level++;
                        break;
                    }

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
                        userPlayer.setTotal_cards(userPlayer.getTotal_cards() - 1);
                        userPlayer.setHeal_cards(userPlayer.getHeal_cards() - 1);
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
                    result = true;
                    player_health = 0;
                    current_level = -2;
                    break;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO
                e.printStackTrace();
            }
            if (result)
                break;
            HandleEnemyTurn(Play_Board, size);
            if (e_turn_res[0] == true && e_turn_res[1] == false) {
                // game over
                break;

            } else if (e_turn_res[0] == false && e_turn_res[1] == true) {
                // next level
                current_level++;
                break;
            } else {
                // successfull attack
            }

            Cards temp = (Cards) player;
            if (player.getPlayer_Health() <= 0 || temp.getAttack_cards() <= 0 || temp.getTotal_cards() <= 0) {
                System.out.println("Game over you dead!");
                JOptionPane.showMessageDialog(null, "Game Over you are dead!", "Game Over",
                        JOptionPane.ERROR_MESSAGE);
                break;
            }

        }
    }

    void PlaceEnemies(current_user[][] Play_Board, int size) {
        for (int i = 0; i < enemies.length; i++) {
            if (enemies != null && enemies[i] != null) {
                Play_Board[0][i] = new current_user(player.player_health, enemies[i], 0);
            }

        }
    }

    void enemyHealthDecreaseOnAttack(current_user[][] Play_Board, int size) {
        int attackPowerCount = current_level / 2 + 1;
        for (current_user[] e : Play_Board) {
            for (current_user f : e) {
                if (f != null)
                    if (f.enemy instanceof Cards) {
                        Cards enemyCards = (Cards) f.enemy;
                        enemyCards.setPlayer_Health(enemyCards.getPlayer_Health() - 1);
   
                        attackPowerCount--;
                        if (enemyCards.getPlayer_Health() == 0) {
                            System.out.println("Enemy is dead");
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
                if (f != null){
                    if (f.enemy instanceof Cards) {
                        Cards enemyCards = (Cards) f.enemy;
                        System.out.print("[ E_health: " + enemyCards.getPlayer_Health() + " Attack Cards: "
                                + enemyCards.getAttack_cards() + " Defend Cards: " + enemyCards.getDefense_cards()
                                + " Heal Cards: " + enemyCards.getHeal_cards()
                                + " TotalCards: "
                                + enemyCards.getTotal_cards() + " pos: " + f.current_row_position + " ]\n");
                    }
            }
        }
    }
}
