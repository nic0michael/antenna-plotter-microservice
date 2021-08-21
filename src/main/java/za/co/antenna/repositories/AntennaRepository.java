package za.co.antenna.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.antenna.model.Antenna;

public interface AntennaRepository extends JpaRepository<Antenna, Long> {

}
