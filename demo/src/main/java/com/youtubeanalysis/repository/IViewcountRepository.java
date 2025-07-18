package com.youtubeanalysis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.youtubeanalysis.domain.entity.ViewcountEntity;

@Repository
public interface IViewcountRepository extends JpaRepository<ViewcountEntity, Integer> {
   // 1つの videoId に一致するすべてのエンティティを取得（複数件）
   List<ViewcountEntity> findByVideoId(String videoId);

   // 複数の videoId に一致するすべてのエンティティを取得
   List<ViewcountEntity> findByVideoIdIn(List<String> videoIds);

   @Query(value = "SELECT id, video_id, view_count, log_date FROM (" +
                   "    SELECT *, " +
                   "           ROW_NUMBER() OVER (PARTITION BY video_id ORDER BY log_date DESC) as rn " +
                   "    FROM viewcounts" +
                   ") ranked " +
                   "WHERE rn = 1",
           nativeQuery = true)
   List<ViewcountEntity> findLatestByEachVideoIdWithWindow();
}
