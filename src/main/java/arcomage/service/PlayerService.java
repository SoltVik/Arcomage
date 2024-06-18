package arcomage.service;

import arcomage.controller.MyRestController;
import arcomage.domain.Card;
import arcomage.domain.Player;
import arcomage.repository.PlayerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PlayerService {
    static final Logger logger = LoggerFactory.getLogger(MyRestController.class);

    @Autowired
    private PlayerRepository playerRepository;

    public Player findById(int idx) {
        Player result = playerRepository.findById(idx);
        return result;
    }


    public void save(Player player) {
        logger.info("Updated Player {}", player);
        playerRepository.save(player);
    }
}
