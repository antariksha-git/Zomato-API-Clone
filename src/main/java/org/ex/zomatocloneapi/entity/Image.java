package org.ex.zomatocloneapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "images")
@Setter
@Getter
public class Image {
    @Id
    @Column(name = "image_id")
    private int imageId;

    @Column(name = "url")
    private String url;
}
