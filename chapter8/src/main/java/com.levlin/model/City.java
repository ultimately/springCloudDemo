package com.levlin.model;

import lombok.Data;

import javax.persistence.*;

@Data
public class City {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String state;
}