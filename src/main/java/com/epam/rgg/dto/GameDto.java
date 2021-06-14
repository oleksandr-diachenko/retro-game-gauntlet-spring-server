package com.epam.rgg.dto;

import com.epam.rgg.model.ConsoleType;
import lombok.*;

@Builder
@Getter
@ToString
@EqualsAndHashCode
public class GameDto {

    private final String name;
    private final ConsoleType consoleType;
    private final int year;
}
