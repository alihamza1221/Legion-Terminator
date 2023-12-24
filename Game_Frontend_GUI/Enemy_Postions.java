package Game_Frontend_GUI;

import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Enemy_Postions {

    public static void PlaceEnemiesInstances(JPanel enemy_layout_panel) throws Exception {

        Image image = ImageIO.read(new File("Game_Frontend_GUI\\Images\\Enemy_and_player_utils\\Enemy.png"));
        Image scaledImage = image.getScaledInstance(-1, 100, Image.SCALE_SMOOTH);
        ImageIcon eImageIcon = new ImageIcon(scaledImage);
        JLabel e_image_Label = new JLabel();
        e_image_Label.setIcon(eImageIcon);
        enemy_layout_panel.add(e_image_Label);
    }
}
