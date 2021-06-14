package com.epam.rgg.mapper;

import com.epam.rgg.dto.GameDto;
import com.epam.rgg.entity.Game;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GameMapper {

    GameMapper INSTANCE = Mappers.getMapper(GameMapper.class);

    @Mapping(source = "console.type", target = "consoleType")
    GameDto gameToGameDto(Game game);
}
