package com.vinickiy.vineyard.model.entity;

import lombok.*;
import javax.persistence.*;


@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rows")
public class Row extends BaseEntity{


    private Integer row_number;

    @ManyToOne
    @JoinColumn(name = "vine_type_id")
    private VineType vineType;

    @OneToOne
    @JoinColumn(name = "bundle_id")
    private Bundle bundle;

}
