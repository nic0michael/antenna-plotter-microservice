package za.co.antenna.service;

import za.co.antenna.dtos.MeasurementResponse;
import za.co.antenna.dtos.MeasurementRequest;
import za.co.antenna.exceptions.ServiceFailedException;

public interface GainMeasurementService {

	MeasurementResponse getGainResponse(MeasurementRequest request) throws ServiceFailedException;

}
