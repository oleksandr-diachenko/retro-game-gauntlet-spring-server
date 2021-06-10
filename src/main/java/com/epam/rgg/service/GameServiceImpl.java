package com.epam.rgg.service;

import com.epam.rgg.dto.GameDto;
import com.epam.rgg.model.ConsoleType;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {

    @Override
    public GameDto rollGame(ConsoleType consoleType) {
        return new GameDto("Super Mario Bros", consoleType, 1985); //TODO mock for UI
    }
}
