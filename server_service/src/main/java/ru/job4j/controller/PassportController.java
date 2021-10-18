package ru.job4j.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.domain.Passport;
import ru.job4j.service.impl.PassportServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/passport")
public class PassportController {

    private final PassportServiceImpl passportServiceImpl;

    public PassportController(PassportServiceImpl passportServiceImpl) {
        this.passportServiceImpl = passportServiceImpl;
    }

    @GetMapping("/find")
    public ResponseEntity<List<Passport>> find(@RequestParam (required = false) Integer series) {
        return new ResponseEntity<>(
                series == null
                        ? this.passportServiceImpl.findAll()
                        : this.passportServiceImpl.findBySeries(series),
                HttpStatus.OK
        );
    }

    @GetMapping("/find-unavailable")
    public ResponseEntity<List<Passport>> findUnavailable() {
        return new ResponseEntity<>(
                this.passportServiceImpl.findUnavailable(),
                HttpStatus.OK
        );
    }

    @GetMapping("/find-replaceable")
    public ResponseEntity<List<Passport>> findReplaceable() {
        return new ResponseEntity<>(
                this.passportServiceImpl.findReplaceable(),
                HttpStatus.OK
        );
    }

    @PostMapping("/save")
    public ResponseEntity<Passport> create(@Valid @RequestBody Passport passport) {
        return new ResponseEntity<>(
                this.passportServiceImpl.save(passport),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/update")
    public ResponseEntity<Void> update(@RequestParam Integer id, @Valid @RequestBody Passport passport) {
        return this.passportServiceImpl.update(id, passport)
                ? ResponseEntity.ok().build()
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestParam Integer id) {
        return this.passportServiceImpl.delete(id)
                ? ResponseEntity.ok().build()
                : ResponseEntity.notFound().build();
    }
}