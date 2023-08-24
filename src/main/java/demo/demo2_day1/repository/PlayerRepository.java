package demo.demo2_day1.repository;

import demo.demo2_day1.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player,Integer> {
    Player findByName(String player);
    Player findByNameLike(String name);
}
