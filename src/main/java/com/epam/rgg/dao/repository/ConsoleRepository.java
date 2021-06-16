package com.epam.rgg.dao.repository;

import com.epam.rgg.dao.entity.Console;
import com.epam.rgg.dao.entity.Game;
import com.epam.rgg.model.ConsoleType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConsoleRepository extends CrudRepository<Console, Long> {

    Optional<Console> findByType(ConsoleType type);
}
