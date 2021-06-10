package com.epam.rgg.service;

import com.epam.rgg.dto.ConsoleDto;
import com.epam.rgg.model.ConsoleType;

public interface ConsoleService {

    ConsoleDto findConsole(ConsoleType consoleType);
}
