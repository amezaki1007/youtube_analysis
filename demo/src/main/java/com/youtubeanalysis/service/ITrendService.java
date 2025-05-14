package com.youtubeanalysis.service;

import java.util.List;

import com.youtubeanalysis.domain.model.VideoTrendRequest;
import com.youtubeanalysis.domain.model.VideoTrendResponse;

public interface ITrendService {
  List<VideoTrendResponse> getTrend(VideoTrendRequest request);
}
