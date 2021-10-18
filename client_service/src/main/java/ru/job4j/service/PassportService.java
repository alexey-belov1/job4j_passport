package ru.job4j.service;

import ru.job4j.domain.Passport;

import java.util.List;

public interface PassportService {

    List<Passport> findAll();

    List<Passport> findBySeries(int series);

    List<Passport> findUnavailable();

    List<Passport> findReplaceable();

    Passport save(Passport passport);

    boolean update(int id, Passport passport);

    boolean delete(int id);
}
