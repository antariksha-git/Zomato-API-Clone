package org.ex.zomatocloneapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

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

    @ManyToMany(mappedBy = "cuisines")
    Set<Restaurant> restaurants;
}
