package za.co.kanban.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.config.Task;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import za.co.kanban.dtos.CustomerPersistRequest;
import za.co.kanban.dtos.EmployeePersistRequest;
import za.co.kanban.dtos.EmployeeTeamPersistRequest;
import za.co.kanban.dtos.EpicPersistRequest;
import za.co.kanban.dtos.SubtaskPersistRequest;
import za.co.kanban.dtos.TaskPersistRequest;
import za.co.kanban.dtos.TeamPersistRequest;
import za.co.kanban.dtos.UserStoryPersistRequest;
import za.co.kanban.model.Employee;

public class Utils {
	private static final Logger log = LoggerFactory.getLogger(Utils.class);

	@Value("${project.date.format}")
	static String dateUsaFormat;// 06/17/2020

	@Value("${project.date.iso.format}")
	static String dateIsoFormat;// "yyyy-MM-dd

	@Autowired
	private static BCryptPasswordEncoder passwordEncoder;

	public static String dateToString(Date dateToConvert) {
		String dateToString=null;
		log.info("PROJECT_MAN : Utils : dateToString : converting date:" + dateToConvert);
		if (dateUsaFormat == null) {
			dateUsaFormat = "MM/dd/yyyy";
		}
		if (dateIsoFormat == null) {
			dateUsaFormat = "yyyy-MM-dd";
		}
		if(dateToConvert!=null) {
			DateTimeFormatter newPattern = DateTimeFormatter.ofPattern(dateUsaFormat);
			LocalDateTime datetime = dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
			dateToString = datetime.format(newPattern);
		}
		log.info("PROJECT_MAN : Utils : dateToString : converted to :" + dateToString);
		return dateToString;
	}

	/**
	 * 
	 * project.date.usa.format=MM/dd/yyyy project.date.iso.format=yyyy-MM-dd
	 * 
	 */
	public static Date convertStringToDate(String sDate) {
		String saDateFormat = "dd/MM/yyyy";
		if (dateUsaFormat == null) {
			dateUsaFormat = "MM/dd/yyyy";
		}
		if (dateIsoFormat == null) {
			dateIsoFormat = "yyyy-MM-dd";
		}
		String dateFormt = dateUsaFormat;
		Date date = null;
		if (StringUtils.isNotEmpty(sDate)) {
			if (sDate.contains("/")) {
				dateFormt = dateUsaFormat;
				try {
					date = new SimpleDateFormat(dateFormt).parse(sDate);
				} catch (ParseException e) {
					dateFormt =saDateFormat;
				}
			} else if (sDate.contains("-")) {
				dateFormt = dateIsoFormat;
			}
			if (sDate.length() > 10) {
				sDate = sDate.substring(0, 10);
			}
			try {
				date = new SimpleDateFormat(dateFormt).parse(sDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		log.info("PROJECT_MAN : Utils : convertStringToDate : converting date:" + date);
		return date;
	}
	



	

	
	
	//////////////////// EMPLOYEE /////////////

	public static List<EmployeePersistRequest> makeEmployeePersistRequestList(List<Employee> employees) {
		List<EmployeePersistRequest> employeePersistRequests = new ArrayList<>();
		for (Employee employee : employees) {
			EmployeePersistRequest employeePersistRequest = convertToEmployeePersistRequest(employee);
			employeePersistRequests.add(employeePersistRequest);
		}
		return employeePersistRequests;
	}

	public static List<Employee> makeEmployeeList(List<EmployeePersistRequest> employeePersistRequests) {
		List<Employee> employees = new ArrayList<>();
		for (EmployeePersistRequest employeePersistRequest : employeePersistRequests) {
			Employee employee = convertToEmployee(employeePersistRequest);
			employees.add(employee);
		}
		return employees;
	}


	public static EmployeePersistRequest convertToEmployeePersistRequest(Employee employee) {
		log.info("PROJECT_MAN : Utils : convertToEmployeePersistRequest : Employee :" + employee);
		EmployeePersistRequest employeePersistRequest = new EmployeePersistRequest();
		if (employee.getEmployeeId() != null) {
			employeePersistRequest.setEmployeeId(employee.getEmployeeId().toString());
		}
		if (employee.getTeamId() != null) {
			employeePersistRequest.setTeamId(employee.getTeamId().toString());
		}
		if (employee.getFullName() != null) {
			employeePersistRequest.setFullName(employee.getFullName().toUpperCase());
		}
		if (employee.getIdNumber() != null) {
			employeePersistRequest.setIdNumber(employee.getIdNumber());
		}
		if (employee.getDetails() != null) {
			employeePersistRequest.setDetails(employee.getDetails());
		}
		if (employee.getTelephone() != null) {
			employeePersistRequest.setTelephone(employee.getTelephone());
		}
		if (employee.getCellphone() != null) {
			employeePersistRequest.setCellphone(employee.getCellphone());
		}
		if (employee.getEmail() != null) {
			employeePersistRequest.setEmail(employee.getEmail());
		}
		if (employee.getPassword() != null) {
		    employeePersistRequest.setPassword(employee.getPassword());
		}
		if (employee.getAuthority() != null) {
		    employeePersistRequest.setAuthority(employee.getAuthority());
		}
		if (employee.getUserId() != null) {
		    employeePersistRequest.setUserId(employee.getUserId());
		}
		if (employee.getSkillsCategory() != null) {
		    employeePersistRequest.setSkillsCategory(employee.getSkillsCategory());
		}
		if (employee.getDateCreated() != null) {
		    employeePersistRequest.setDateCreated(dateToString(employee.getDateCreated()));
		}

		if (employee.getEnabled() != null && employee.getEnabled()==1) {
			employeePersistRequest.setEnabled("1");
		} else {
			employeePersistRequest.setEnabled("0");
		}
		return employeePersistRequest;
	}



	public static Employee convertToEmployee(EmployeePersistRequest employeePersistRequest) {
		Employee employee = convertToEmployee(employeePersistRequest, new Employee());
		return employee;
	}

	public static Employee convertToEmployee(EmployeePersistRequest employeePersistRequest, Employee employee) {
		log.info("PROJECT_MAN : Utils : convertToEmployee : EmployeePersistRequest :" + employeePersistRequest);
		employee.setFullName(employeePersistRequest.getFullName().toUpperCase());
		employee.setIdNumber(employeePersistRequest.getIdNumber());
		employee.setDetails(employeePersistRequest.getDetails());
		employee.setTelephone(employeePersistRequest.getTelephone());
		employee.setCellphone(employeePersistRequest.getCellphone());
		employee.setEmail(employeePersistRequest.getEmail());
	    employee.setPassword(employeePersistRequest.getPassword());
	    employee.setAuthority(employeePersistRequest.getAuthority());
	    employee.setUserId(employeePersistRequest.getUserId());
	    employee.setSkillsCategory(employeePersistRequest.getSkillsCategory());
	    
	    if(StringUtils.isNotEmpty(employeePersistRequest.getDateCreated())){
	    	employee.setDateCreated(convertStringToDate(employeePersistRequest.getDateCreated()));
	    }

	    if(StringUtils.isNotEmpty(employeePersistRequest.getEmployeeId()) 
				&& StringUtils.isNumeric(employeePersistRequest.getEmployeeId())){
			Long employeeId=Long.parseLong(employeePersistRequest.getEmployeeId());
	    	employee.setEmployeeId(employeeId);
	    }
	    

	    if(StringUtils.isNotEmpty(employeePersistRequest.getTeamId()) 
				&& StringUtils.isNumeric(employeePersistRequest.getTeamId())){
	    	Long teamId=Long.parseLong(employeePersistRequest.getTeamId());
	    	employee.setTeamId(teamId);
	    }
		


		if (StringUtils.isNotEmpty(employeePersistRequest.getPassword())) {
			if (passwordEncoder == null) {
				passwordEncoder = new BCryptPasswordEncoder();
			}
			employee.setPassword(passwordEncoder.encode(employeePersistRequest.getPassword()));
		}
		if (StringUtils.isNotEmpty(employeePersistRequest.getEnabled())
				&& "1".equals(employeePersistRequest.getEnabled())) {
			employee.setEnabled(1);
		} else {
			employee.setEnabled(0);
		}

		log.info("PROJECT_MAN : Utils : convertToEmployee : Employee :" + employee);
		return employee;
	}
	
	






}
