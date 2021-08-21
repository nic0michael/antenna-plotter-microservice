package za.co.antenna.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import za.co.antenna.dtos.MeasurementResponse;
import za.co.antenna.dtos.MeasurementRequest;
import za.co.antenna.dtos.MeasurementResponse;
import za.co.antenna.dtos.MeasurementResponse;
import za.co.antenna.servicemanagers.MeasurementServiceManager;


@RestController
@RequestMapping("/measurement")
public class MeasurementRestController {
	
	@Autowired
	MeasurementServiceManager measurementServiceManager;
	
	@PostMapping(value = "/gain", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, 
			consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public MeasurementResponse getGainResponse(@RequestBody MeasurementRequest request)  {
		return measurementServiceManager.getGainResponse( request);
	}	
	
	@PostMapping(value = "/vswr", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, 
			consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public MeasurementResponse getVswrResponse(@RequestBody MeasurementRequest request)  {
		return  measurementServiceManager.getVswrResponse( request);
	}			
	
	@PostMapping(value = "/vpolar", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, 
			consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public MeasurementResponse getVerticalPolarPlot(@RequestBody MeasurementRequest request)  {
		return measurementServiceManager.getVerticalPolarResponse(request);
	}	
	
	@PostMapping(value = "/verticalpolar", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, 
			consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public MeasurementResponse getVerticalpolarPlot(@RequestBody MeasurementRequest request)  {
		return measurementServiceManager.getVerticalPolarResponse(request);
	}
	
	@PostMapping(value = "/hpolar", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, 
			consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public MeasurementResponse getHorizontalPolarPlot(@RequestBody MeasurementRequest request)  {
		return measurementServiceManager.getHorizontalPolarResponse(request);
	}
	
	@PostMapping(value = "/horizontalpolar", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, 
			consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public MeasurementResponse getHorizontalpolarPlot(@RequestBody MeasurementRequest request)  {
		return measurementServiceManager.getHorizontalPolarResponse(request);
	}
}
