package com.stou.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    private EpisodeService episodeService;

    @GetMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("episodes", episodeService.getAllEpisodes());
        return "index";
    }

    @GetMapping("/getepisodeform")
    public String getEpisodeForm(Model model) {
        model.addAttribute("formepisode", new Episode());
        return "episodeform";
    }

    @PostMapping("/addseason")
    public String addSeason(@ModelAttribute("formepisode") Episode newEpisode) {
        episodeService.addEpisode(newEpisode);
        return "redirect:/";
    }

    @GetMapping("/editepisode/{title}")
    public String editEpisode(@PathVariable String title, Model model) {
        Optional<Episode> episodeOpt = episodeService.getEpisodeByTitle(title);
        if (episodeOpt.isPresent()) {
            model.addAttribute("formepisode", episodeOpt.get());
            return "episodeform";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/updateepisode")
    public String updateEpisode(@ModelAttribute("formepisode") Episode updatedEpisode) {
        episodeService.addEpisode(updatedEpisode);
        return "redirect:/";
    }

    @GetMapping("/deleteepisode/{title}")
    public String deleteEpisode(@PathVariable String title) {
        episodeService.deleteEpisode(title);
        return "redirect:/";
    }
        @GetMapping("/search")
        public String searchEpisodes(@RequestParam("keyword") String keyword, Model model) {
            List<Episode> results = episodeService.searchByTitle(keyword);
            model.addAttribute("episodes", results);
            return "index";
    }
}
