package com.youtubeanalysis.domain.model;


import java.util.Map;

import lombok.Data;

@Data
public class VideoStatResponse {
  private String videoId;

  private Map<String, Long> viewcountMap;
}
