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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bundleId;

    @ManyToOne
    @JoinColumn(name = "canopy_id")
    private Canopy canopyId;

    @Column(name = "canopy_number")
    private Integer canopySerialNumber;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Row row;



}
