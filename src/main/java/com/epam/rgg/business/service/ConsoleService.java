package com.epam.rgg.business.service;

import com.epam.rgg.business.dto.ConsoleDto;
import com.epam.rgg.model.ConsoleType;

public interface ConsoleService {

    ConsoleDto findConsole(ConsoleType consoleType);
}
