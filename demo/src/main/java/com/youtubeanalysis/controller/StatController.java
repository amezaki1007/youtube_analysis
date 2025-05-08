package com.youtubeanalysis.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.youtubeanalysis.domain.model.VideoStatDto;
import com.youtubeanalysis.service.IStatService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/stat")
@RequiredArgsConstructor
public class StatController {

  private final IStatService statService;

  @PostMapping
  public List<VideoStatDto> getVideosWithStat(
    @RequestParam int durartion,
    @RequestBody List<String> videoIds
  ) {
    return null;
  }

}
