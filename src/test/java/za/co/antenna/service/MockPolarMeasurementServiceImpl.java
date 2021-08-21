package za.co.antenna.service;

import java.util.ArrayList;
import java.util.List;

import za.co.antenna.dtos.Measurement;
import za.co.antenna.dtos.MeasurementPojo;
import za.co.antenna.dtos.MeasurementRequest;
import za.co.antenna.dtos.Measurement;
import za.co.antenna.dtos.MeasurementResponse;
import za.co.antenna.enums.ErrorCodes;
import za.co.antenna.enums.TestType;
import za.co.antenna.exceptions.ServiceFailedException;

public class MockPolarMeasurementServiceImpl implements PolarMeasurementService{
	String testType;

	public MockPolarMeasurementServiceImpl(){}
	
	
	
	public MockPolarMeasurementServiceImpl(TestType testType) {
		this.testType = testType.name();
	}



	@Override
	public MeasurementResponse getVerticalPolarResponse(MeasurementRequest request) throws ServiceFailedException {
		MeasurementResponse polarResponse=null;
		switch (testType) {
		case "PASSING":
			polarResponse = makeSuccessResponse();
			break;
		case "FAILING":
			polarResponse = makeFailedResponse();
			break;
		case "THROWS_EXCEPTIONS":
			throw new ServiceFailedException();
		}
		
		return polarResponse;
	}

	@Override
	public MeasurementResponse getHorizontalPolarResponse(MeasurementRequest request) throws ServiceFailedException {
		MeasurementResponse polarResponse=null;
		switch (testType) {
		case "PASSING":
			polarResponse = makeSuccessResponse();
			break;
		case "FAILING":
			polarResponse = makeFailedResponse();
			break;
		case "THROWS_EXCEPTIONS":
			throw new ServiceFailedException();
		}
		
		return polarResponse;
	}

	private MeasurementResponse makeFailedResponse() {
		MeasurementResponse response=new MeasurementResponse();
		String responseMessage = ErrorCodes.MEASUREMENT_SERVICE_FAILURE.getMessage();
		String responseCode = ErrorCodes.MEASUREMENT_SERVICE_FAILURE.getCode();
		response.setResponseMessage(responseMessage);
		response.setResponseCode(responseCode);
		return response;
	}

	private MeasurementResponse makeSuccessResponse() {
		MeasurementResponse response=new MeasurementResponse();

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
		response.setMeasurements( makeMeasurements());;
		return response;
	}


	private List<Measurement> makeMeasurements() {
		List<MeasurementPojo> polarPojos=makeMeasurementPojos();
		List<Measurement>measurements=new ArrayList<>();
		Measurement measurement=new Measurement();
		measurement.setMeasurementPojos(polarPojos);
		measurements.add(measurement);
		return measurements;
	}
	
	private List<MeasurementPojo> makeMeasurementPojos() {
		MeasurementPojo polarPojo=null;
		List<MeasurementPojo>polarPojos=new ArrayList<>();
		
		String antennaDisplayValue="Antenna001";
		
		polarPojo=new MeasurementPojo("0", "0");
		polarPojos.add(polarPojo);

		polarPojo=new MeasurementPojo("15", "-1");
		polarPojos.add(polarPojo);

		polarPojo=new MeasurementPojo("30", "-1");
		polarPojos.add(polarPojo);

		polarPojo=new MeasurementPojo("45", "-3");
		polarPojos.add(polarPojo);

		polarPojo=new MeasurementPojo("60", "-5");
		polarPojos.add(polarPojo);

		polarPojo=new MeasurementPojo("75", "-6");
		polarPojos.add(polarPojo);

		polarPojo=new MeasurementPojo("90", "-10");
		polarPojos.add(polarPojo);
		
		
		return polarPojos;
	}




}
