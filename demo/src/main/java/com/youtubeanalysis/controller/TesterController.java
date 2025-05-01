package com.youtubeanalysis.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.youtubeanalysis.domain.entity.TesterEntity;
import com.youtubeanalysis.service.ITesterService;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = {
    "http://localhost:3000",
    "https://localhost" // Android動作用
})
@RestController
@RequiredArgsConstructor
public class TesterController {

    private final ITesterService testerService;

    @GetMapping("/test")
    public List<TesterEntity> getTestersAll() {
        return testerService.getAll();
    }
}
