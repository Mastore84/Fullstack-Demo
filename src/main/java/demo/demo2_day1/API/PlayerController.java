package demo.demo2_day1.API;

import demo.demo2_day1.entity.Player;
import demo.demo2_day1.repository.PlayerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
    @RequestMapping("/api/players")
    public class PlayerController {

        PlayerRepository playerRepository;

        public PlayerController(PlayerRepository playerRepository) {
            this.playerRepository = playerRepository;
        }

        @GetMapping
        List<Player> getPlayers() {
            return  playerRepository.findAll();
        }
    }