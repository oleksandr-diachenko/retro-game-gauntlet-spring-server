package com.epam.rgg.business.mapper;

import com.epam.rgg.business.dto.GameDto;
import com.epam.rgg.dao.entity.Game;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GameMapper {

    GameMapper INSTANCE = Mappers.getMapper(GameMapper.class);

    @Mapping(source = "console.type", target = "consoleType")
    @Mapping(source = "year.year", target = "year")
    GameDto gameToGameDto(Game game);
}
