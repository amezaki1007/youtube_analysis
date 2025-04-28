package com.youtubeanalysis.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youtubeanalysis.domain.entity.TesterEntity;

@Repository
public interface ITesterRepository extends JpaRepository<TesterEntity, Integer> {
}
