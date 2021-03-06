package com.epam.rgg.dao.repository;

import com.epam.rgg.dao.entity.Game;
import com.epam.rgg.model.ConsoleType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GameRepository extends CrudRepository<Game, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM game g JOIN console c on c.id = g.console_id " +
            "WHERE c.name = :#{#consoleType.name()} ORDER BY random() LIMIT 1")
    Optional<Game> findRandomGame(ConsoleType consoleType);
}
