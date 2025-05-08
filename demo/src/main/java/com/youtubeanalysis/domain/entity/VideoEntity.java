package com.youtubeanalysis.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "videos", uniqueConstraints = {
    @UniqueConstraint(name = "unique_title", columnNames = {"title"})
})
@Data
public class VideoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "video_id", nullable = false, length = 20)
    private String videoId;

    @Column(name = "title", columnDefinition = "text")
    private String title;

    @Column(name = "category_id", length = 10)
    private String categoryId;

    @Column(name = "channel_id", length = 50)
    private String channelId;

    @Column(name = "channel_title", length = 255)
    private String channelTitle;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @Column(name = "published_at")
    private LocalDateTime publishedAt;

    @Column(name = "tags", columnDefinition = "text")
    private String tags;

    @Column(name = "thumbnail_url", columnDefinition = "text")
    private String thumbnailUrl;

    @Column(name = "video_type", length = 50)
    private String videoType;

    @Column(name = "status", length = 10)
    private String status;
}
