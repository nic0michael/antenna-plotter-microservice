package za.co.antenna.dtos;

import java.util.List;

public class MeasurementRetrieveResponse {

	private String responseCode;
	private String responseMessage;	
	private String measurementType;
	private String measurementName;
	private String lastUploadDate;
	private String label;
	private List<Measurement> measurements;
	
	public MeasurementRetrieveResponse() {}

	public MeasurementRetrieveResponse(String responseCode, String responseMessage, String measurementType,
			String measurementName, String lastUploadDate, String label, List<Measurement> measurements) {
		super();
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
		this.measurementType = measurementType;
		this.measurementName = measurementName;
		this.lastUploadDate = lastUploadDate;
		this.label = label;
		this.measurements = measurements;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public String getMeasurementType() {
		return measurementType;
	}

	public void setMeasurementType(String measurementType) {
		this.measurementType = measurementType;
	}

	public String getMeasurementName() {
		return measurementName;
	}

	public void setMeasurementName(String measurementName) {
		this.measurementName = measurementName;
	}

	public String getLastUploadDate() {
		return lastUploadDate;
	}

	public void setLastUploadDate(String lastUploadDate) {
		this.lastUploadDate = lastUploadDate;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public List<Measurement> getMeasurements() {
		return measurements;
	}

	public void setMeasurements(List<Measurement> measurements) {
		this.measurements = measurements;
	}

	@Override
	public String toString() {
		return "MeasurementRetrieveResponse [responseCode=" + responseCode + ", responseMessage=" + responseMessage
				+ ", measurementType=" + measurementType + ", measurementName=" + measurementName + ", lastUploadDate="
				+ lastUploadDate + ", label=" + label + ", measurements=" + measurements + "]";
	}

	

}
