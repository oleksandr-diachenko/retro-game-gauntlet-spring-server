package com.epam.rgg.dao.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Game {

    private long id;
    private String name;
    private int year;
    private Console console;
}
