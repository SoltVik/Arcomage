package arcomage.controller;

import arcomage.domain.Player;
import arcomage.service.PlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/card")
public class MyRestController {
    @Autowired
    PlayerService playerService;

    static final Logger logger = LoggerFactory.getLogger(MyRestController.class);


    @PostMapping(value = "/play")
    public String play(Integer cardId, int playerId, int enemyId) {
        Player player = playerService.findById(playerId);
        Player enemy = playerService.findById(enemyId);

        return getJSONReturn(player, enemy);
    }

    @PostMapping(value = "/hand")
    public List<Integer> hand(Integer playerId) {
        logger.info("Player Id {}", playerId);
        Player player = playerService.findById(playerId);
        List<Integer> cardIds = player.getHandIds();

        return cardIds;
    }

    private String getJSONReturn(Player player, Player enemy) {
        return "{\n" +
                "\"status\": 200,\n" +
                "\"player\": { \n" +
                    "\"id\":" + player.getId() + ",\n" +
                    "\"name\":" + player.getName() + ",\n" +
                    "\"wall\":" + player.getWall() + ",\n" +
                    "\"tower\":" + player.getTower() + ",\n" +
                    //"\"hand\":" + Arrays.toString(player.getHandIds().toArray()) + ",\n" +
                "},\n" +
                "\"enemy\": { \n" +
                    "\"id\":" + enemy.getId() + ",\n" +
                    "\"name\":" + enemy.getName() + ",\n" +
                    "\"wall\":" + enemy.getWall() + ",\n" +
                    "\"tower\":" + enemy.getTower() + ",\n" +
                    //"\"hand\":" + Arrays.toString(enemy.getHandIds().toArray()) + ",\n" +
                "},\n" +
                "}";
    }
}
