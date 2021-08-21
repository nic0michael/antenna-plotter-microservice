package za.co.antenna.data.adapters;

import org.springframework.stereotype.Component;

import za.co.antenna.dtos.MeasurementResponse;
import za.co.antenna.dtos.MeasurementRetrieveResponse;

@Component
public class MeasurementResponseAdapter implements DataAdapter {

	@Override
	public  MeasurementResponse convertToMeasurementResponse(MeasurementRetrieveResponse measurementRetrieveResponse) {
		MeasurementResponse measurementResponse=new MeasurementResponse();
		measurementResponse.setLabel(measurementRetrieveResponse.getLabel());
		measurementResponse.setLastUploadDate(measurementRetrieveResponse.getLastUploadDate());
		measurementResponse.setMeasurementName(measurementRetrieveResponse.getMeasurementName());
		measurementResponse.setMeasurements(measurementRetrieveResponse.getMeasurements());
		measurementResponse.setMeasurementType(measurementRetrieveResponse.getMeasurementType());
		measurementResponse.setResponseCode(measurementRetrieveResponse.getResponseCode());
		measurementResponse.setResponseMessage(measurementRetrieveResponse.getResponseMessage());
		return measurementResponse;
	}
	
	

}
