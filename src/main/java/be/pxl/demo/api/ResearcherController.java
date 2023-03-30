package be.pxl.demo.api;

import be.pxl.demo.api.dto.ContactType;
import be.pxl.demo.domain.Researcher;
import be.pxl.demo.service.ResearcherService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/researchers")
public class ResearcherController {

    private final ResearcherService researcherService;

    public ResearcherController(ResearcherService researcherService) {
        this.researcherService = researcherService;
    }

    @PutMapping(path = "{researcherId}/{field}/{value}")
    public void updateContactInformation(@PathVariable long researcherId, @PathVariable ContactType field, @PathVariable String value) {
        researcherService.updateContactInformation(researcherId, field, value);
    }

    @DeleteMapping(path="{researcherId}")
    public void deleteResearcher(@PathVariable long researcherId) {
        researcherService.deleteResearcher(researcherId);
    }


}
