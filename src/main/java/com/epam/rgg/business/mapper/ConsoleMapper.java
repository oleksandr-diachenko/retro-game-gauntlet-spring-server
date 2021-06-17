package com.epam.rgg.business.mapper;

import com.epam.rgg.business.dto.ConsoleDto;
import com.epam.rgg.dao.entity.Console;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ConsoleMapper {

    ConsoleMapper INSTANCE = Mappers.getMapper(ConsoleMapper.class);

    @Mapping(source = "type", target = "consoleType")
    @Mapping(target = "gameCount", expression = "java(console.getGames().size())")
    ConsoleDto toConsoleDto(Console console);
}
