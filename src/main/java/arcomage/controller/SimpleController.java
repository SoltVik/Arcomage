package arcomage.controller;

import arcomage.domain.*;
import arcomage.service.PlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class SimpleController {

    static final Logger logger = LoggerFactory.getLogger(MyRestController.class);

    @Autowired
    PlayerService playerService;

    @GetMapping("/")
    public String index(Model model) {
        List<Card> playerHand = new ArrayList<>(CardDeck.getCards(5));
        List<Card> enemyHand = new ArrayList<>(CardDeck.getCards(5));
        Player player = new Player(1,"Player", 10, 20, playerHand);
        Player enemy = new Player(2,"Opponent", 10,20, enemyHand);

        model.addAttribute("player", player);
        model.addAttribute("enemy", enemy);
        return "index";
    }


}
