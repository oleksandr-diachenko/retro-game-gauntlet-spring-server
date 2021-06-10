package com.epam.rgg.controller;

import com.epam.rgg.dto.GameDto;
import com.epam.rgg.model.ConsoleType;
import com.epam.rgg.service.GameService;

public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    public GameDto getRandomGame(ConsoleType consoleType) {
        return gameService.rollGame(consoleType);
    }
}
