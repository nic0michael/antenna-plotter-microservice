package za.co.antenna.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.antenna.model.AntennaGainData;

public interface AntennaGainDataRepository extends JpaRepository<AntennaGainData, Long> {
	
}
