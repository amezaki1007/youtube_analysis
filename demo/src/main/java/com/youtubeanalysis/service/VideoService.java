package com.youtubeanalysis.service;

import org.springframework.stereotype.Service;

import com.youtubeanalysis.repository.IRecentVideoRepository;
import com.youtubeanalysis.repository.IVideoRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VideoService implements IVideoService {

  private final IVideoRepository videoRepository;

  private final IRecentVideoRepository recentVideoRepository;

  @Override
  public boolean putHide(String videoId, boolean value) throws EntityNotFoundException {
    int res1 = videoRepository.updateHideByVideoId(videoId, value);
    int res2 = recentVideoRepository.updateHideByVideoId(videoId, value);
    if (res1 + res2 == 0) {
      throw new EntityNotFoundException("videoIdが存在しません: " + videoId);
    } else {
      return true;
    }
  }
}
