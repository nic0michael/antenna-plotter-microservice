package za.co.antenna.servicemanagers;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.hamcrest.core.IsNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import za.co.antenna.dtos.Measurement;
import za.co.antenna.dtos.MeasurementPojo;
import za.co.antenna.dtos.MeasurementResponse;
import za.co.antenna.dtos.MeasurementRequest;
import za.co.antenna.dtos.Measurement;
import za.co.antenna.dtos.MeasurementResponse;
import za.co.antenna.dtos.Measurement;
import za.co.antenna.dtos.MeasurementResponse;
import za.co.antenna.enums.ErrorCodes;
import za.co.antenna.enums.MeasurementType;
import za.co.antenna.enums.TestType;
import za.co.antenna.exceptions.ServiceFailedException;
import za.co.antenna.service.GainMeasurementService;
import za.co.antenna.service.MockGainMeasurementServiceImpl;
import za.co.antenna.service.MockPolarMeasurementServiceImpl;
import za.co.antenna.service.MockVswrMeasurementServiceImpl;
import za.co.antenna.service.PolarMeasurementService;

@RunWith(SpringRunner.class)
public class MeasurementServiceManagerTest {
	
	@Test
	public void getGainResponseSuccessfulTest() {
		
		GainMeasurementService gainMeasurementService=new MockGainMeasurementServiceImpl(TestType.PASSING);
		GainMeasurementServiceManager gainMeasurementServiceManager=new GainMeasurementServiceManager(gainMeasurementService);		
		VswrMeasurementServiceManager vswrMeasurementServiceManager=new VswrMeasurementServiceManager();
		PolarMeasurementServiceManager polarMeasurementServiceManager=new PolarMeasurementServiceManager();
		MeasurementServiceManager measurementServiceManager=new MeasurementServiceManager(gainMeasurementServiceManager, vswrMeasurementServiceManager, polarMeasurementServiceManager);
		
		
		MeasurementRequest request=makeGainMeasurementRequest();
		
		MeasurementResponse response = measurementServiceManager.getGainResponse(request);		
		assertThat(response,notNullValue());
		
		List<Measurement> measurements = response.getMeasurements();
		assertThat(measurements,notNullValue());
		Measurement measurement = measurements.get(0);
		assertThat(measurement,notNullValue());
		List<MeasurementPojo> gainPojos = measurement.getMeasurementPojos();
		assertThat(gainPojos,notNullValue());
		assertThat(gainPojos.isEmpty(), is(false));
		
		String responseCode = response.getResponseCode();
		String responseMessage = response.getResponseMessage();
		System.out.println("responseCode : "+responseCode);
		System.out.println("responseMessage : "+responseMessage);
		
		assertThat(responseCode, is(ErrorCodes.SUCCESS.getCode()));
		assertThat(responseMessage, is(ErrorCodes.SUCCESS.getMessage()));
	}

	@Test
	public void getGainResponseFailedTest() {
		
		GainMeasurementService gainMeasurementService=new MockGainMeasurementServiceImpl(TestType.FAILING);
		GainMeasurementServiceManager gainMeasurementServiceManager=new GainMeasurementServiceManager(gainMeasurementService);		
		VswrMeasurementServiceManager vswrMeasurementServiceManager=new VswrMeasurementServiceManager();
		PolarMeasurementServiceManager polarMeasurementServiceManager=new PolarMeasurementServiceManager();
		MeasurementServiceManager measurementServiceManager=new MeasurementServiceManager(gainMeasurementServiceManager, vswrMeasurementServiceManager, polarMeasurementServiceManager);
		
		
		MeasurementRequest request=makeGainMeasurementRequest();
		
		MeasurementResponse response = measurementServiceManager.getGainResponse(request);		
		assertThat(response,notNullValue());
		
		List<Measurement> measurements = response.getMeasurements();
		assertThat(measurements,is(IsNull.nullValue()));
		
		String responseCode = response.getResponseCode();
		String responseMessage = response.getResponseMessage();
		System.out.println("responseCode : "+responseCode);
		System.out.println("responseMessage : "+responseMessage);
		
		assertThat(responseCode, is(ErrorCodes.MEASUREMENT_SERVICE_FAILURE.getCode()));
		assertThat(responseMessage, is(ErrorCodes.MEASUREMENT_SERVICE_FAILURE.getMessage()));
	}
	


	@Test
	public void getGainResponseThrowsExceptionTest() {
		
		GainMeasurementService gainMeasurementService=new MockGainMeasurementServiceImpl(TestType.THROWS_EXCEPTIONS);
		GainMeasurementServiceManager gainMeasurementServiceManager=new GainMeasurementServiceManager(gainMeasurementService);		
		VswrMeasurementServiceManager vswrMeasurementServiceManager=new VswrMeasurementServiceManager();
		PolarMeasurementServiceManager polarMeasurementServiceManager=new PolarMeasurementServiceManager();
		MeasurementServiceManager measurementServiceManager=new MeasurementServiceManager(gainMeasurementServiceManager, vswrMeasurementServiceManager, polarMeasurementServiceManager);
		
		MeasurementRequest request=makeGainMeasurementRequest();
		MeasurementResponse response = measurementServiceManager.getGainResponse(request);		
		assertThat(response,notNullValue());
		
		List<Measurement> measurements = response.getMeasurements();
		assertThat(measurements,is(IsNull.nullValue()));
		
		String responseCode = response.getResponseCode();
		String responseMessage = response.getResponseMessage();
		System.out.println("responseCode : "+responseCode);
		System.out.println("responseMessage : "+responseMessage);
		
		assertThat(responseCode, is(ErrorCodes.MEASUREMENT_SERVICE_FAILURE.getCode()));
		assertThat(responseMessage, is(ErrorCodes.MEASUREMENT_SERVICE_FAILURE.getMessage()));
	}
	

	
	@Test
	public void getVswrResponseSuccessfulTest() {

		GainMeasurementServiceManager gainMeasurementServiceManager=new GainMeasurementServiceManager();		
		VswrMeasurementServiceManager vswrMeasurementServiceManager=new VswrMeasurementServiceManager(new MockVswrMeasurementServiceImpl(TestType.PASSING));
		PolarMeasurementServiceManager polarMeasurementServiceManager=new PolarMeasurementServiceManager();
		MeasurementServiceManager measurementServiceManager=new MeasurementServiceManager(gainMeasurementServiceManager, vswrMeasurementServiceManager, polarMeasurementServiceManager);
		
		
		MeasurementRequest request=makeVswrMeasurementRequest();
		
		MeasurementResponse response = measurementServiceManager.getVswrResponse(request);		
		assertThat(response,notNullValue());
		

		List<Measurement> measurements = response.getMeasurements();
		assertThat(measurements,notNullValue());
		Measurement measurement = measurements.get(0);
		assertThat(measurement,notNullValue());
		List<MeasurementPojo> pojos = measurement.getMeasurementPojos();
		assertThat(pojos,notNullValue());
		assertThat(pojos.isEmpty(), is(false));
		
		String responseCode = response.getResponseCode();
		String responseMessage = response.getResponseMessage();
		System.out.println("responseCode : "+responseCode);
		System.out.println("responseMessage : "+responseMessage);
		
		assertThat(responseCode, is(ErrorCodes.SUCCESS.getCode()));
		assertThat(responseMessage, is(ErrorCodes.SUCCESS.getMessage()));
	}
	

	@Test
	public void getVswrResponseFailingTest() {	

		GainMeasurementServiceManager gainMeasurementServiceManager=new GainMeasurementServiceManager();		
		VswrMeasurementServiceManager vswrMeasurementServiceManager=new VswrMeasurementServiceManager(new MockVswrMeasurementServiceImpl(TestType.FAILING));
		PolarMeasurementServiceManager polarMeasurementServiceManager=new PolarMeasurementServiceManager();
		MeasurementServiceManager measurementServiceManager=new MeasurementServiceManager(gainMeasurementServiceManager, vswrMeasurementServiceManager, polarMeasurementServiceManager);
		
		
		MeasurementRequest request=makeVswrMeasurementRequest();
		
		MeasurementResponse response = measurementServiceManager.getVswrResponse(request);		
		assertThat(response,notNullValue());		

		List<Measurement> measurements = response.getMeasurements();
		assertThat(measurements,is(IsNull.nullValue()));
		
		String responseCode = response.getResponseCode();
		String responseMessage = response.getResponseMessage();
		System.out.println("responseCode : "+responseCode);
		System.out.println("responseMessage : "+responseMessage);
		
		assertThat(responseCode, is(ErrorCodes.MEASUREMENT_SERVICE_FAILURE.getCode()));
		assertThat(responseMessage, is(ErrorCodes.MEASUREMENT_SERVICE_FAILURE.getMessage()));
	}

	@Test
	public void getVswrResponseThrowsExceptionTest() {	

		GainMeasurementServiceManager gainMeasurementServiceManager=new GainMeasurementServiceManager();		
		VswrMeasurementServiceManager vswrMeasurementServiceManager=new VswrMeasurementServiceManager(new MockVswrMeasurementServiceImpl(TestType.THROWS_EXCEPTIONS));
		PolarMeasurementServiceManager polarMeasurementServiceManager=new PolarMeasurementServiceManager();
		MeasurementServiceManager measurementServiceManager=new MeasurementServiceManager(gainMeasurementServiceManager, vswrMeasurementServiceManager, polarMeasurementServiceManager);
		
		
		MeasurementRequest request=makeVswrMeasurementRequest();
		
		MeasurementResponse response = measurementServiceManager.getVswrResponse(request);		
		assertThat(response,notNullValue());		

		List<Measurement> measurements = response.getMeasurements();
		assertThat(measurements,is(IsNull.nullValue()));
		
		String responseCode = response.getResponseCode();
		String responseMessage = response.getResponseMessage();
		System.out.println("responseCode : "+responseCode);
		System.out.println("responseMessage : "+responseMessage);
		
		assertThat(responseCode, is(ErrorCodes.MEASUREMENT_SERVICE_FAILURE.getCode()));
		assertThat(responseMessage, is(ErrorCodes.MEASUREMENT_SERVICE_FAILURE.getMessage()));
	}

	
	@Test
	public void getHorizontalPolarResponseSuccessfulTest() {
		
		GainMeasurementServiceManager gainMeasurementServiceManager=new GainMeasurementServiceManager();		
		VswrMeasurementServiceManager vswrMeasurementServiceManager=new VswrMeasurementServiceManager();
		PolarMeasurementService polarMeasurementService=new MockPolarMeasurementServiceImpl(TestType.PASSING);
		PolarMeasurementServiceManager polarMeasurementServiceManager=new PolarMeasurementServiceManager(polarMeasurementService);
		MeasurementServiceManager measurementServiceManager=new MeasurementServiceManager(gainMeasurementServiceManager, vswrMeasurementServiceManager, polarMeasurementServiceManager);
		
		
		MeasurementRequest request=makeHorizontalPolarMeasurementRequest();
		
		 MeasurementResponse response = measurementServiceManager.getHorizontalPolarResponse(request);		
		assertThat(response,notNullValue());
		
		 List<Measurement> measurements = response.getMeasurements();
		assertThat(measurements,notNullValue());
		Measurement measurement = measurements.get(0);
		assertThat(measurement,notNullValue());
		 List<MeasurementPojo> polarePojos = measurement.getMeasurementPojos();
		assertThat(polarePojos,notNullValue());
		assertThat(polarePojos.isEmpty(), is(false));
		
		String responseCode = response.getResponseCode();
		String responseMessage = response.getResponseMessage();
		System.out.println("responseCode : "+responseCode);
		System.out.println("responseMessage : "+responseMessage);
		
		assertThat(responseCode, is(ErrorCodes.SUCCESS.getCode()));
		assertThat(responseMessage, is(ErrorCodes.SUCCESS.getMessage()));
	}
	
	@Test
	public void getHorizontalPolarResponseFailedTest() {
		
		GainMeasurementServiceManager gainMeasurementServiceManager=new GainMeasurementServiceManager();		
		VswrMeasurementServiceManager vswrMeasurementServiceManager=new VswrMeasurementServiceManager();
		PolarMeasurementService polarMeasurementService=new MockPolarMeasurementServiceImpl(TestType.FAILING);
		PolarMeasurementServiceManager polarMeasurementServiceManager=new PolarMeasurementServiceManager(polarMeasurementService);
		MeasurementServiceManager measurementServiceManager=new MeasurementServiceManager(gainMeasurementServiceManager, vswrMeasurementServiceManager, polarMeasurementServiceManager);
		
		
		MeasurementRequest request=makeHorizontalPolarMeasurementRequest();
		
		 MeasurementResponse response = measurementServiceManager.getHorizontalPolarResponse(request);		
		assertThat(response,notNullValue());
		

		List<Measurement> measurements = response.getMeasurements();

		assertThat(measurements,is(IsNull.nullValue()));
		
		String responseCode = response.getResponseCode();
		String responseMessage = response.getResponseMessage();
		System.out.println("responseCode : "+responseCode);
		System.out.println("responseMessage : "+responseMessage);
		
		assertThat(responseCode, is(ErrorCodes.MEASUREMENT_SERVICE_FAILURE.getCode()));
		assertThat(responseMessage, is(ErrorCodes.MEASUREMENT_SERVICE_FAILURE.getMessage()));	
		
	}
	

	@Test
	public void getHorizontalPolarResponseThrowsExceptionTest() {
		
		GainMeasurementServiceManager gainMeasurementServiceManager=new GainMeasurementServiceManager();		
		VswrMeasurementServiceManager vswrMeasurementServiceManager=new VswrMeasurementServiceManager();
		PolarMeasurementService polarMeasurementService=new MockPolarMeasurementServiceImpl(TestType.THROWS_EXCEPTIONS);
		PolarMeasurementServiceManager polarMeasurementServiceManager=new PolarMeasurementServiceManager(polarMeasurementService);
		MeasurementServiceManager measurementServiceManager=new MeasurementServiceManager(gainMeasurementServiceManager, vswrMeasurementServiceManager, polarMeasurementServiceManager);
		
		
		MeasurementRequest request=makeHorizontalPolarMeasurementRequest();
		
		 MeasurementResponse response = measurementServiceManager.getHorizontalPolarResponse(request);		
		assertThat(response,notNullValue());
		

		List<Measurement> measurements = response.getMeasurements();

		assertThat(measurements,is(IsNull.nullValue()));
		
		String responseCode = response.getResponseCode();
		String responseMessage = response.getResponseMessage();
		System.out.println("responseCode : "+responseCode);
		System.out.println("responseMessage : "+responseMessage);
		
		assertThat(responseCode, is(ErrorCodes.MEASUREMENT_SERVICE_FAILURE.getCode()));
		assertThat(responseMessage, is(ErrorCodes.MEASUREMENT_SERVICE_FAILURE.getMessage()));	
		
	}

	

	
	@Test
	public void getVerticalPolarResponseSuccessfulTest() {
		
		GainMeasurementServiceManager gainMeasurementServiceManager=new GainMeasurementServiceManager();		
		VswrMeasurementServiceManager vswrMeasurementServiceManager=new VswrMeasurementServiceManager();
		PolarMeasurementService polarMeasurementService=new MockPolarMeasurementServiceImpl(TestType.PASSING);
		PolarMeasurementServiceManager polarMeasurementServiceManager=new PolarMeasurementServiceManager(polarMeasurementService);
		MeasurementServiceManager measurementServiceManager=new MeasurementServiceManager(gainMeasurementServiceManager, vswrMeasurementServiceManager, polarMeasurementServiceManager);
		
		
		MeasurementRequest request=makeVerticalPolarMeasurementRequest();
		
		 MeasurementResponse response = measurementServiceManager.getVerticalPolarResponse(request);		
		assertThat(response,notNullValue());
		
		 List<Measurement> measurements = response.getMeasurements();
		assertThat(measurements,notNullValue());
		Measurement measurement = measurements.get(0);
		assertThat(measurement,notNullValue());
		 List<MeasurementPojo> polarePojos = measurement.getMeasurementPojos();
		assertThat(polarePojos,notNullValue());
		assertThat(polarePojos.isEmpty(), is(false));
		
		String responseCode = response.getResponseCode();
		String responseMessage = response.getResponseMessage();
		System.out.println("responseCode : "+responseCode);
		System.out.println("responseMessage : "+responseMessage);
		
		assertThat(responseCode, is(ErrorCodes.SUCCESS.getCode()));
		assertThat(responseMessage, is(ErrorCodes.SUCCESS.getMessage()));
	}
	
	@Test
	public void getVerticalPolarResponseFailedTest() {
		
		GainMeasurementServiceManager gainMeasurementServiceManager=new GainMeasurementServiceManager();		
		VswrMeasurementServiceManager vswrMeasurementServiceManager=new VswrMeasurementServiceManager();
		PolarMeasurementService polarMeasurementService=new MockPolarMeasurementServiceImpl(TestType.FAILING);
		PolarMeasurementServiceManager polarMeasurementServiceManager=new PolarMeasurementServiceManager(polarMeasurementService);
		MeasurementServiceManager measurementServiceManager=new MeasurementServiceManager(gainMeasurementServiceManager, vswrMeasurementServiceManager, polarMeasurementServiceManager);
		
		
		MeasurementRequest request=makeVerticalPolarMeasurementRequest();
		
		 MeasurementResponse response = measurementServiceManager.getVerticalPolarResponse(request);		
		assertThat(response,notNullValue());
		

		List<Measurement> measurements = response.getMeasurements();

		assertThat(measurements,is(IsNull.nullValue()));
		
		String responseCode = response.getResponseCode();
		String responseMessage = response.getResponseMessage();
		System.out.println("responseCode : "+responseCode);
		System.out.println("responseMessage : "+responseMessage);
		
		assertThat(responseCode, is(ErrorCodes.MEASUREMENT_SERVICE_FAILURE.getCode()));
		assertThat(responseMessage, is(ErrorCodes.MEASUREMENT_SERVICE_FAILURE.getMessage()));	
		
	}
	

	@Test
	public void getVerticalPolarResponseThrowsExceptionTest() {
		
		GainMeasurementServiceManager gainMeasurementServiceManager=new GainMeasurementServiceManager();		
		VswrMeasurementServiceManager vswrMeasurementServiceManager=new VswrMeasurementServiceManager();
		PolarMeasurementService polarMeasurementService=new MockPolarMeasurementServiceImpl(TestType.THROWS_EXCEPTIONS);
		PolarMeasurementServiceManager polarMeasurementServiceManager=new PolarMeasurementServiceManager(polarMeasurementService);
		MeasurementServiceManager measurementServiceManager=new MeasurementServiceManager(gainMeasurementServiceManager, vswrMeasurementServiceManager, polarMeasurementServiceManager);
		
		
		MeasurementRequest request=makeVerticalPolarMeasurementRequest();
		
		 MeasurementResponse response = measurementServiceManager.getVerticalPolarResponse(request);		
		assertThat(response,notNullValue());
		

		List<Measurement> measurements = response.getMeasurements();

		assertThat(measurements,is(IsNull.nullValue()));
		
		String responseCode = response.getResponseCode();
		String responseMessage = response.getResponseMessage();
		System.out.println("responseCode : "+responseCode);
		System.out.println("responseMessage : "+responseMessage);
		
		assertThat(responseCode, is(ErrorCodes.MEASUREMENT_SERVICE_FAILURE.getCode()));
		assertThat(responseMessage, is(ErrorCodes.MEASUREMENT_SERVICE_FAILURE.getMessage()));	
		
	}

	private MeasurementRequest makeVerticalPolarMeasurementRequest() {
		MeasurementRequest request=new MeasurementRequest();
		request.setMeasurementType(MeasurementType.VPOLAR.name().toUpperCase());
		request.setAntennaCodes("ANT001|Ant005|Ant007");
		return request;
	}

	private MeasurementRequest makeHorizontalPolarMeasurementRequest() {
		MeasurementRequest request=new MeasurementRequest();
		request.setMeasurementType(MeasurementType.HPOLAR.name().toUpperCase());
		request.setAntennaCodes("ANT001|Ant005|Ant007");
		return request;
	}

	private MeasurementRequest makeGainMeasurementRequest() {
		MeasurementRequest request=new MeasurementRequest();
		request.setMeasurementType(MeasurementType.GAIN.name().toUpperCase());
		request.setAntennaCodes("ANT001|Ant005|Ant007");
		return request;
	}


	private MeasurementRequest makeVswrMeasurementRequest() {
		MeasurementRequest request=new MeasurementRequest();
		request.setMeasurementType(MeasurementType.VSWR.name().toUpperCase());
		request.setAntennaCodes("ANT001|Ant005|Ant007");
		return request;
	}

}
