package com.epam.rgg.service;

import com.epam.rgg.dto.GameDto;
import com.epam.rgg.entity.Game;
import com.epam.rgg.mapper.GameMapper;
import com.epam.rgg.model.ConsoleType;
import com.epam.rgg.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {


    private final GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public GameDto rollGame(ConsoleType consoleType) {
        Optional<Game> randomGame = gameRepository.findRandomGame(consoleType);
        if (randomGame.isPresent()) {
            return GameMapper.INSTANCE.gameToGameDto(randomGame.get());
        }
        throw new RecordNotFound("Game with console type " + consoleType + " not found");
    }
}
