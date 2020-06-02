package com.vinickiy.vineyard.model.entity;

import lombok.*;
import javax.persistence.*;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rows")
public class Row extends BaseEntity{

    private Integer row_number;

/*    @ManyToOne(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "vine_type_id")*/
//Need to add validation on the field
    private String vineType;


}
