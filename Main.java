import Game_Frontend_GUI.Menu;
import Mechanism.UserPlayMenu;

public class Main {// extend user palyer menu first
    Main() {
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {

        // UserPlayMenu obj = new UserPlayMenu();
        try {
            Menu obj = new Menu();

        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
            System.out.println("Something went wrong inside the enemies collection array" + e);
        } finally {
            // System.out.println("--\nlen:" + obj.enemies.length);
        }

    }
}
