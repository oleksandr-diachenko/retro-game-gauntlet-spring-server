package com.epam.rgg.dao.entity;

import com.epam.rgg.model.ConsoleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "console")
public class Console {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "console_gen")
    @SequenceGenerator(name = "console_gen", sequenceName = "console_seq")
    private long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "name")
    private ConsoleType type;
}
