package za.co.antenna.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the file_image_measurement database table.
 * 
 */
@Entity
@Table(name = "file_image_measurement")
//@NamedQuery(name="FileImageMeasurement.findAll", query="SELECT fim FROM FileImageMeasurement fim")
public class FileImageMeasurement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "file_image_measurement_id")
	private Long fileImageMeasurementId;

	@Column(name = "determinant", nullable = false)
	private double determinant;

	@Column(name = "value", nullable = false)
	private double value;

	@Column(name = "antenna_code", length=128, nullable = false)
	private String antennaCode;
	
	// Bidirectional many-to-one association to FileImage
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "antenna_code", nullable = false, updatable = false, insertable = false, referencedColumnName = "antenna_code")
	private FileImage fileImage;

	public FileImageMeasurement() {
	}

	public Long getFileImageMeasurementId() {
		return fileImageMeasurementId;
	}

	public void setFileImageMeasurementId(Long fileImageMeasurementId) {
		this.fileImageMeasurementId = fileImageMeasurementId;
	}

	public double getDeterminant() {
		return determinant;
	}

	public void setDeterminant(double determinant) {
		this.determinant = determinant;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getAntennaCode() {
		return antennaCode;
	}

	public void setAntennaCode(String antennaCode) {
		this.antennaCode = antennaCode;
	}

	public FileImage getFileImage() {
		return fileImage;
	}

	public void setFileImage(FileImage fileImage) {
		this.fileImage = fileImage;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Data [fileImageMeasurementId=" +
				fileImageMeasurementId +
				", determinant=" +
				determinant +
				", value=" +
				value +
				", antennaCode=" +
				antennaCode +
				"]";
	}
}