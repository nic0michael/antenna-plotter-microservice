package za.co.antenna.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the ant_measurement database table.
 * 
 */
@Entity
@Table(name="ant_measurement")
@NamedQuery(name="Measurement.findAll", query="SELECT m FROM Measurement m")
public class Measurement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="msm_id")
	private int msmId;

	@Column(name="msm_code")
	private String msmCode;

	@Column(name="msm_date_created")
	private Timestamp msmDateCreated;

	@Column(name="msm_description")
	private String msmDescription;

	@Column(name="msm_name")
	private String msmName;

	//bi-directional many-to-one association to Data
	@OneToMany(mappedBy="antMeasurement")
	private List<Data> antData;

	public Measurement() {
	}

	public int getMsmId() {
		return this.msmId;
	}

	public void setMsmId(int msmId) {
		this.msmId = msmId;
	}

	public String getMsmCode() {
		return this.msmCode;
	}

	public void setMsmCode(String msmCode) {
		this.msmCode = msmCode;
	}

	public Timestamp getMsmDateCreated() {
		return this.msmDateCreated;
	}

	public void setMsmDateCreated(Timestamp msmDateCreated) {
		this.msmDateCreated = msmDateCreated;
	}

	public String getMsmDescription() {
		return this.msmDescription;
	}

	public void setMsmDescription(String msmDescription) {
		this.msmDescription = msmDescription;
	}

	public String getMsmName() {
		return this.msmName;
	}

	public void setMsmName(String msmName) {
		this.msmName = msmName;
	}

	public List<Data> getAntData() {
		return this.antData;
	}

	public void setAntData(List<Data> antData) {
		this.antData = antData;
	}

	public Data addAntData(Data antData) {
		getAntData().add(antData);
		antData.setAntMeasurement(this);

		return antData;
	}

	public Data removeAntData(Data antData) {
		getAntData().remove(antData);
		antData.setAntMeasurement(null);

		return antData;
	}

}