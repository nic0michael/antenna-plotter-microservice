package za.co.antenna.validators;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import za.co.antenna.dtos.MeasurementRequest;
import za.co.antenna.enums.ErrorCodes;
import za.co.antenna.enums.MeasurementType;

public class MeasurementRequestValidator {
	private static final Logger log = LoggerFactory.getLogger(MeasurementRequestValidator.class);
	
	private static final String IS_REQUEST_VALID = "isRequestValid";
	private static final String ERROR_CODE = "errorCode";
	private static final String ERROR_MESSAGE = "errorMessage";
	
	private static String measurementType;
	
	public static Map<String, Object> validateMeasurementRequest(MeasurementRequest request,MeasurementType theMeasurementType) {
		measurementType=theMeasurementType.name();
		return validateMeasurementRequest(request);
	}
	
	private static Map<String, Object> validateMeasurementRequest(MeasurementRequest request) {
		Map<String, Object> validationResultMap = new HashMap<>();
		if (request == null) {
			validationResultMap.put(IS_REQUEST_VALID, false);
			validationResultMap.put(ERROR_CODE,ErrorCodes.INVALID_REQUEST.getCode());
			validationResultMap.put(ERROR_MESSAGE, ErrorCodes.INVALID_REQUEST.getMessage());
			log.error("ANTENNA | MeasurementRequestValidator| validateMeasurementRequest | INVALID_REQUEST ");
			return validationResultMap;
		}
		
		if (StringUtils.isEmpty(request.getMeasurementType())) {
			validationResultMap.put(IS_REQUEST_VALID, false);
			validationResultMap.put(ERROR_CODE,ErrorCodes.INVALID_MEASUREMENT_TYPE.getCode());
			validationResultMap.put(ERROR_MESSAGE, ErrorCodes.INVALID_MEASUREMENT_TYPE.getMessage());
			log.error("ANTENNA | MeasurementRequestValidator| validateMeasurementRequest | INVALID_MEASUREMENT_TYPE ");
			return validationResultMap;
		} 
		if(! measurementType.equalsIgnoreCase(request.getMeasurementType())) {
				validationResultMap.put(IS_REQUEST_VALID, false);
				validationResultMap.put(ERROR_CODE,ErrorCodes.INVALID_MEASUREMENT_TYPE.getCode());
				validationResultMap.put(ERROR_MESSAGE, ErrorCodes.INVALID_MEASUREMENT_TYPE.getMessage());
				log.error("ANTENNA | MeasurementRequestValidator| validateMeasurementRequest | INVALID_MEASUREMENT_TYPE ");
				return validationResultMap;
		}
		
		if (request.getAntennaCodes()==null || request.getAntennaCodes().isEmpty()) {
			validationResultMap.put(IS_REQUEST_VALID, false);
			validationResultMap.put(ERROR_CODE,ErrorCodes.INVALID_FIELD_ANTENNA_CODES.getCode());
			validationResultMap.put(ERROR_MESSAGE, ErrorCodes.INVALID_FIELD_ANTENNA_CODES.getMessage());
			log.error("ANTENNA | MeasurementRequestValidator| validateMeasurementRequest | INVALID_FIELD_ANTENNA_CODES ");
			return validationResultMap;
		}
		

		
		validationResultMap.put(IS_REQUEST_VALID, true);
		log.info("ANTENNA | MeasurementRequestValidator| validateMeasurementRequest | Completed");
		return validationResultMap;
		
	}

}
