package com.youtubeanalysis.domain.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class VideoTrendResponse {
  private int id;

  private String videoTitle;

  private String videoId;

  private String thumbnail;

  private Long viewcount;

  private String videoType;

  private LocalDateTime publishedAt;
}
