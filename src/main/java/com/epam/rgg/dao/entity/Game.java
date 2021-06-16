package com.epam.rgg.dao.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.SEQUENCE;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "game_gen")
    @SequenceGenerator(name = "game_gen", sequenceName = "game_seq")
    private long id;
    private String name;
    private int year;
    @ManyToOne(fetch = LAZY, cascade = ALL)
    private Console console;
}
