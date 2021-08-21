package za.co.antenna.dtos;

import java.util.List;

public class Measurement {
	private String displayValue;
	private List<MeasurementPojo> vswrPojos;
	
	public Measurement() {}

	public Measurement(String displayValue, List<MeasurementPojo> vswrPojos) {
		super();
		this.displayValue = displayValue;
		this.vswrPojos = vswrPojos;
	}

	public String getDisplayValue() {
		return displayValue;
	}

	public void setDisplayValue(String displayValue) {
		this.displayValue = displayValue;
	}

	public List<MeasurementPojo> getMeasurementPojos() {
		return vswrPojos;
	}

	public void setMeasurementPojos(List<MeasurementPojo> vswrPojos) {
		this.vswrPojos = vswrPojos;
	}

	@Override
	public String toString() {
		return "VswrMeasurement [displayValue=" + displayValue + ", vswrPojos=" + vswrPojos + "]";
	}


}
