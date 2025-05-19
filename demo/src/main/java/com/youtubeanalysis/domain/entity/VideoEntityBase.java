package com.youtubeanalysis.domain.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
@Data
public abstract class VideoEntityBase {
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

  @Column(name = "hide", nullable = false)
  private boolean hide = false; // デフォルトは非表示でない（false）
}
