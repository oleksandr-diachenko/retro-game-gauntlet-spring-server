package com.epam.rgg.business.service;

import com.epam.rgg.business.dto.GameDto;
import com.epam.rgg.dao.entity.Game;
import com.epam.rgg.business.mapper.GameMapper;
import com.epam.rgg.model.ConsoleType;
import com.epam.rgg.dao.repository.GameRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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
        throw new EntityNotFoundException("Game with console type " + consoleType + " not found");
    }
}
