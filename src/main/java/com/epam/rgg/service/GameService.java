package com.epam.rgg.service;

import com.epam.rgg.dto.GameDto;
import com.epam.rgg.model.ConsoleType;

public interface GameService {

    GameDto rollGame(ConsoleType consoleType);
}
