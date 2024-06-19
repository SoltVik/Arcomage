package arcomage.controller;

import arcomage.domain.*;
import arcomage.service.PlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Controller
public class SimpleController {

    static final Logger logger = LoggerFactory.getLogger(MyRestController.class);

    @Autowired
    PlayerService playerService;

    @GetMapping("/")
    public String index(Model model, HttpSession session) {
        List<Card> playerHand = new ArrayList<>(CardDeck.getCards(5));
        List<Card> enemyHand = new ArrayList<>(CardDeck.getCards(5));

        //Session check

        //Load session

        //New session


        Player player = new Player("Player", 10, 20, playerHand);
        Player enemy = new Player("Opponent", 10,20, enemyHand);


        player.setSessionId(session.getId());

        playerService.save(player);
        playerService.save(enemy);
        player = playerService.getBySessionId(session.getId());
        enemy.setId(player.getId() + 1);

        player.setEnemyId(enemy);
        enemy.setEnemyId(player);

        model.addAttribute("player", player);
        model.addAttribute("enemy", enemy);
        return "index";
    }


}
