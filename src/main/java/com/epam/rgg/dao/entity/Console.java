package com.epam.rgg.dao.entity;

import com.epam.rgg.model.ConsoleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Console {

    private long id;
    private ConsoleType type;
}
