package za.co.antenna.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the ant_data database table.
 * 
 */
@Entity
@Table(name="ant_data")
@NamedQuery(name="Data.findAll", query="SELECT d FROM Data d")
public class Data implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="dta_id")
	private int dtaId;

	@Column(name="dta_date_created")
	private Timestamp dtaDateCreated;

	@Column(name="dta_determinant")
	private double dtaDeterminant;

	@Column(name="dta_value")
	private double dtaValue;

	//bi-directional many-to-one association to Antenna
	@ManyToOne
	@JoinColumn(name="dta_antenna_ant_code")
	private Antenna antAntenna;

	//bi-directional many-to-one association to Measurement
	@ManyToOne
	@JoinColumn(name="dta_measurement_msm_code")
	private Measurement antMeasurement;

	public Data() {
	}

	public int getDtaId() {
		return this.dtaId;
	}

	public void setDtaId(int dtaId) {
		this.dtaId = dtaId;
	}

	public Timestamp getDtaDateCreated() {
		return this.dtaDateCreated;
	}

	public void setDtaDateCreated(Timestamp dtaDateCreated) {
		this.dtaDateCreated = dtaDateCreated;
	}

	public double getDtaDeterminant() {
		return this.dtaDeterminant;
	}

	public void setDtaDeterminant(double dtaDeterminant) {
		this.dtaDeterminant = dtaDeterminant;
	}

	public double getDtaValue() {
		return this.dtaValue;
	}

	public void setDtaValue(double dtaValue) {
		this.dtaValue = dtaValue;
	}

	public Antenna getAntAntenna() {
		return this.antAntenna;
	}

	public void setAntAntenna(Antenna antAntenna) {
		this.antAntenna = antAntenna;
	}

	public Measurement getAntMeasurement() {
		return this.antMeasurement;
	}

	public void setAntMeasurement(Measurement antMeasurement) {
		this.antMeasurement = antMeasurement;
	}

}
