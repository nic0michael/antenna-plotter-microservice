package za.co.antenna.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the ant_type database table.
 * 
 */
@Entity
@Table(name="ant_type")
@NamedQuery(name="Type.findAll", query="SELECT t FROM Type t")
public class Type implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ant_type_id")
	private int antTypeId;

	@Column(name="ant_type_code")
	private String antTypeCode;

	@Column(name="ant_type_date_created")
	private Timestamp antTypeDateCreated;

	@Column(name="ant_type_description")
	private String antTypeDescription;

	@Column(name="ant_type_name")
	private String antTypeName;

	//bi-directional many-to-one association to Antenna
	@OneToMany(mappedBy="antType")
	private List<Antenna> antAntennas;

	public Type() {
	}

	public int getAntTypeId() {
		return this.antTypeId;
	}

	public void setAntTypeId(int antTypeId) {
		this.antTypeId = antTypeId;
	}

	public String getAntTypeCode() {
		return this.antTypeCode;
	}

	public void setAntTypeCode(String antTypeCode) {
		this.antTypeCode = antTypeCode;
	}

	public Timestamp getAntTypeDateCreated() {
		return this.antTypeDateCreated;
	}

	public void setAntTypeDateCreated(Timestamp antTypeDateCreated) {
		this.antTypeDateCreated = antTypeDateCreated;
	}

	public String getAntTypeDescription() {
		return this.antTypeDescription;
	}

	public void setAntTypeDescription(String antTypeDescription) {
		this.antTypeDescription = antTypeDescription;
	}

	public String getAntTypeName() {
		return this.antTypeName;
	}

	public void setAntTypeName(String antTypeName) {
		this.antTypeName = antTypeName;
	}

	public List<Antenna> getAntAntennas() {
		return this.antAntennas;
	}

	public void setAntAntennas(List<Antenna> antAntennas) {
		this.antAntennas = antAntennas;
	}

	public Antenna addAntAntenna(Antenna antAntenna) {
		getAntAntennas().add(antAntenna);
		antAntenna.setAntType(this);

		return antAntenna;
	}

	public Antenna removeAntAntenna(Antenna antAntenna) {
		getAntAntennas().remove(antAntenna);
		antAntenna.setAntType(null);

		return antAntenna;
	}

}