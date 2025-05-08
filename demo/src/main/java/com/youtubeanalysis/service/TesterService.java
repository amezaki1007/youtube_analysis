package com.youtubeanalysis.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.youtubeanalysis.domain.entity.TesterEntity;
import com.youtubeanalysis.domain.entity.VideoEntity;
import com.youtubeanalysis.repository.ITesterRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TesterService implements ITesterService {

    private final ITesterRepository testerRepository;

    public List<TesterEntity> getAll(){
        return testerRepository.findAll();
    }

    public List<VideoEntity> getTrend(){

        List<VideoEntity> ret = new ArrayList<VideoEntity>();
        return ret;
    }
}
