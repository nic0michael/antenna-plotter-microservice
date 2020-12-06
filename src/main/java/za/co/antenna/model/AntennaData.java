package za.co.antenna.model;
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
@Table(name = "antenna_data")
public class AntennaData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
    @Column(name="stock_code", unique=true)
    private String stockCode;

	@NotBlank
    @Column(name="antenna_code", unique=true)
    private String antennaCode;	

	@NotBlank
    @Column(name="display_value", unique=true)
    private String displayValue;	
	
	private String description;
	
	@NotBlank
    @Column(name="base_antenna")
    private String baseAntenna;

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

	public AntennaData() {}

	public AntennaData(@NotBlank String stockCode, @NotBlank String antennaCode, @NotBlank String displayValue,
			String description, @NotBlank String baseAntenna, Date dateCreated, @NotBlank String isBaseActive,
			@NotBlank String isActive) {
		super();
		this.stockCode = stockCode;
		this.antennaCode = antennaCode;
		this.displayValue = displayValue;
		this.description = description;
		this.baseAntenna = baseAntenna;
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

	public String getStockCode() {
		return stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	public String getAntennaCode() {
		return antennaCode;
	}

	public void setAntennaCode(String antennaCode) {
		this.antennaCode = antennaCode;
	}

	public String getDisplayValue() {
		return displayValue;
	}

	public void setDisplayValue(String displayValue) {
		this.displayValue = displayValue;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBaseAntenna() {
		return baseAntenna;
	}

	public void setBaseAntenna(String baseAntenna) {
		this.baseAntenna = baseAntenna;
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
		return "AntennaData [id=" + id + ", stockCode=" + stockCode + ", antennaCode=" + antennaCode + ", displayValue="
				+ displayValue + ", description=" + description + ", baseAntenna=" + baseAntenna + ", dateCreated="
				+ dateCreated + ", isBaseActive=" + isBaseActive + ", isActive=" + isActive + "]";
	}

	
}
