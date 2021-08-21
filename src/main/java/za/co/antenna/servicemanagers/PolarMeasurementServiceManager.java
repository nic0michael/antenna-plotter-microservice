package za.co.antenna.servicemanagers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import za.co.antenna.dtos.MeasurementResponse;
import za.co.antenna.dtos.MeasurementRequest;
import za.co.antenna.dtos.MeasurementResponse;
import za.co.antenna.dtos.MeasurementResponse;
import za.co.antenna.enums.ErrorCodes;
import za.co.antenna.exceptions.ServiceFailedException;
import za.co.antenna.service.PolarMeasurementService;



@Component
public class PolarMeasurementServiceManager {
	
	@Autowired
	PolarMeasurementService polarMeasurementService;

	public PolarMeasurementServiceManager(PolarMeasurementService polarMeasurementService) {
		super();
		this.polarMeasurementService = polarMeasurementService;
	}
	
	public PolarMeasurementServiceManager() {}

	public MeasurementResponse getVerticalPolarResponse(MeasurementRequest request) {
		MeasurementResponse response=null;
		try {
			response = polarMeasurementService.getVerticalPolarResponse(request);
		} catch (ServiceFailedException e) {
			response =new MeasurementResponse();
			String responseMessage = ErrorCodes.MEASUREMENT_SERVICE_FAILURE.getMessage();
			String responseCode = ErrorCodes.MEASUREMENT_SERVICE_FAILURE.getCode();
			response.setResponseMessage(responseMessage);
			response.setResponseCode(responseCode);
		}
		return response;
	}

	public MeasurementResponse getHorizontalPolarResponse(MeasurementRequest request) {
		MeasurementResponse response=null;
		try {
			response =  polarMeasurementService.getHorizontalPolarResponse(request);
		} catch (ServiceFailedException e) {
			response =new MeasurementResponse();
			String responseMessage = ErrorCodes.MEASUREMENT_SERVICE_FAILURE.getMessage();
			String responseCode = ErrorCodes.MEASUREMENT_SERVICE_FAILURE.getCode();
			response.setResponseMessage(responseMessage);
			response.setResponseCode(responseCode);
		}
		return response;
	}

	
	
	
	
}
