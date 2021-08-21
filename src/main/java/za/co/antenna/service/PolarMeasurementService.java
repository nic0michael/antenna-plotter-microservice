package za.co.antenna.service;

import za.co.antenna.dtos.MeasurementRequest;
import za.co.antenna.dtos.MeasurementResponse;
import za.co.antenna.exceptions.ServiceFailedException;

public interface PolarMeasurementService {

	MeasurementResponse getVerticalPolarResponse(MeasurementRequest request) throws ServiceFailedException;

	MeasurementResponse getHorizontalPolarResponse(MeasurementRequest request) throws ServiceFailedException;

}
