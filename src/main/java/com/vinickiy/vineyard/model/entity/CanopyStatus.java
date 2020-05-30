package com.vinickiy.vineyard.model.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "canopy_status")
public enum CanopyStatus {

    GOOD, BAD, MEDIUM

}
