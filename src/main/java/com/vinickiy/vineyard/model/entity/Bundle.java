package com.vinickiy.vineyard.model.entity;

import lombok.*;

import javax.persistence.*;

@Deprecated
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bundles")
public class Bundle extends BaseEntity{

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Row row;


    @ManyToOne
    @JoinColumn(name = "canopy_id")
    private Canopy canopy;


    @Column(name = "canopy_number")
    private Integer canopySerialNumber;

}
