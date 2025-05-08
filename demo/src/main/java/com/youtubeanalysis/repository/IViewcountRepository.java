package com.youtubeanalysis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youtubeanalysis.domain.entity.ViewcountEntity;

@Repository
public interface IViewcountRepository extends JpaRepository<ViewcountEntity, Integer> {

}
