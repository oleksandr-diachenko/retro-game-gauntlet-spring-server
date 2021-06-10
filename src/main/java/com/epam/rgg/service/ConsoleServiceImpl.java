package com.epam.rgg.service;

import com.epam.rgg.dto.ConsoleDto;
import com.epam.rgg.model.ConsoleType;
import org.springframework.stereotype.Service;

@Service
public class ConsoleServiceImpl implements ConsoleService {

    @Override
    public ConsoleDto findConsole(ConsoleType consoleType) {
        throw new UnsupportedOperationException("Not implemented!"); //auto-generated
    }
}
