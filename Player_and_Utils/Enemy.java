package Player_and_Utils;

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

}
