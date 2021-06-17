package com.epam.rgg.dao.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.SEQUENCE;

@NoArgsConstructor
@Getter
@Entity
@ToString
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "game_gen")
    @SequenceGenerator(name = "game_gen", sequenceName = "game_seq")
    private Long id;
    private String name;
    private int year;
    @ManyToOne
    @JoinColumn(name="console_id")
    private Console console;

    public Game(String name, int year, Console console) {
        this.name = name;
        this.year = year;
        this.console = console;
    }
}
