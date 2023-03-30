package be.pxl.demo.service;

import be.pxl.demo.api.dto.FootballPlayerDTO;
import be.pxl.demo.api.dto.FootballPlayerRequest;
import be.pxl.demo.domain.football.FootballPlayer;
import be.pxl.demo.exception.ResourceNotFoundException;
import be.pxl.demo.repository.FootballPlayerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FootballPlayerService {

    private final FootballPlayerRepository footballPlayerRepository;

    public FootballPlayerService(FootballPlayerRepository footballPlayerRepository) {
        this.footballPlayerRepository = footballPlayerRepository;
    }

    public String createFootballPlayer(FootballPlayerRequest footballPlayerRequest) {
        FootballPlayer footballPlayer = new FootballPlayer();
        footballPlayer.setName(footballPlayerRequest.name());
        footballPlayer.setEmail(footballPlayerRequest.email());
        footballPlayer.setShirtNumber(footballPlayer.getShirtNumber());

        return footballPlayerRepository.save(footballPlayer).getUuid();
    }

    public List<FootballPlayerDTO> findFootballplayerByEmail(String partOfEmail) {
        return footballPlayerRepository.findFootballPlayerByEmailContainingIgnoreCase(partOfEmail)
                .stream()
                .map(fp -> new FootballPlayerDTO(fp.getUuid(), fp.getName(), fp.getEmail(), fp.getShirtNumber()))
                .toList();
    }

    @Transactional
    public void updateShirtNumber(String uuid, int shirtNumber) {
        FootballPlayer footballPlayer = footballPlayerRepository.findById(uuid).orElseThrow(() -> new ResourceNotFoundException("FootballPlayer", "uuid", uuid));
        footballPlayer.setShirtNumber(shirtNumber);
    }
}
