package za.co.antenna.data.adapters;

import za.co.antenna.dtos.MeasurementResponse;
import za.co.antenna.dtos.MeasurementRetrieveResponse;

public interface DataAdapter {
	public  MeasurementResponse convertToMeasurementResponse(MeasurementRetrieveResponse measurementRetrieveResponse);

}
