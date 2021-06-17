package com.epam.rgg.business.service;

import com.epam.rgg.business.dto.ConsoleDto;
import com.epam.rgg.business.mapper.ConsoleMapper;
import com.epam.rgg.dao.entity.Console;
import com.epam.rgg.dao.repository.ConsoleRepository;
import com.epam.rgg.model.ConsoleType;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class ConsoleServiceImpl implements ConsoleService {

    private final ConsoleRepository consoleRepository;

    public ConsoleServiceImpl(ConsoleRepository consoleRepository) {
        this.consoleRepository = consoleRepository;
    }

    @Override
    public ConsoleDto findConsole(ConsoleType consoleType) {
        Optional<Console> console = consoleRepository.findByType(consoleType);
        if (console.isPresent()) {
            ConsoleDto consoleDto = ConsoleMapper.INSTANCE.toConsoleDto(console.get());
            return consoleDto.withGameCount(console.get().getGames().size());
        }
        throw new EntityNotFoundException("Console with name " + consoleType + " not found");
    }
}
