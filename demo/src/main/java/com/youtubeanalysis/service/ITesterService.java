package com.youtubeanalysis.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.youtubeanalysis.domain.entity.TesterEntity;
import com.youtubeanalysis.domain.entity.VideoEntity;

@Service
public interface ITesterService {
    public List<TesterEntity> getAll();

    public List<VideoEntity> getTrend();
}