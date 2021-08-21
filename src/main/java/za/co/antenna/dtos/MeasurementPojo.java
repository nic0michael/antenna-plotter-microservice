package za.co.antenna.dtos;

public class MeasurementPojo {
	private String determinant;
	private String value;

	public MeasurementPojo() {}

	public MeasurementPojo(String determinant, String value) {
		super();
		this.determinant = determinant;
		this.value = value;
	}

	public String getDeterminant() {
		return determinant;
	}

	public void setDeterminant(String determinant) {
		this.determinant = determinant;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "GainPojo [determinant=" + determinant + ", value=" + value + "]";
	}
	
	
	

}
