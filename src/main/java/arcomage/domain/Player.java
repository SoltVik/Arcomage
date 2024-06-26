package arcomage.domain;

import arcomage.controller.MyRestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
public class Player {
    static final Logger logger = LoggerFactory.getLogger(MyRestController.class);

    @Id
    @Column(name = "player_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    int wall;
    int tower;

    @OneToOne
    @JoinColumn(name = "enemy_id")
    Player enemyId;

    String sessionId;

    @ManyToMany
    @JoinTable(name = "player_hand", joinColumns = @JoinColumn(name = "player_id"), inverseJoinColumns = @JoinColumn(name = "card_id"))
    List<Card> hand;

    public Player() { }

    public Player(int id, String name, int wall, int tower) {
        this.id = id;
        this.name = name;
        this.wall = wall;
        this.tower = tower;
    }

    public Player(String name, int wall, int tower, List<Card> hand) {
        this.name = name;
        this.wall = wall;
        this.tower = tower;
        this.hand = hand;
    }

    public Player(int id, String name, int wall, int tower, List<Card> hand) {
        this.id = id;
        this.name = name;
        this.wall = wall;
        this.tower = tower;
        this.hand = hand;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getWall() {
        return wall;
    }

    public int getTower() {
        return tower;
    }

    public List<Card> getHand() {
        logger.info("Hand  {}", hand);
        return hand;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHand(List<Card> hand) {
        this.hand = hand;
    }

    public void setTower(int tower) {
        this.tower = tower;
    }

    public void setWall(int wall) {
        this.wall = wall;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }


    public List<Integer> getHandIds() {
        List<Integer> ids = new ArrayList<>();

        for (int i = 0;i < hand.size(); i++) {
            ids.add(hand.indexOf(i));
        }
        return ids;
    }

    public Player getEnemyId() {
        return enemyId;
    }

    public void setEnemyId(Player enemyId) {
        this.enemyId = enemyId;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", wall=" + wall +
                ", tower=" + tower +
                ", hand=" + hand +
                '}';
    }
}
