package Player_and_Utils;

public class Player {
    public int player_health;
    protected int total_cards;
    protected int player_attack_cards;
    protected int player_defense_cards;
    protected int player_heal_cards;
    protected int player_replinish_cards;

    // info about Current Level of game
    public static int current_level;

    // constructer
    public Player(int player_health, int total_cards, int player_attack_cards, int player_defense_cards,
            int player_heal_cards, int player_replinish_cards) {
        this.player_health = player_health;
        this.total_cards = total_cards;
        this.player_attack_cards = player_attack_cards;
        this.player_defense_cards = player_defense_cards;
        this.player_heal_cards = player_heal_cards;
        this.player_replinish_cards = player_replinish_cards;
        this.current_level = 1;
    }

    public Player() {
        // this.current_level = 3;
    }

    public int getPlayer_Health() {
        return this.player_health;
    }

    public void setPlayer_Health(int player_health) {
        this.player_health = player_health;
    }

}