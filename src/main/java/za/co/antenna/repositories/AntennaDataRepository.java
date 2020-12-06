package za.co.antenna.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.antenna.model.AntennaData;

public interface AntennaDataRepository extends JpaRepository<AntennaData, Long> {
	
}
