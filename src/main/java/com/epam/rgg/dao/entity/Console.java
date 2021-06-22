package com.epam.rgg.dao.entity;

import com.epam.rgg.model.ConsoleType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
public class Console extends Auditable {

    @OneToMany(mappedBy = "console", fetch = LAZY)
    @ToString.Exclude
    private final List<Game> games = new ArrayList<>();
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "console_gen")
    @SequenceGenerator(name = "console_gen", sequenceName = "console_seq")
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "name")
    @Setter
    private ConsoleType type;

    public Console(ConsoleType type) {
        this.type = type;
    }

    public void addGame(Game game) {
        games.add(game);
    }
}
