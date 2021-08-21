package za.co.antenna.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import za.co.antenna.dtos.MeasurementRequest;
import za.co.antenna.data.adapters.MeasurementResponseAdapter;
import za.co.antenna.dtos.MeasurementResponse;
import za.co.antenna.dtos.MeasurementRetrieveResponse;
import za.co.antenna.exceptions.ServiceFailedException;

@Service
public class PolarMeasurementServiceImpl implements PolarMeasurementService{
	
	@Autowired
	MeasurementResponseAdapter measurementResponseAdapter;
	
	@Value("${antenna.persistence.service.hpolar.uri}")
	String antennaPersistenceServiceHorizontalPolarUri;
	
	@Value("${antenna.persistence.service.vpolar.uri}")
	String antennaPersistenceServiceVerticalPolarUri;

	@Override
	public MeasurementResponse getHorizontalPolarResponse(MeasurementRequest request) throws ServiceFailedException {
		MeasurementResponse response= processHorizontalOperation(request);
		response.setMeasurementType(request.getMeasurementType().toUpperCase());
		return response;
	}

	@Override
	public MeasurementResponse getVerticalPolarResponse(MeasurementRequest request) throws ServiceFailedException {
		MeasurementResponse response= processVerticalOperation(request);
		response.setMeasurementType(request.getMeasurementType().toUpperCase());
		return response;
	}
	
	private MeasurementResponse processHorizontalOperation(MeasurementRequest request) throws ServiceFailedException{
		MeasurementResponse response= processHorizontalPolar(request);
		return response;
	}

	private MeasurementResponse processVerticalOperation(MeasurementRequest request) throws ServiceFailedException{
		MeasurementResponse response= processVerticalPolar(request);
		return response;
	}
	
	private MeasurementResponse processHorizontalPolar(MeasurementRequest request)  throws ServiceFailedException{
		MeasurementRetrieveResponse measurementRetrieveResponse= new MeasurementRetrieveResponse();
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();

	    headers.setContentType(MediaType.APPLICATION_JSON);
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity<MeasurementRequest> entity = new  HttpEntity<MeasurementRequest>(request,headers);

	    measurementRetrieveResponse = restTemplate.exchange(antennaPersistenceServiceHorizontalPolarUri, HttpMethod.POST, entity, MeasurementRetrieveResponse.class).getBody();		
		MeasurementResponse response = measurementResponseAdapter.convertToMeasurementResponse(measurementRetrieveResponse);
		
		return response;
	}
	
	private MeasurementResponse processVerticalPolar(MeasurementRequest request)  throws ServiceFailedException{
		MeasurementRetrieveResponse measurementRetrieveResponse= new MeasurementRetrieveResponse();
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();

	    headers.setContentType(MediaType.APPLICATION_JSON);
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity<MeasurementRequest> entity = new  HttpEntity<MeasurementRequest>(request,headers);

	    measurementRetrieveResponse = restTemplate.exchange(antennaPersistenceServiceVerticalPolarUri, HttpMethod.POST, entity, MeasurementRetrieveResponse.class).getBody();		
		MeasurementResponse response = measurementResponseAdapter.convertToMeasurementResponse(measurementRetrieveResponse);
		
		return response;
	}
}
