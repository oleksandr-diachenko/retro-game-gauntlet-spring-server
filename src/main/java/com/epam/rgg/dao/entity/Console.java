package com.epam.rgg.dao.entity;

import com.epam.rgg.model.ConsoleType;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.SEQUENCE;

@NoArgsConstructor
@Getter
@Entity
@ToString
@Table(name = "console")
public class Console {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "console_gen")
    @SequenceGenerator(name = "console_gen", sequenceName = "console_seq")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "name")
    private ConsoleType type;
    @OneToMany(mappedBy = "console", fetch = LAZY)
    @ToString.Exclude
    private final List<Game> games = new ArrayList<>();

    public Console(ConsoleType type) {
        this.type = type;
    }

    public void addGame(Game game) {
        games.add(game);
    }
}
