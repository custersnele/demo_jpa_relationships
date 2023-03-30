package be.pxl.demo.repository;

import be.pxl.demo.domain.football.FootballPlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FootballPlayerRepository extends JpaRepository<FootballPlayer, String> {

    List<FootballPlayer> findFootballPlayerByEmailContainingIgnoreCase(String email);
}
