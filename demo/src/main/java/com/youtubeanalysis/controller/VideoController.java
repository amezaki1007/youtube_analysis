package com.youtubeanalysis.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.youtubeanalysis.service.IVideoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/video")
@RequiredArgsConstructor
@CrossOrigin(origins = {
  "http://localhost:3000",
  "https://localhost" // Android動作用
})
public class VideoController {

  private final IVideoService videoService;

  @PutMapping("/hide")
  public boolean putHide(
    @RequestParam String videoId,
    @RequestParam boolean value) {
    return videoService.putHide(videoId, value);
  }
}
