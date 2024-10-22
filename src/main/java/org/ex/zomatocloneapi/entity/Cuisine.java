package org.ex.zomatocloneapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cuisines")
@Getter
@Setter
public class Cuisine {
    @Id
    @Column(name = "cuisine_id")
    private long cuisineId;

    @Column(name = "title")
    private String title;
}
