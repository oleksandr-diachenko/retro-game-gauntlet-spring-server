package com.epam.rgg.business.dto;


import com.epam.rgg.model.ConsoleType;
import lombok.*;

@Builder
@Getter
@ToString
@EqualsAndHashCode
public class ConsoleDto {

    private final ConsoleType consoleType;
    @With
    private final int gameCount;
}
