package com.epam.rgg.dao.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@NoArgsConstructor
@Getter
@Entity
@ToString
@Table(name = "year")
public class Year {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "year_gen")
    @SequenceGenerator(name = "year_gen", sequenceName = "year_seq")
    private Long id;
    private int years;

    public Year(int years) {
        this.years = years;
    }
}