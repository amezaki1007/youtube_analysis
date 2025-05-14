package com.youtubeanalysis.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.youtubeanalysis.domain.model.VideoStatResponse;
import com.youtubeanalysis.domain.model.VideoTrendRequest;

@Service
public interface IStatService {
  public List<VideoStatResponse> getTrend(VideoTrendRequest request);
}
