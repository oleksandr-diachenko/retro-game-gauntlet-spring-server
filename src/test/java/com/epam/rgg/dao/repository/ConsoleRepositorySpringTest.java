package com.epam.rgg.dao.repository;

import com.epam.rgg.dao.entity.Console;
import com.epam.rgg.junittag.SpringTag;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.spring.api.DBRider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static com.epam.rgg.model.ConsoleType.NES;
import static org.assertj.core.api.Assertions.assertThat;

@SpringTag
@DataJpaTest
@DBRider
@ExtendWith(SpringExtension.class)
class ConsoleRepositorySpringTest {

    @Autowired
    private ConsoleRepository consoleRepository;

    @Test
    @DataSet("console.yml")
    void shouldReturnConsoleByType() {
        Optional<Console> actual = consoleRepository.findByType(NES);

        assertThat(actual)
                .map(Console::getType)
                .hasValue(NES);
    }

    @Test
    @DataSet({"game.yml", "console.yml"})
    void shouldFillGameList() {
        Optional<Console> actual = consoleRepository.findByType(NES);

        assertThat(actual.get().getGames()).hasSizeGreaterThan(0);
    }
}