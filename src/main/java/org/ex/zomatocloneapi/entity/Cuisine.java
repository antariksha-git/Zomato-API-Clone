package org.ex.zomatocloneapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cuisines")
@Getter
@Setter
public class Cuisine {
    @Id
    @Column(name = "cuisine_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cuisineId;

    @Column(name = "title")
    private String title;
}
