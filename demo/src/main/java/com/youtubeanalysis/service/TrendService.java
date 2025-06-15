package com.youtubeanalysis.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.youtubeanalysis.domain.entity.VideoEntityBase;
import com.youtubeanalysis.domain.entity.ViewcountEntity;
import com.youtubeanalysis.domain.model.VideoTrendDto;
import com.youtubeanalysis.domain.model.VideoTrendRequest;
import com.youtubeanalysis.domain.model.VideoTrendResponse;
import com.youtubeanalysis.repository.IRecentVideoRepository;
import com.youtubeanalysis.repository.IVideoRepository;
import com.youtubeanalysis.repository.IViewcountRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TrendService implements ITrendService {
  private final IVideoRepository videoRepository;

  private final IRecentVideoRepository recentVideoRepository;

  private final IViewcountRepository viewcountRepository;

  @Override
  public List<VideoTrendResponse> getTrend(VideoTrendRequest request) {
    List<VideoEntityBase> allVideoEntities = new ArrayList<>();
    LocalDateTime from, to;
    if (request.getMode().equals("recent")) {
      allVideoEntities.addAll(recentVideoRepository.findByHideFalse());
      from = LocalDateTime.now().minusDays(Math.min(request.getRange(), 180L));
      to = LocalDateTime.now();
    } else {
      allVideoEntities.addAll(videoRepository.findByHideFalse());
      if(request.getSeason().equals("spring")){
        from = LocalDateTime.of(request.getYear(), 3, 1, 0, 0, 0);
        to = LocalDateTime.of(request.getYear(), 5, 31, 23, 59, 59);
      } else if(request.getSeason().equals("summer")){
        from = LocalDateTime.of(request.getYear(), 6, 1, 0, 0, 0);
        to = LocalDateTime.of(request.getYear(), 8, 31, 23, 59, 59);
      } else if(request.getSeason().equals("fall")){
        from = LocalDateTime.of(request.getYear(), 9, 1, 0, 0, 0);
        to = LocalDateTime.of(request.getYear(), 11, 30, 23, 59, 59);
      } else{
        from = LocalDateTime.of(request.getYear(), 12, 1, 0, 0, 0);
        to = LocalDateTime.of(request.getYear() + 1, 3, 1, 0, 0, 0);
      }
    }
    List<ViewcountEntity> allViewcountEntities = viewcountRepository.findLatestByEachVideoIdWithWindow();

    List<VideoEntityBase> videoEntities = allVideoEntities.stream()
      .filter(video -> {
        LocalDateTime published = video.getPublishedAt();
        return !published.isBefore(from) && !published.isAfter(to);
      })
      .sorted(Comparator.comparing(VideoEntityBase::getVideoId))
      .collect(Collectors.toList());

    Set<String> videoIdSet = videoEntities.stream().map(VideoEntityBase::getVideoId).collect(Collectors.toSet());

    List<ViewcountEntity> viewcountEntities =  allViewcountEntities.stream()
      .filter(vc -> videoIdSet.contains(vc.getVideoId()))
      .sorted(Comparator.comparing(ViewcountEntity::getVideoId))
      .toList();
    List<VideoTrendDto> dtos = new ArrayList<>();
    for(int i = 0; i < videoEntities.size(); i++) {
      try {
        if(!videoEntities.get(i).getVideoId().equals(viewcountEntities.get(i).getVideoId())) {
          throw new AssertionError("VideoIdの不一致: " + videoEntities.get(i).getVideoId() + " vs. " + viewcountEntities.get(i).getVideoId());
        }
        dtos.add(convertToDto(videoEntities.get(i), List.of(viewcountEntities.get(i))));
      } catch (Exception e) {
        System.out.println("warn: cannot get viewcount entity: videoId = " + videoEntities.get(i).getVideoId());
      }
    }
    if(request.getChannelId() != null) {
      dtos = dtos.stream().filter(video -> request.getChannelId().equals(video.getChannelId())).collect(Collectors.toList());
    }
    dtos = dtos.stream().filter(video -> request.getVideoType().equals(video.getVideoType())).collect(Collectors.toList());
    // TODO: statType*orderによる並び替え（暫定的に無条件で再生数並び替え）
    dtos = dtos.stream().sorted((v1, v2) -> compareDto(v2, v1)).collect(Collectors.toList());

    int page = request.getPage();
    int pageSize = request.getPageSize();
    int start = pageSize * (page - 1);
    int end = Math.min(start + pageSize, dtos.size());

    if (dtos.isEmpty() || start >= dtos.size()) {
      return Collections.emptyList();
    } else{
      return dtos.subList(start, end).stream().map(this::convertToResponse).collect(Collectors.toList());
    }
  }

  private int compareDto(VideoTrendDto v1, VideoTrendDto v2) {
    // v1の視聴数 < v2の視聴数の場合に正の値が返るはず
    return Long.compare(v1.getViewcountList().getFirst().getViewCount(), v2.getViewcountList().getFirst().getViewCount());
  }

  private VideoTrendDto convertToDto(VideoEntityBase baseVideo, List<ViewcountEntity> baseViewcountList) {
    VideoTrendDto response = new VideoTrendDto();
    response.setId(baseVideo.getId());
    response.setVideoTitle(baseVideo.getTitle());
    response.setVideoId(baseVideo.getVideoId());
    response.setThumbnail(baseVideo.getThumbnailUrl());
    response.setPublishedAt(baseVideo.getPublishedAt());
    response.setVideoType(baseVideo.getVideoType());
    response.setViewcountList(baseViewcountList);
    return response;
  }

  private VideoTrendResponse convertToResponse(VideoTrendDto dto) {
    VideoTrendResponse response = new VideoTrendResponse();
    response.setId(dto.getId());
    response.setVideoTitle(dto.getVideoTitle());
    response.setVideoId(dto.getVideoId());
    response.setThumbnail(dto.getThumbnail());
    response.setPublishedAt(dto.getPublishedAt());
    response.setVideoType(dto.getVideoType());
    response.setViewcount(dto.getViewcountList().getFirst().getViewCount());
    return response;
  }
}
