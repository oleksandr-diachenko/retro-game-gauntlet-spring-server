package com.epam.rgg.repository;

import com.epam.rgg.entity.Game;
import com.epam.rgg.model.ConsoleType;

import java.util.Optional;

public interface GameRepository {

    Optional<Game> findRandomGame(ConsoleType consoleType);
}
