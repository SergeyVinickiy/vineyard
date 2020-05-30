package com.vinickiy.vineyard.model.entity;


import lombok.*;
import javax.persistence.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "canopies")
public class Canopy extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private CanopyStatus status;

    @OneToOne
    @JoinColumn(name = "bundle_id")
    private Bundle bundle_id;

    private String comments;

    // Picture
}
