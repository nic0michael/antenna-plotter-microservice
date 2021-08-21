package za.co.antenna.service;

import java.util.ArrayList;
import java.util.List;

import za.co.antenna.dtos.Measurement;
import za.co.antenna.dtos.MeasurementPojo;
import za.co.antenna.dtos.MeasurementResponse;
import za.co.antenna.dtos.MeasurementRequest;
import za.co.antenna.enums.ErrorCodes;
import za.co.antenna.enums.TestType;
import za.co.antenna.exceptions.ServiceFailedException;

public class MockGainMeasurementServiceImpl implements GainMeasurementService{
	String testType;
	
	private MockGainMeasurementServiceImpl() {}
	
	public MockGainMeasurementServiceImpl(TestType testType) {
		this.testType = testType.name();
	}

	@Override
	public MeasurementResponse getGainResponse(MeasurementRequest request) throws ServiceFailedException {

		MeasurementResponse gainResponse = null;
		switch (testType) {
		case "PASSING":
			gainResponse = makeSuccessResponse();
			break;
		case "FAILING":
			gainResponse = makeFailedResponse();
			break;
		case "THROWS_EXCEPTIONS":
			throw new ServiceFailedException();
		}
		return gainResponse;
	}

	private MeasurementResponse makeFailedResponse() {
		MeasurementResponse response =new MeasurementResponse();
		String responseMessage = ErrorCodes.MEASUREMENT_SERVICE_FAILURE.getMessage();
		String responseCode = ErrorCodes.MEASUREMENT_SERVICE_FAILURE.getCode();
		response.setResponseMessage(responseMessage);
		response.setResponseCode(responseCode);
		return response;
	}


	private MeasurementResponse makeSuccessResponse() {
		MeasurementResponse response =new MeasurementResponse();
		String responseMessage = ErrorCodes.SUCCESS.getMessage();
		String responseCode = ErrorCodes.SUCCESS.getCode();
		String vswrAntennaName = "TESTAnt001";
		String vswrLabel = "dummy_vswr_label";
		String vswrLastUploadDate = "2020-12-17";
		String vswrMeasurementName = "dummy_measurement_name";
		response.setMeasurementName(vswrMeasurementName);
		response.setLastUploadDate(vswrLastUploadDate);
		response.setLabel(vswrLabel);
		response.setResponseMessage(responseMessage);
		response.setResponseCode(responseCode);
		response.setMeasurements(makeMeasurements());
		return response;
	}

	private List<Measurement> makeMeasurements() {
		List<MeasurementPojo> gainPojos=makeMeasurementPojos();
		List<Measurement>measurements=new ArrayList<>();
		Measurement measurement=new Measurement();
		measurement.setMeasurementPojos(gainPojos);
		measurements.add(measurement);
		return measurements;
	}

	private List<MeasurementPojo> makeMeasurementPojos() {
		
		MeasurementPojo gainPojo=null;
		List<MeasurementPojo>gainPojos=new ArrayList<>();
		
		gainPojo=new MeasurementPojo("100", "-9");
		gainPojos.add(gainPojo);
		
		gainPojo=new MeasurementPojo("100", "-6");
		gainPojos.add(gainPojo);
		
		gainPojo=new MeasurementPojo("110", "-3");
		gainPojos.add(gainPojo);
		
		gainPojo=new MeasurementPojo("110", "0");
		gainPojos.add(gainPojo);
		
		gainPojo=new MeasurementPojo("130", "-3");
		gainPojos.add(gainPojo);
		
		gainPojo=new MeasurementPojo("140", "-6");
		gainPojos.add(gainPojo);
		
		gainPojo=new MeasurementPojo("150", "-9");
		gainPojos.add(gainPojo);

		return gainPojos;
	}

	

}
