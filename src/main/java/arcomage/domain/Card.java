package arcomage.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Card {
    @Id
    @Column(name = "card_id")
    private int id;
    private String name;
    private String description;

    private int type;
    private int cost;

    @Column(name = "play_again")
    private boolean playAgain;

    @Column(name = "is_discardable")
    private boolean isDiscardable;


    public Card() { }

    public Card(int id, String name, String description, int type, int cost, boolean playAgain, boolean isDiscardable) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.cost = cost;
        this.playAgain = playAgain;
        this.isDiscardable = isDiscardable;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getType() {
        return type;
    }

    public int getCost() {
        return cost;
    }

    public boolean isPlayAgain() {
        return playAgain;
    }

    public boolean isDiscardable() {
        return isDiscardable;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", cost=" + cost +
                ", playAgain=" + playAgain +
                ", isDiscardable=" + isDiscardable +
                '}';
    }
}
