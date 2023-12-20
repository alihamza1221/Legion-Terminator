package Player_and_Utils;

public class Cards extends Player {

    public Cards(int player_health, int total_cards, int player_attack_cards, int player_defense_cards,
            int player_heal_cards, int player_replinish_cards) {

        super(player_health, total_cards, player_attack_cards, player_defense_cards, player_heal_cards,
                player_replinish_cards);

    }

    public int getAttack_cards() {
        return super.player_attack_cards;
    }

    public int getDefense_cards() {
        return super.player_defense_cards;
    }

    public int getHeal_cards() {
        return super.player_heal_cards;
    }

    public int getReplinish_cards() {
        return super.player_replinish_cards;
    }

    public void setAttack_cards(int attack_cards) {
        super.player_attack_cards = attack_cards;
    }

    public void setDefense_cards(int defense_cards) {
        super.player_defense_cards = defense_cards;
    }

    public void setHeal_cards(int heal_cards) {
        super.player_heal_cards = heal_cards;
    }

    public int getTotal_cards() {
        return super.total_cards;
    }

    public void setTotal_cards(int total_cards) {
        super.total_cards = total_cards;
    }

    public void setReplinish_cards(int replinish_cards) {
        super.player_replinish_cards = replinish_cards;
    }

    public void printCards() {
        System.out.println("Attack Cards: " + super.player_attack_cards);
        System.out.println("Defense Cards: " + super.player_defense_cards);
        System.out.println("Heal Cards: " + super.player_heal_cards);
        System.out.println("Replinish Cards: " + super.player_replinish_cards);

    }
}
