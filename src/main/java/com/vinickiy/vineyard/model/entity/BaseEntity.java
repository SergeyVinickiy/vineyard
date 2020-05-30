package com.vinickiy.vineyard.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TIME_CREATED", nullable = false, updatable = false)
    @CreatedDate
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDateTime timeCreated;

    @Column(name = "TIME_UPDATED", nullable = false)
    @LastModifiedDate
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDateTime timeUpdated;

}
