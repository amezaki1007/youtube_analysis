package com.youtubeanalysis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youtubeanalysis.domain.entity.VideoEntity;

@Repository
public interface IVideoRepository extends JpaRepository<VideoEntity, Integer> {

}
