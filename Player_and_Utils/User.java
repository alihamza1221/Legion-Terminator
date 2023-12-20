package Player_and_Utils;

public class User extends Cards {
    // pass parameters to the super class constructor.

    public User(int player_health, int total_cards, int player_attack_cards, int player_defense_cards,
            int player_heal_cards, int player_replinish_cards) {

        super(player_health, total_cards, player_attack_cards, player_defense_cards, player_heal_cards,
                player_replinish_cards);
    }

    public User() {
        this(3, 9, 4, 2, 2, 1);
    }
}
