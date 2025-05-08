package com.youtubeanalysis.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "viewcounts", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"video_id", "log_date"})
})
@Data
public class ViewcountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "video_id", nullable = false, length = 20)
    private String videoId;

    @Column(name = "view_count", nullable = false)
    private Integer viewCount;

    @Column(name = "log_date", nullable = false)
    private LocalDate logDate;
}
