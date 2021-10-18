package ru.job4j.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.domain.Passport;

import java.time.Instant;
import java.util.List;

@Repository
public interface PassportRepository extends CrudRepository<Passport, Integer> {

    List<Passport> findAll();

    List<Passport> findBySeries(int series);

    List<Passport> findByExpiryDateBefore(Instant date);

    List<Passport> findByExpiryDateBetween(Instant start, Instant end);
}