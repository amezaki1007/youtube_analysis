package com.youtubeanalysis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youtubeanalysis.domain.entity.RecentVideoEntity;

@Repository
public interface IRecentVideoRepository extends JpaRepository<RecentVideoEntity, Integer> {

}
