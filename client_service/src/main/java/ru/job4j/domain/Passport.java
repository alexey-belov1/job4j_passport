package ru.job4j.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.Instant;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Passport {

    @EqualsAndHashCode.Include
    private Integer id;

    private Integer series;

    private Integer number;

    private Instant expiryDate;

    private String authority;
}
