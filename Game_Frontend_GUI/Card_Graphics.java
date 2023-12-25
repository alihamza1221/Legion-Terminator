package Game_Frontend_GUI;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Mechanism.UserPlayMenu;

public class Card_Graphics extends UserPlayMenu implements MouseListener {
    JLabel attackCJLabel, healJLabel, defenseJLabel, replinishJLabel;

    public Card_Graphics() {

    }

    UserPlayMenu user_menu_instance = null;

    public void addCardstoPanel(JPanel panel_bottom) {

        attackCJLabel = new JLabel("Attack Cards");
        healJLabel = new JLabel("Heal Cards");
        defenseJLabel = new JLabel("Defense Cards");
        replinishJLabel = new JLabel("Replinish Cards");

        Image attack_ScaledImage, healScaledImage, defenseScaledImage,
                replinishScaledImage;
        ImageIcon card_image = null;
        try {
            Image attackImage = ImageIO.read(new File("Game_Frontend_GUI\\Images\\attackCard.jpg"));
            attack_ScaledImage = attackImage.getScaledInstance(-1, 200, Image.SCALE_SMOOTH);
            card_image = new ImageIcon(attack_ScaledImage);
            attackCJLabel.setIcon(card_image);

            Image healImage = ImageIO.read(new File("Game_Frontend_GUI\\Images\\healCard.jpg"));
            healScaledImage = healImage.getScaledInstance(-1, 200, Image.SCALE_SMOOTH);
            card_image = new ImageIcon(healScaledImage);
            healJLabel.setIcon(card_image);

            Image defenseImage = ImageIO.read(new File("Game_Frontend_GUI\\Images\\defendCard.jpg"));
            defenseScaledImage = defenseImage.getScaledInstance(-1, 200, Image.SCALE_SMOOTH);
            card_image = new ImageIcon(defenseScaledImage);
            defenseJLabel.setIcon(card_image);

            Image replinishImage = ImageIO.read(new File("Game_Frontend_GUI\\Images\\ReplenishCard.jpg"));
            replinishScaledImage = replinishImage.getScaledInstance(-1, 200, Image.SCALE_SMOOTH);
            card_image = new ImageIcon(replinishScaledImage);
            replinishJLabel.setIcon(card_image);

        } catch (Exception e) {
            System.out.println("Something went wrong inside the enemies Cards Collection " + e);
        } finally {
            // System.out.println("--\nlen:" + obj.enemies.length);
        }

        attackCJLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        attackCJLabel.setVerticalTextPosition(SwingConstants.BOTTOM);

        healJLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        healJLabel.setVerticalTextPosition(SwingConstants.BOTTOM);

        defenseJLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        defenseJLabel.setVerticalTextPosition(SwingConstants.BOTTOM);

        replinishJLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        replinishJLabel.setVerticalTextPosition(SwingConstants.BOTTOM);

        panel_bottom.add(attackCJLabel);
        panel_bottom.add(healJLabel);
        panel_bottom.add(defenseJLabel);
        panel_bottom.add(replinishJLabel);

        attackCJLabel.addMouseListener(this);
        healJLabel.addMouseListener(this);
        defenseJLabel.addMouseListener(this);
        replinishJLabel.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        System.out.println("mouseClicked");

    }

    @Override
    public void mousePressed(MouseEvent e) {

        if (e.getSource() == attackCJLabel) {
            cardChoice = 1;

            ImageIcon icon = (ImageIcon) attackCJLabel.getIcon();
            Image img = icon.getImage().getScaledInstance(-1, 215, Image.SCALE_SMOOTH);
            attackCJLabel.setIcon(new ImageIcon(img));

            gameplay_trigger();

        }

        else if (e.getSource() == healJLabel) {
            cardChoice = 2;
            ImageIcon icon = (ImageIcon) healJLabel.getIcon();
            Image img = icon.getImage().getScaledInstance(-1, 215, Image.SCALE_SMOOTH);
            healJLabel.setIcon(new ImageIcon(img));

            gameplay_trigger();
        }

        else if (e.getSource() == defenseJLabel) {
            cardChoice = 3;

            ImageIcon icon = (ImageIcon) defenseJLabel.getIcon();
            Image img = icon.getImage().getScaledInstance(-1, 215, Image.SCALE_SMOOTH);
            defenseJLabel.setIcon(new ImageIcon(img));

            gameplay_trigger();
        }

        else if (e.getSource() == replinishJLabel) {
            cardChoice = 4;

            ImageIcon icon = (ImageIcon) replinishJLabel.getIcon();
            Image img = icon.getImage().getScaledInstance(-1, 215, Image.SCALE_SMOOTH);
            replinishJLabel.setIcon(new ImageIcon(img));

            gameplay_trigger();
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

        if (e.getSource() == attackCJLabel) {

            ImageIcon icon = (ImageIcon) attackCJLabel.getIcon();
            Image img = icon.getImage().getScaledInstance(-1, 200, Image.SCALE_SMOOTH);
            attackCJLabel.setIcon(new ImageIcon(img));

        } else if (e.getSource() == healJLabel) {

            ImageIcon icon = (ImageIcon) healJLabel.getIcon();
            Image img = icon.getImage().getScaledInstance(-1, 200, Image.SCALE_SMOOTH);
            healJLabel.setIcon(new ImageIcon(img));
        }

        else if (e.getSource() == defenseJLabel) {

            ImageIcon icon = (ImageIcon) defenseJLabel.getIcon();
            Image img = icon.getImage().getScaledInstance(-1, 200, Image.SCALE_SMOOTH);
            defenseJLabel.setIcon(new ImageIcon(img));
        }

        else if (e.getSource() == replinishJLabel) {

            ImageIcon icon = (ImageIcon) replinishJLabel.getIcon();
            Image img = icon.getImage().getScaledInstance(-1, 200, Image.SCALE_SMOOTH);
            replinishJLabel.setIcon(new ImageIcon(img));
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {

        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }
}
