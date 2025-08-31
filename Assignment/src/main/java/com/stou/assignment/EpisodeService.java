package com.stou.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EpisodeService {

    @Autowired
    private EpisodeRepository episodeRepository;

    public Episode addEpisode(Episode episode) {
        return episodeRepository.save(episode);
    }

    public List<Episode> getAllEpisodes() {
        return episodeRepository.findAll();
    }

    public Optional<Episode> getEpisodeByTitle(String title) {
        return episodeRepository.findById(title);
    }

    public void deleteEpisode(String title) {
        episodeRepository.deleteById(title);
    }
    public List<Episode> searchByTitle(String keyword) {
        return episodeRepository.findByTitleContainingIgnoreCase(keyword);
    }
}
