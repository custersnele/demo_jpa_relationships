package be.pxl.demo.api;

import be.pxl.demo.api.dto.FootballPlayerDTO;
import be.pxl.demo.api.dto.PostCommentDTO;
import be.pxl.demo.api.dto.PostDTO;
import be.pxl.demo.service.FootballPlayerService;
import be.pxl.demo.service.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("football")
public class FootballPlayerController {

    private final FootballPlayerService footballPlayerService;

    public FootballPlayerController(FootballPlayerService footballPlayerService) {
        this.footballPlayerService = footballPlayerService;
    }

    @GetMapping("players/{byEmail}")
    public List<FootballPlayerDTO> findFootballPlayersByEmail(@PathVariable String byEmail) {
        return footballPlayerService.findFootballplayerByEmail(byEmail);
    }
}
