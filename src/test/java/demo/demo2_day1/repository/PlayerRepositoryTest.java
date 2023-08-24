package demo.demo2_day1.repository;

import demo.demo2_day1.entity.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PlayerRepositoryTest {

    @Autowired
    PlayerRepository playerRepository;
    boolean isInitialized = false;

    @BeforeEach
    void setUp() {
        if(!isInitialized){
            playerRepository.deleteAll();
            playerRepository.save(new Player("Lionel Messi","C1","P1"));
            playerRepository.save(new Player("P2","C2","P2"));
            isInitialized = true;
        }
    }

    @Test
    public void deleteAll(){
        playerRepository.deleteAll();
        assertEquals(0, playerRepository.count());
    }

    @Test
    public void testAll(){
        Long count = playerRepository.count();
        assertEquals(2, count);
    }

    @Test
    void findByName(){
        Player p1 = playerRepository.findByName("P2");
        assertEquals("P2", p1.getName());
    }

    @Test
    void findByNameLike(){
        Player p = playerRepository.findByNameLike("%Messi%");
        assertEquals("Lionel Messi", p.getName());
    }
}