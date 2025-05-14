package com.youtubeanalysis.domain.model;

import lombok.Data;

@Data
public class VideoTrendRequest {
  private String season;

  private Integer year;

  private String mode;

  private String order;

  private String channelId;

  private String videoType;

  private Integer pageSize;

  private Integer page;
}
