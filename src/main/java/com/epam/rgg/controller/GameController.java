package com.epam.rgg.controller;

import com.epam.rgg.dto.GameDto;
import com.epam.rgg.model.ConsoleType;
import com.epam.rgg.service.GameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/games")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/random/{consoleType}")
    public GameDto getRandomGame(@PathVariable ConsoleType consoleType) {
        return gameService.rollGame(consoleType);
    }
}
