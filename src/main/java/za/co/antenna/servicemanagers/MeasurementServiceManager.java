package za.co.antenna.servicemanagers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import za.co.antenna.dtos.MeasurementResponse;
import za.co.antenna.dtos.MeasurementRequest;
import za.co.antenna.dtos.MeasurementResponse;
import za.co.antenna.dtos.MeasurementResponse;
import za.co.antenna.enums.ErrorCodes;
import za.co.antenna.enums.MeasurementType;
import za.co.antenna.validators.MeasurementRequestValidator;

@Component
public class MeasurementServiceManager {
	private static final Logger log = LoggerFactory.getLogger(MeasurementServiceManager.class);

	private static final String IS_REQUEST_VALID = "isRequestValid";
	private static final String ERROR_CODE = "errorCode";
	private static final String ERROR_MESSAGE = "errorMessage";
	
	@Autowired
	GainMeasurementServiceManager gainMeasurementServiceManager;

	@Autowired
	VswrMeasurementServiceManager vswrMeasurementServiceManager;

	@Autowired
	PolarMeasurementServiceManager polarMeasurementServiceManager;
	
	
	
	public MeasurementServiceManager(GainMeasurementServiceManager gainMeasurementServiceManager,
			VswrMeasurementServiceManager vswrMeasurementServiceManager,
			PolarMeasurementServiceManager polarMeasurementServiceManager) {
		super();
		this.gainMeasurementServiceManager = gainMeasurementServiceManager;
		this.vswrMeasurementServiceManager = vswrMeasurementServiceManager;
		this.polarMeasurementServiceManager = polarMeasurementServiceManager;
	}

	public MeasurementResponse getGainResponse(MeasurementRequest request) {
		Map<String, Object> validationResult = MeasurementRequestValidator.validateMeasurementRequest(request,MeasurementType.GAIN);
		boolean requestIsValid = (boolean) validationResult.get(IS_REQUEST_VALID);
		if (!requestIsValid) {
			String responseCode = (String) validationResult.get(ERROR_CODE);
			String responseMessage = (String) validationResult.get(ERROR_MESSAGE);
			MeasurementResponse response =new MeasurementResponse(); 
			response.setResponseCode(responseCode);
			response.setResponseMessage(responseMessage);
			log.error("ANTENNA : MeasurementServiceManager : getVerticalPolarResponse :Validation failed : response : " + response);
			return response;
		}
		
		MeasurementResponse response = gainMeasurementServiceManager.getGainResponse(request);
		log.info("ANTENNA : MeasurementServiceManager :getGainResponse  response "+response);
		return response;
	}

	public MeasurementResponse getVswrResponse(MeasurementRequest request) {
		Map<String, Object> validationResult = MeasurementRequestValidator.validateMeasurementRequest(request,MeasurementType.VSWR);
		boolean requestIsValid = (boolean) validationResult.get(IS_REQUEST_VALID);
		if (!requestIsValid) {
			String responseCode = (String) validationResult.get(ERROR_CODE);
			String responseMessage = (String) validationResult.get(ERROR_MESSAGE);
			MeasurementResponse response =new MeasurementResponse();
			response.setResponseCode(responseCode);
			response.setResponseMessage(responseMessage);
			log.error("ANTENNA : MeasurementServiceManager : getVswrResponse :Validation failed : response : " + response);
			return response;
		}
		
		MeasurementResponse response = vswrMeasurementServiceManager.getVswrResponse(request);
		log.info("ANTENNA : MeasurementServiceManager :getVswrResponse  response "+response);
		return response;
	}

	public MeasurementResponse getVerticalPolarResponse(MeasurementRequest request) {
		Map<String, Object> validationResult = MeasurementRequestValidator.validateMeasurementRequest(request,MeasurementType.VPOLAR);
		boolean requestIsValid = (boolean) validationResult.get(IS_REQUEST_VALID);
		if (!requestIsValid) {
			String responseCode = (String) validationResult.get(ERROR_CODE);
			String responseMessage = (String) validationResult.get(ERROR_MESSAGE);
			MeasurementResponse response =new MeasurementResponse(); 
			response.setResponseCode(responseCode);
			response.setResponseMessage(responseMessage);
			log.error("ANTENNA : MeasurementServiceManager : getVerticalPolarResponse :Validation failed : response : " + response);
			return response;
		}
		MeasurementResponse response = polarMeasurementServiceManager.getVerticalPolarResponse(request);
		log.info("ANTENNA : MeasurementServiceManager :getVerticalPolarResponse  response "+response);
		return response;
	}
	

	public MeasurementResponse getHorizontalPolarResponse(MeasurementRequest request) {
		Map<String, Object> validationResult = MeasurementRequestValidator.validateMeasurementRequest(request,MeasurementType.HPOLAR);
		boolean requestIsValid = (boolean) validationResult.get(IS_REQUEST_VALID);
		if (!requestIsValid) {
			String responseCode = (String) validationResult.get(ERROR_CODE);
			String responseMessage = (String) validationResult.get(ERROR_MESSAGE);
			MeasurementResponse response =new MeasurementResponse(); 
			response.setResponseCode(responseCode);
			response.setResponseMessage(responseMessage);
			log.error("ANTENNA : MeasurementServiceManager : sendEmail :Validation failed : response : " + response);
			return response;
		}
		MeasurementResponse response = polarMeasurementServiceManager.getHorizontalPolarResponse(request);
		log.info("ANTENNA : MeasurementServiceManager :getHorizontalPolarResponse  response "+response);
		return response;
	}
	

}
