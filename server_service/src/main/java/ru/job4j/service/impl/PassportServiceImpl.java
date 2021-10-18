package ru.job4j.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.job4j.domain.Passport;
import ru.job4j.repository.PassportRepository;
import ru.job4j.service.PassportService;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class PassportServiceImpl implements PassportService {

    private final PassportRepository passportRepository;

    public PassportServiceImpl(PassportRepository passportRepository) {
        this.passportRepository = passportRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Passport> findAll() {
        return this.passportRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Passport> findBySeries(int series) {
        return this.passportRepository.findBySeries(series);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Passport> findUnavailable() {
        return this.passportRepository.findByExpiryDateBefore(Instant.now());
    }

    @Override
    @Transactional(readOnly = true)
    public List<Passport> findReplaceable() {
        Instant now = Instant.now();
        return this.passportRepository.findByExpiryDateBetween(now.minus(90, ChronoUnit.DAYS), now);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public Passport save(Passport passport) {
        return this.passportRepository.save(passport);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public boolean update(int id, Passport passport) {
        Optional<Passport> optionalPassport = this.passportRepository.findById(id);
        if (optionalPassport.isPresent()) {
            passport.setId(id);
            this.passportRepository.save(passport);
            return true;
        }
        return false;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public boolean delete(int id) {
        Optional<Passport> optionalPassport = this.passportRepository.findById(id);
        if (optionalPassport.isPresent()) {
            passportRepository.delete(optionalPassport.get());
            return true;
        }
        return false;
    }
}
