package za.co.kanban.model;
import java.util.Objects;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "antenna_polar_data")
public class AntennaPolarData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
    @Column(name="antenna_data_id")
	private Long antennaDataId;
	
	@NotBlank
    @Column(name="angle")
    private double angle;
	
	@NotBlank
    @Column(name="measurement_value")
    private double measurementValue;
	
	@NotBlank
    @Column(name="measurement_type")
    private String measurementType;

	@NotBlank
    @Column(name="antenna_code")
    private String antennaCode;	

	@NotBlank
    @Column(name="base_antenna")
    private String baseAntenna;	

	private String description;

	@Column(name="date_created", nullable = true, updatable = true)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date dateCreated;	

	@NotBlank
	@Column(name="is_base_antenna")
	private String isBaseActive;
	
	@NotBlank
	@Column(name="is_active")
	private String isActive;

	public AntennaPolarData() {}

	public AntennaPolarData(@NotBlank Long antennaDataId, @NotBlank double angle, @NotBlank double measurementValue,
			@NotBlank String measurementType, @NotBlank String antennaCode, @NotBlank String baseAntenna,
			String description, Date dateCreated, @NotBlank String isBaseActive, @NotBlank String isActive) {
		super();
		this.antennaDataId = antennaDataId;
		this.angle = angle;
		this.measurementValue = measurementValue;
		this.measurementType = measurementType;
		this.antennaCode = antennaCode;
		this.baseAntenna = baseAntenna;
		this.description = description;
		this.dateCreated = dateCreated;
		this.isBaseActive = isBaseActive;
		this.isActive = isActive;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAntennaDataId() {
		return antennaDataId;
	}

	public void setAntennaDataId(Long antennaDataId) {
		this.antennaDataId = antennaDataId;
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	public double getMeasurementValue() {
		return measurementValue;
	}

	public void setMeasurementValue(double measurementValue) {
		this.measurementValue = measurementValue;
	}

	public String getMeasurementType() {
		return measurementType;
	}

	public void setMeasurementType(String measurementType) {
		this.measurementType = measurementType;
	}

	public String getAntennaCode() {
		return antennaCode;
	}

	public void setAntennaCode(String antennaCode) {
		this.antennaCode = antennaCode;
	}

	public String getBaseAntenna() {
		return baseAntenna;
	}

	public void setBaseAntenna(String baseAntenna) {
		this.baseAntenna = baseAntenna;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getIsBaseActive() {
		return isBaseActive;
	}

	public void setIsBaseActive(String isBaseActive) {
		this.isBaseActive = isBaseActive;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "AntennaPolarData [id=" + id + ", antennaDataId=" + antennaDataId + ", angle=" + angle
				+ ", measurementValue=" + measurementValue + ", measurementType=" + measurementType + ", antennaCode="
				+ antennaCode + ", baseAntenna=" + baseAntenna + ", description=" + description + ", dateCreated="
				+ dateCreated + ", isBaseActive=" + isBaseActive + ", isActive=" + isActive + "]";
	}

	
}
