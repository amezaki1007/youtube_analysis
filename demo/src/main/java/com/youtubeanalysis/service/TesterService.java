package com.youtubeanalysis.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.youtubeanalysis.domain.entity.TesterEntity;
import com.youtubeanalysis.repository.ITesterRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TesterService implements ITesterService {

    private final ITesterRepository testerRepository;

    public List<TesterEntity> getAll(){
        return testerRepository.findAll();
    }
}
