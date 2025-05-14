package com.youtubeanalysis.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "videos", uniqueConstraints = {
    @UniqueConstraint(name = "unique_title", columnNames = {"title"})
})
public class VideoEntity extends VideoEntityBase {}
