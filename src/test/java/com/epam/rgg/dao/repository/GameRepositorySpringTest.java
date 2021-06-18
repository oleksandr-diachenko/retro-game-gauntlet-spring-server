package com.epam.rgg.dao.repository;

import com.epam.rgg.dao.entity.Game;
import com.epam.rgg.junittag.SpringTag;
import com.github.database.rider.core.api.configuration.DBUnit;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.spring.api.DBRider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static com.epam.rgg.model.ConsoleType.NES;
import static org.assertj.core.api.Assertions.assertThat;

@SpringTag
@DataJpaTest
@DBRider
@DBUnit(mergeDataSets = true)
@DataSet({"console.yml", "year.yml"})
@ExtendWith(SpringExtension.class)
class GameRepositorySpringTest {

    @Autowired
    private GameRepository gameRepository;

    @Test
    @DataSet(value = "game.yml")
    void shouldReturnConsoleByType() {
        Optional<Game> actual = gameRepository.findById(1L);

        assertThat(actual)
                .map(Game::getName)
                .hasValue("Mario");
    }

    @Test
    @DataSet(value = "game.yml")
    void shouldReturnRandomGame() {
        Set<Optional<Game>> randoms = new HashSet<>();
        for (int i = 0; i < 50; i++) {
            randoms.add(gameRepository.findRandomGame(NES));
        }

        assertThat(randoms)
                .hasSizeGreaterThan(1)
                .map(Optional::get)
                .allMatch(game -> game.getConsole().getType() == NES);
    }
}