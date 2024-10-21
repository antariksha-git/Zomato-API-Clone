package org.ex.zomatocloneapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.ex.zomatocloneapi.config.GenerateCustomId;
import org.ex.zomatocloneapi.enums.DietTypes;

import java.awt.*;
import java.util.List;

@Entity
@Table(name = "restaurants")
@Getter
@Setter
public class Restaurant {

    @Id
    @GenerateCustomId
    @Column(name = "restaurant_id")
    private String restaurantId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "diet_types")
    @ElementCollection(fetch = FetchType.EAGER)
    private List<DietTypes> dietType;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Address address;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Image image;
}
