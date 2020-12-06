package za.co.antenna.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.antenna.model.Audit;

public interface AuditRepository  extends JpaRepository<Audit, Long> {

	public Audit findByAuditId(Long auditId);

}