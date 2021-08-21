package za.co.antenna.service;

import java.util.ArrayList;
import java.util.List;

import za.co.antenna.dtos.MeasurementRequest;
import za.co.antenna.dtos.Measurement;
import za.co.antenna.dtos.MeasurementPojo;
import za.co.antenna.dtos.Measurement;
import za.co.antenna.dtos.MeasurementResponse;
import za.co.antenna.enums.ErrorCodes;
import za.co.antenna.enums.TestType;
import za.co.antenna.exceptions.ServiceFailedException;

public class MockVswrMeasurementServiceImpl implements VswrMeasurementService {
	String testType;

	private MockVswrMeasurementServiceImpl() {
	}

	public MockVswrMeasurementServiceImpl(TestType testType) {
		this.testType = testType.name();
	}

	@Override
	public MeasurementResponse getVswrResponse(MeasurementRequest request) throws ServiceFailedException {
		MeasurementResponse vswrResponse = null;
		switch (testType) {
		case "PASSING":
			vswrResponse = makeSuccessResponse();
			break;
		case "FAILING":
			vswrResponse = makeFailedResponse();
			break;
		case "THROWS_EXCEPTIONS":
			throw new ServiceFailedException();
		}
		return vswrResponse;
	}

	private MeasurementResponse makeFailedResponse() {
		MeasurementResponse vswrResponse = new MeasurementResponse();
		String responseMessage = ErrorCodes.MEASUREMENT_SERVICE_FAILURE.getMessage();
		String responseCode = ErrorCodes.MEASUREMENT_SERVICE_FAILURE.getCode();
		vswrResponse.setResponseMessage(responseMessage);
		vswrResponse.setResponseCode(responseCode);
		return vswrResponse;
	}

	private MeasurementResponse makeSuccessResponse() {
		MeasurementResponse vswrResponse = new MeasurementResponse();
		String responseMessage = ErrorCodes.SUCCESS.getMessage();
		String responseCode = ErrorCodes.SUCCESS.getCode();
		String vswrAntennaName = "TESTAnt001";
		String vswrLabel = "dummy_vswr_label";
		String vswrLastUploadDate = "2020-12-17";
		String vswrMeasurementName = "dummy_measurement_name";
		vswrResponse.setMeasurementName(vswrMeasurementName);
		vswrResponse.setLastUploadDate(vswrLastUploadDate);
		vswrResponse.setLabel(vswrLabel);
		vswrResponse.setResponseMessage(responseMessage);
		vswrResponse.setResponseCode(responseCode);
		vswrResponse.setMeasurements(makeMeasurements());
		return vswrResponse;
	}



	private List<Measurement> makeMeasurements() {
		List<MeasurementPojo>vswrPojos=makeMeasurementPojos();
		List<Measurement>measurements=new ArrayList<>();
		Measurement measurement=new Measurement();
		measurement.setMeasurementPojos(vswrPojos);
		measurements.add(measurement);
		return measurements;
	}
	
	private List<MeasurementPojo> makeMeasurementPojos() {
		MeasurementPojo vswPojo = null;
		String frequency;
		String vswrValue;
		List<MeasurementPojo> vswrPojos = new ArrayList<>();

		vswPojo = new MeasurementPojo("100", "1.7");
		vswrPojos.add(vswPojo);

		vswPojo = new MeasurementPojo("110", "1.6");
		vswrPojos.add(vswPojo);

		vswPojo = new MeasurementPojo("120", "1.5");
		vswrPojos.add(vswPojo);

		vswPojo = new MeasurementPojo("130", "1.2");
		vswrPojos.add(vswPojo);

		vswPojo = new MeasurementPojo("140", "1.1");
		vswrPojos.add(vswPojo);

		vswPojo = new MeasurementPojo("150", "1.2");
		vswrPojos.add(vswPojo);

		vswPojo = new MeasurementPojo("160", "1.5");
		vswrPojos.add(vswPojo);

		vswPojo = new MeasurementPojo("170", "1.6");
		vswrPojos.add(vswPojo);

		vswPojo = new MeasurementPojo("180", "1.7");
		vswrPojos.add(vswPojo);

		return vswrPojos;
	}

}
