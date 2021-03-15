package com.vinickiy.vineyard.model.entity;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "canopies")
public class Canopy extends BaseEntity {

    private int rowNumber;
    @Enumerated(EnumType.STRING)
    private CanopyStatus status;
    private String comments;

    @Lob
    @Column(name = "Image")
    private byte[] image;



}
