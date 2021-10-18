package ru.job4j.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Entity
@Table(name = "passport")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @NotNull
    @Column(name = "series")
    private Integer series;

    @NotNull
    @Column(name = "number")
    private Integer number;

    @NotNull
    @Column(name = "expiry_date")
    private Instant expiryDate;

    @NotBlank
    @Column(name = "authority")
    private String authority;
}
