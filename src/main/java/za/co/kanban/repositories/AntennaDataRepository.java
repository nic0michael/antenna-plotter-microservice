package za.co.kanban.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.kanban.model.AntennaData;

public interface AntennaDataRepository extends JpaRepository<AntennaData, Long> {
	
}
