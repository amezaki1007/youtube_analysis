package com.youtubeanalysis.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.youtubeanalysis.domain.entity.TesterEntity;

@Service
public interface ITesterService {
    public List<TesterEntity> getAll();
}