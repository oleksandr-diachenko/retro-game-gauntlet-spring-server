package com.epam.rgg.repository;

import com.epam.rgg.entity.Game;
import com.epam.rgg.model.ConsoleType;

public interface GameRepository {

    Game findRandomGame(ConsoleType consoleType);
}
