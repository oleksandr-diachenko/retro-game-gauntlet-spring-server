package com.epam.rgg.business.service;

import com.epam.rgg.business.dto.ConsoleDto;
import com.epam.rgg.business.mapper.ConsoleMapper;
import com.epam.rgg.dao.entity.Console;
import com.epam.rgg.dao.entity.Game;
import com.epam.rgg.dao.repository.ConsoleRepository;
import com.epam.rgg.dao.repository.GameRepository;
import com.epam.rgg.model.ConsoleType;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ConsoleServiceImpl implements ConsoleService {

    private final ConsoleRepository consoleRepository;
    private final GameRepository gameRepository;

    public ConsoleServiceImpl(ConsoleRepository consoleRepository, GameRepository gameRepository) {
        this.consoleRepository = consoleRepository;
        this.gameRepository = gameRepository;
    }

    @Override
    public ConsoleDto findConsole(ConsoleType consoleType) {
        Optional<Console> console = consoleRepository.findByType(consoleType);
        if(console.isPresent()) {
            List<Game> games = gameRepository.findGamesByConsole(console.get());
            ConsoleDto consoleDto = ConsoleMapper.INSTANCE.toConsoleDto(console.get());
            return consoleDto.withGameCount(games.size());
        }
        throw new EntityNotFoundException("Console with name " + consoleType + " not found");
    }
}
