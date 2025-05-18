package com.youtubeanalysis.domain.model;

import lombok.Data;

@Data
public class VideoTrendRequest {
  private Integer year;

  private String mode;

  private String season; // mode = normal の場合

  private Integer range; // mode = recent の場合

  private String order;

  private String channelId;

  private String videoType;

  private Integer pageSize;

  private Integer page;
}
