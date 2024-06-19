package arcomage.repository;

import arcomage.domain.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Integer> {
    Player findById(int id);
    Player getBySessionId(String session);
}
