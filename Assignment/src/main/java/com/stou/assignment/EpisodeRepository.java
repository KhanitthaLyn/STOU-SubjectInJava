package com.stou.assignment;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface EpisodeRepository extends JpaRepository<Episode, String> {
    List<Episode> findByTitleContainingIgnoreCase(String keyword);
}
