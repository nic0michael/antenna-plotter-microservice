package za.co.antenna.servicemanagers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import za.co.antenna.dtos.MeasurementResponse;
import za.co.antenna.dtos.MeasurementRequest;
import za.co.antenna.dtos.MeasurementResponse;
import za.co.antenna.dtos.MeasurementResponse;
import za.co.antenna.enums.ErrorCodes;
import za.co.antenna.exceptions.ServiceFailedException;
import za.co.antenna.service.VswrMeasurementService;

@Component
public class VswrMeasurementServiceManager {
	
	@Autowired
	VswrMeasurementService vswrMeasurementService;

	public VswrMeasurementServiceManager() {}

	public VswrMeasurementServiceManager(VswrMeasurementService vswrMeasurementService) {
		super();
		this.vswrMeasurementService = vswrMeasurementService;
	}


	public MeasurementResponse getVswrResponse(MeasurementRequest request) {
		MeasurementResponse response=null;
		try {
			response =vswrMeasurementService.getVswrResponse(request);
		} catch (ServiceFailedException e) {
			response=new MeasurementResponse();
			String responseMessage = ErrorCodes.MEASUREMENT_SERVICE_FAILURE.getMessage();
			String responseCode = ErrorCodes.MEASUREMENT_SERVICE_FAILURE.getCode();
			response.setResponseMessage(responseMessage);
			response.setResponseCode(responseCode);
		}
		return response;
	}
	

}
