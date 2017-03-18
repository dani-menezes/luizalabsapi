package com.luizalabs.api.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.luizalabs.api.common.AbstractCommonBean;

/**
 * Object representation of PRODUCT table. 
 * @author danielmenezes
 */
@Entity
@Table(name = "MARKER")
public class Marker extends AbstractCommonBean {

	/** Generated Serial UID Version. */
	private static final long serialVersionUID = 6642786911210372359L;

	/** Product`s identification. */
	@Id
	@Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/** Product`s name. */;
	@Column(name = "LABEL", nullable = false)
	private String label;
	
	/** Product`s description. */
	@Column(name = "LAT", nullable = false)
	private Double lat;
	
	/** Parent product relationship. */
	@Column(name = "LNG", nullable = false)
    private Double lng;

	/** Default Constructor. */
	public Marker() {}
	
	/** Constructor with attributes. */
	public Marker(Integer id, String label, Double lat, Double lng) {
		this.id = id;
		this.label = label;
		this.lat = lat;
		this.lng = lng;					
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * @return the lat
	 */
	public Double getLat() {
		return lat;
	}

	/**
	 * @param lat the lat to set
	 */
	public void setLat(Double lat) {
		this.lat = lat;
	}

	/**
	 * @return the lng
	 */
	public Double getLng() {
		return lng;
	}

	/**
	 * @param lng the lng to set
	 */
	public void setLng(Double lng) {
		this.lng = lng;
	}
	
}
