package za.co.antenna.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the ant_antenna database table.
 * 
 */
@Entity
@Table(name="ant_antenna")
@NamedQuery(name="Antenna.findAll", query="SELECT a FROM Antenna a")
public class Antenna  implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ant_id")
	private int antId;

	@Column(name="ant_code")
	private String antCode;

	@Column(name="ant_date_created")
	private Timestamp antDateCreated;

	@Column(name="ant_description")
	private String antDescription;

	@Column(name="ant_name")
	private String antName;

	//bi-directional many-to-one association to Antenna
	@ManyToOne
	@JoinColumn(name="ant_antenna_ant_code")
	private Antenna antAntenna;

	//bi-directional many-to-one association to Antenna
	@OneToMany(mappedBy="antAntenna")
	private List<Antenna> antAntennas;

	//bi-directional many-to-one association to Type
	@ManyToOne
	@JoinColumn(name="ant_type_ant_type_code")
	private Type antType;

	//bi-directional many-to-one association to Data
	@OneToMany(mappedBy="antAntenna")
	private List<Data> antData;

	public Antenna() {
	}

	public int getAntId() {
		return this.antId;
	}

	public void setAntId(int antId) {
		this.antId = antId;
	}

	public String getAntCode() {
		return this.antCode;
	}

	public void setAntCode(String antCode) {
		this.antCode = antCode;
	}

	public Timestamp getAntDateCreated() {
		return this.antDateCreated;
	}

	public void setAntDateCreated(Timestamp antDateCreated) {
		this.antDateCreated = antDateCreated;
	}

	public String getAntDescription() {
		return this.antDescription;
	}

	public void setAntDescription(String antDescription) {
		this.antDescription = antDescription;
	}

	public String getAntName() {
		return this.antName;
	}

	public void setAntName(String antName) {
		this.antName = antName;
	}

	public Antenna getAntAntenna() {
		return this.antAntenna;
	}

	public void setAntAntenna(Antenna antAntenna) {
		this.antAntenna = antAntenna;
	}

	public List<Antenna> getAntAntennas() {
		return this.antAntennas;
	}

	public void setAntAntennas(List<Antenna> antAntennas) {
		this.antAntennas = antAntennas;
	}

	public Antenna addAntAntenna(Antenna antAntenna) {
		getAntAntennas().add(antAntenna);
		antAntenna.setAntAntenna(this);

		return antAntenna;
	}

	public Antenna removeAntAntenna(Antenna antAntenna) {
		getAntAntennas().remove(antAntenna);
		antAntenna.setAntAntenna(null);

		return antAntenna;
	}

	public Type getAntType() {
		return this.antType;
	}

	public void setAntType(Type antType) {
		this.antType = antType;
	}

	public List<Data> getAntData() {
		return this.antData;
	}

	public void setAntData(List<Data> antData) {
		this.antData = antData;
	}

	public Data addAntData(Data antData) {
		getAntData().add(antData);
		antData.setAntAntenna(this);

		return antData;
	}

	public Data removeAntData(Data antData) {
		getAntData().remove(antData);
		antData.setAntAntenna(null);

		return antData;
	}


}
