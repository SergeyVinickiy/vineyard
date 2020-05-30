package com.vinickiy.vineyard.model.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.time.LocalDateTime;


@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "history_data")
public class HistoryStatus{

    @ManyToOne
    @JoinColumn(name = "canopy_id")
    private Canopy canopyId;

    @Enumerated(EnumType.STRING)
    private CanopyStatus status;

    private String comments;

    @Column(name = "TIME_CREATED", nullable = false, updatable = false)
    @CreatedDate
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDateTime timeCreated;

}
