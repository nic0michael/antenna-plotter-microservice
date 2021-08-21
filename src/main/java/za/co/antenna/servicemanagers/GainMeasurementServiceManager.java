package za.co.antenna.servicemanagers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import za.co.antenna.dtos.MeasurementResponse;
import za.co.antenna.dtos.MeasurementRequest;
import za.co.antenna.dtos.MeasurementResponse;
import za.co.antenna.dtos.MeasurementResponse;
import za.co.antenna.enums.ErrorCodes;
import za.co.antenna.exceptions.ServiceFailedException;
import za.co.antenna.service.GainMeasurementService;

@Component
public class GainMeasurementServiceManager {
	
	@Autowired
	GainMeasurementService gainMeasurementService;

	public GainMeasurementServiceManager() {}
	
	public GainMeasurementServiceManager(GainMeasurementService gainMeasurementService) {
		super();
		this.gainMeasurementService = gainMeasurementService;
	}

	public MeasurementResponse getGainResponse(MeasurementRequest request) {
		MeasurementResponse response = null;
		try {
			response = gainMeasurementService.getGainResponse( request) ;
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
