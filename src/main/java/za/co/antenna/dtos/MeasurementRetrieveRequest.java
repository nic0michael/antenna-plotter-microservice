package za.co.antenna.dtos;

public class MeasurementRetrieveRequest {

	private String measurementType;
	private String antennaCodes;
	
	public MeasurementRetrieveRequest() {}

	public MeasurementRetrieveRequest(String measurementType, String antennaCodes) {
		super();
		this.measurementType = measurementType;
		this.antennaCodes = antennaCodes;
	}

	public String getMeasurementType() {
		return measurementType;
	}

	public void setMeasurementType(String measurementType) {
		this.measurementType = measurementType;
	}

	public String getAntennaCodes() {
		return antennaCodes;
	}

	public void setAntennaCodes(String antennaCodes) {
		this.antennaCodes = antennaCodes;
	}

	@Override
	public String toString() {
		return "MeasurementRetrieveRequest [measurementType=" + measurementType + ", antennaCodes=" + antennaCodes
				+ "]";
	}
	
	

}
