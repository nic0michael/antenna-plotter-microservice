package za.co.kanban.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.kanban.model.AntennaGainData;

public interface AntennaGainDataRepository extends JpaRepository<AntennaGainData, Long> {
	
}
