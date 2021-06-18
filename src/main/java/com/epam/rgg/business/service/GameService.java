package com.epam.rgg.business.service;

import com.epam.rgg.business.dto.GameDto;
import com.epam.rgg.model.ConsoleType;

public interface GameService {

    GameDto rollGame(ConsoleType consoleType);
}
