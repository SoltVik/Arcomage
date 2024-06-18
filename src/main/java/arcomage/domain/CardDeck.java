package arcomage.domain;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CardDeck {
    private static List<Card> initData = new ArrayList<>();

    static {
        initData = Arrays.asList(
                new Card(1, "Brick Shortage", "All players lose 8 bricks", 0, 0, false, true),
                new Card(2, "Lucky Cache", "+2 Bricks. +2 Gems. Play again", 0, 0, true, true),
                new Card(3, "Friendly Terrain", "+1 Wall. Play again", 0, 1, true, true),
                new Card(4, "Miners", "+1 Quarry", 0, 3, false, true)

        );
    }

    public static List<Card> getCards(int num) {
        Random rand = new Random();

        List<Card> cards= new ArrayList<>();
        for (int start = 1; start <= num; start++) {
            int randomCard = rand.nextInt(initData.size());
            cards.add(initData.get(randomCard));
        }
        return cards;
    }

}
