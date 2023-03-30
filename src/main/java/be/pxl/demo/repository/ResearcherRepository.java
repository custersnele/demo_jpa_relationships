package be.pxl.demo.repository;

import be.pxl.demo.domain.Researcher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResearcherRepository extends JpaRepository<Researcher, Long> {
}
