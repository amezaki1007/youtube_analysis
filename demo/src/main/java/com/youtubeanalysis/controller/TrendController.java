package com.youtubeanalysis.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.youtubeanalysis.domain.model.VideoTrendRequest;
import com.youtubeanalysis.domain.model.VideoTrendResponse;
import com.youtubeanalysis.service.ITrendService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/trend")
@RequiredArgsConstructor
@CrossOrigin(origins = {
  "http://localhost:3000",
  "https://localhost" // Android動作用
})
public class TrendController {

  private final ITrendService trendService;

  @GetMapping
  public List<VideoTrendResponse> getTrendVideos(VideoTrendRequest request) {
    return trendService.getTrend(request);
  }
}
