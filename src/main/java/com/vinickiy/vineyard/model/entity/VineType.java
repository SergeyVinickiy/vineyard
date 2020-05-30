package com.vinickiy.vineyard.model.entity;

import lombok.*;
import javax.persistence.Entity;
import javax.persistence.Table;


@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vine_types")
public class VineType extends BaseEntity{

    private String vine_type;

}
