package com.youtubeanalysis.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ChannelController {
    @GetMapping("/channel")
    public String getMethodName(@RequestParam(required = false) String param) {
        return new String("hogehoge");
    }
    
}
