package Game_Frontend_GUI;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Mechanism.*;
import Mechanism.LevelHandlers.current_user;

public class Menu {
    JFrame frame;
    JMenuBar menubar;
    JMenu level, enemy_fields, player_fields, settings;
    JMenuItem level_1, level_2, level_3;
    JMenuItem player_health, total_Cards, attack_cards, replinish_cards;

    JPanel panel_top, panel_bottom, panel_left, panel_right;
    JTextField textfied_name, textField_health, textField_attack_cards, textField_replinish_cards;

    ImageIcon logo_icon;
    ImageIcon background = null;

    public Menu() {
        frame = new JFrame();
        menubar = new JMenuBar();
        level = new JMenu("Level");
        enemy_fields = new JMenu("Enemy Fields");
        player_fields = new JMenu("Player Fields");
        settings = new JMenu("Settings");

        level_1 = new JMenuItem("Level 1");
        level_2 = new JMenuItem("Level 2");
        level_3 = new JMenuItem("Level 3");

        player_health = new JMenuItem("Player Health");
        total_Cards = new JMenuItem("Total Cards");
        attack_cards = new JMenuItem("Attack Cards");
        replinish_cards = new JMenuItem("Replinish Cards");

        panel_top = new JPanel();
        panel_bottom = new JPanel();
        panel_left = new JPanel();
        panel_right = new JPanel();

        textfied_name = new JTextField("Name");
        textField_attack_cards = new JTextField("Attack Cards");
        textField_health = new JTextField("Health");
        textField_replinish_cards = new JTextField("Replinish Cards");
        Image scaledImage = null;
        Image background_image_scaled = null;
        try {
            Image image = ImageIO.read(new File("Game_Frontend_GUI\\Images\\terminator_logo.jpg"));
            scaledImage = image.getScaledInstance(-1, 300, Image.SCALE_SMOOTH);

            Image backGround_image = ImageIO.read(new File("Game_Frontend_GUI\\Images\\background.jpg"));
            background_image_scaled = backGround_image.getScaledInstance(-1, 1000, Image.SCALE_SMOOTH);
        } catch (Exception e) {
            System.out.println("Something went wrong inside the enemies collection array" + e);
        }
        logo_icon = new ImageIcon(scaledImage);
        // creating background image
        background = new ImageIcon(background_image_scaled);

        // setBorder(BorderFactory.createLineBorder(new Color(255, 255, 21, true));
        JPanel hero_section_panel = new JPanel();
        hero_section_panel.setLayout(new BorderLayout());

        Hero_Section.user_hero_section(hero_section_panel);
        hero_section_panel.setVisible(true);
        // cards

        frame.setLayout(new BorderLayout());
        frame.setIconImage(logo_icon.getImage());
        frame.add(panel_top, BorderLayout.NORTH);
        frame.add(panel_left, BorderLayout.WEST);
        frame.add(hero_section_panel, BorderLayout.CENTER);
        // frame.add(panel_bottom, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        UserPlayMenu user_game_menu = null;
        try {
            user_game_menu = new UserPlayMenu(frame, hero_section_panel, panel_bottom);

        } catch (Exception e) {
            System.out.println("Something went wrong inside the enemies collection array" + e);
        } finally {
            System.out.println("--\nlen:" + user_game_menu.enemies.length);
        }

        Card_Graphics card = new Card_Graphics();
        card.addCardstoPanel(panel_bottom);
        frame.add(hero_section_panel, BorderLayout.CENTER);
        frame.add(panel_bottom, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);

    }

    // @Override
    // public void paint(Graphics g) {
    // super.paint(g);
    // Graphics2D g2d = (Graphics2D) g;
    // float opacity = 0.2f;
    // g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
    // opacity));
    // g2d.drawImage(background.getImage(), 0, 0, null);
    // g2d.dispose();
    // }

}
