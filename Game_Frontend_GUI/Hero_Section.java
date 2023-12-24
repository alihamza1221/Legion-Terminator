package Game_Frontend_GUI;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Hero_Section {

    public static void user_hero_section(JPanel bottom_panel) {
        JLabel user_view = new JLabel("Player");

        try {
            Image user_icon = ImageIO
                    .read(new File("Game_Frontend_GUI\\Images\\Enemy_and_player_utils\\user_player.jpeg"));
            user_icon = user_icon.getScaledInstance(-1, 100, Image.SCALE_SMOOTH);
            user_view.setIcon(new ImageIcon(user_icon));
        } catch (Exception e) {
            System.out.println("Something went wrong inside the user hero section" + e);
        }
        user_view.setHorizontalTextPosition(SwingConstants.CENTER);
        user_view.setVerticalTextPosition(SwingConstants.BOTTOM);
        user_view.setHorizontalAlignment(SwingConstants.CENTER);
        user_view.setVerticalAlignment(SwingConstants.BOTTOM);

        bottom_panel.add(user_view, BorderLayout.SOUTH);
    }
}
