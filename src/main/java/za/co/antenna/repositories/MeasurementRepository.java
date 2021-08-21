package za.co.antenna.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.antenna.model.Measurement;

public interface MeasurementRepository extends JpaRepository<Measurement, Long> {

}
