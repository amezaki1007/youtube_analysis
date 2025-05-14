package com.youtubeanalysis.domain.model;

import java.time.LocalDateTime;
import java.util.List;

import com.youtubeanalysis.domain.entity.ViewcountEntity;

import lombok.Data;

@Data
public class VideoTrendDto {
  private int id;

  private String videoTitle;

  private String viedoId;

  private String thumbnail;

  private String channelId;

  private List<ViewcountEntity> viewcountList;

  private String videoType;

  private LocalDateTime publishedAt;
}
