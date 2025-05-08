package com.youtubeanalysis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.youtubeanalysis.domain.entity.TesterEntity;
import com.youtubeanalysis.domain.entity.VideoEntity;
import com.youtubeanalysis.service.ITesterService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin(origins = {
    "http://localhost:3000",
    "https://localhost" // Android動作用
})
@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class TesterController {

    private final ITesterService testerService;

    @Value("${api.youtube.url}")
    private final String youtube_url;

    @Value("${api.youtube.key}")
    private final String youtube_api_key;

    @GetMapping
    public List<TesterEntity> getTestersAll() {
        return testerService.getAll();
    }

    @GetMapping("/trend")
    public List<VideoEntity> getTrend(@RequestParam String param) {
        return testerService.getTrend();
    }
}
