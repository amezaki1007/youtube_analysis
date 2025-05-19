package com.youtubeanalysis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.youtubeanalysis.domain.entity.VideoEntity;

import jakarta.transaction.Transactional;

@Repository
public interface IVideoRepository extends JpaRepository<VideoEntity, Integer> {
  @Modifying
  @Transactional
  @Query("UPDATE VideoEntity v SET v.hide = :hide WHERE v.videoId = :videoId")
  int updateHideByVideoId(String videoId, boolean hide);

  List<VideoEntity> findByHideFalse();
}
