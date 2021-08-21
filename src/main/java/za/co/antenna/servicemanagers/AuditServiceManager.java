package za.co.antenna.servicemanagers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import za.co.antenna.model.Audit;
import za.co.antenna.model.Employee;
import za.co.antenna.repositories.AuditRepository;
import za.co.antenna.repositories.EmployeeRepository;
import za.co.antenna.utils.Utils;

@Component
public class AuditServiceManager {
	private static final Logger log = LoggerFactory.getLogger(AuditServiceManager.class);
	
	@Autowired
	AuditRepository repository;

	public List<Audit> findAll() {
		System.out.println("getting list of Audits");
		List<Audit> auditList = repository.findAll();
		return auditList;
	}

	public Audit findByAuditId(Long auditId) {
		System.out.println("Finding Audit auditId: "+auditId);
		Audit audit =null;
		if(auditId != null) {
			audit = repository.findByAuditId(auditId);
		}
		return audit;
	}

	public void delete(Long auditId) {
		System.out.println("Deleting Audit auditId: "+auditId);
		Audit audit =null;
		if(auditId != null) {
			audit = findByAuditId(auditId);
			if(audit != null) {
				repository.delete(audit);
			}
		}		
	}
	
	public void save(Audit audit) {
		if(audit != null) {
			Long auditId = audit.getAuditId();
			System.out.println("Saving Audit auditId: "+auditId);
			repository.save(audit);
		}		
	}


}
