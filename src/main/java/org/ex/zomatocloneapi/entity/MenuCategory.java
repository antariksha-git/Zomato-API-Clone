package org.ex.zomatocloneapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "menu_categories")
@Getter
@Setter
public class MenuCategory {
    @Id
    @Column(name = "cateogry_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long categoryId;

    @Column(name = "title")
    private String title;
}
