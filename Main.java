import Mechanism.UserPlayMenu;

public class Main extends UserPlayMenu {
    Main() {
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {

        UserPlayMenu obj = new UserPlayMenu();
        try {
            obj.enemies[0].player_health = 10;
            obj.enemies[1].player_health = 2;
            System.out.println(obj.enemies[0].player_health);
            System.out.println(obj.enemies[1].player_health);
            System.out.println(obj.enemies[2].getPlayer_Health());
        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
            System.out.println("Something went wrong inside the enemies collection array" + e);
        } finally {
            System.out.println("--\nlen:" + obj.enemies.length);
        }

    }
}
