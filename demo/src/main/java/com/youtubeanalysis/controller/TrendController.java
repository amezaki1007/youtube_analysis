package com.youtubeanalysis.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.youtubeanalysis.domain.model.VideoDto;
import com.youtubeanalysis.service.ITrendService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/trend")
@RequiredArgsConstructor
public class TrendController {

  private final ITrendService trendService;

  @GetMapping
  public List<VideoDto> getTrendVideos(
    @RequestParam String mode, // シーズンごと取得の通常モード(normal)と直近動画取得モード(recent)
    @RequestParam String season, // mode=normalの場合、季節で指定 (spring, summer, fall, winter)
    @RequestParam int year,
    @RequestParam String order, // random / desc / asc by viewcount
    @RequestParam(required = false) String channelId, // 特定チャンネルの動画のみ取得したい場合
    @RequestParam String videoType, // オリジナル(original) / 歌ってみた(cover)
    @RequestParam(defaultValue = "20") int pageSize,
    @RequestParam(defaultValue = "1") int page
  ) {
    return null;
  }
}
