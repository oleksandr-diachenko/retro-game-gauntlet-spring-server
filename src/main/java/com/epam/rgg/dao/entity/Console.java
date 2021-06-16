package com.epam.rgg.dao.entity;

import com.epam.rgg.model.ConsoleType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

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
    public Console(ConsoleType type) {
        this.type = type;
    }
}
