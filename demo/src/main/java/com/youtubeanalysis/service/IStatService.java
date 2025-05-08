package com.youtubeanalysis.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.youtubeanalysis.domain.model.VideoDto;

@Service
public interface IStatService {
  public List<VideoDto> getTrend();
}
