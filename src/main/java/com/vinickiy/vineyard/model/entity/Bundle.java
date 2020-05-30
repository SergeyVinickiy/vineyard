package com.vinickiy.vineyard.model.entity;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bundles")
public class Bundle extends BaseEntity{

    @Column(name = "bundle_id")
    @OneToOne
    @JoinColumn(name = "canopy_id")
    private Canopy canopyId;

    @Column(name = "canopy_number")
    private Integer canopySerialNumber;

}
