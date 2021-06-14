package com.epam.rgg.service;

import com.epam.rgg.dto.GameDto;
import com.epam.rgg.entity.Game;
import com.epam.rgg.mapper.GameMapper;
import com.epam.rgg.model.ConsoleType;
import com.epam.rgg.repository.GameRepository;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {


    private final GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public GameDto rollGame(ConsoleType consoleType) {
        Game randomGame = gameRepository.findRandomGame(consoleType);
        return GameMapper.INSTANCE.gameToGameDto(randomGame);
    }
}
