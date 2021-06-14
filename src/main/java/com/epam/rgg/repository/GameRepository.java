package com.epam.rgg.repository;

import com.epam.rgg.entity.Game;
import com.epam.rgg.model.ConsoleType;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GameRepository {

    Optional<Game> findRandomGame(ConsoleType consoleType);
}
