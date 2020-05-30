package com.vinickiy.vineyard.model.entity;

import lombok.*;

import javax.persistence.*;


@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vine_types")
public class VineType extends BaseEntity{

    @Id
    @Column(name = "vine_type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vine_type;

}
