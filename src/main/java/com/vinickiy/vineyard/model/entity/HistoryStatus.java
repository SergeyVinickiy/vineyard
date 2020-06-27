package com.vinickiy.vineyard.model.entity;

import lombok.*;
import javax.persistence.*;


@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "history_data")
public class HistoryStatus extends BaseEntity{

/*    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "canopy_id")*/
    private long canopyId;

    @Enumerated(EnumType.STRING)
    private CanopyStatus newStatus;

    private String comments;


}
