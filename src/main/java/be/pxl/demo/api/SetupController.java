package be.pxl.demo.api;

import be.pxl.demo.api.dto.FootballPlayerRequest;
import be.pxl.demo.api.dto.ResearcherRequest;
import be.pxl.demo.service.FootballPlayerService;
import be.pxl.demo.service.ResearcherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/setup")
public class SetupController {
    private final ResearcherService researcherService;
    private final FootballPlayerService footballPlayerService;

    public SetupController(ResearcherService researcherService,
                           FootballPlayerService footballPlayerService) {
        this.researcherService = researcherService;
        this.footballPlayerService = footballPlayerService;
    }

    @GetMapping("/researchers")
    public void initData() {
        generatedData().forEach(data -> {
            String[] parts = data.split(",");
            researcherService.createResearcher(new ResearcherRequest(parts[0], parts[1], parts[2], parts[3], parts[4]));
        });
    }

    @GetMapping("/football")
    public void createFootballPlayer() {
        footballPlayerService.createFootballPlayer(new FootballPlayerRequest("Lionel Messi", "l.messi@psg.fr", 10));
        footballPlayerService.createFootballPlayer(new FootballPlayerRequest("Kylian Mbappé", "k.mbappe@psg.fr", 12));
        footballPlayerService.createFootballPlayer(new FootballPlayerRequest("Bryan Heynen", "heynen@krc-genk.be", 12));
    }

    private List<String> generatedData() {
        List<String> data = new ArrayList<>();
        data.add("Rebecka,Dulany,rdulany0@istockphoto.com,450-916-7808,https://www.linkedin.com/in/rdulany");
        data.add("Aurora,Sellar,asellar1@auda.org.au,646-492-7234,https://www.linkedin.com/in/asellar");
        data.add("Carlotta,Wycliffe,cwycliffe2@rakuten.co.jp,180-245-0554,https://www.linkedin.com/in/cwycliffe");
        data.add("Karel,Lippitt,klippitt4@twitpic.com,629-517-8080,https://www.linkedin.com/in/karel-lippitt");
        data.add("Florenza,Casier,fcasierb@usnews.com,169-887-8679,https://www.linkedin.com/in/flo");
        return data;
    }
}
