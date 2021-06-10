package com.epam.rgg.dto;

import com.epam.rgg.model.ConsoleType;

public record GameDto(String name, ConsoleType consoleType, int year) {
}
