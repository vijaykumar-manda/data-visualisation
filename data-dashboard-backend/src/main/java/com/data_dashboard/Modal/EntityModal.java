package com.data_dashboard.Modal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "data")
public class EntityModal {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String endYear;
	@Column(nullable = true)
	private String citylng;
	@Column(nullable = true)
	private String citylat;
	@Column(name = "intensity")
	private int intensity;
	private String sector;
	private String topic;
	@Column(length = 400)
	private String insight;
	@Column(length = 400)
	private String swot;	
	private String url;
	private String region;
	private String startYear;
	private String impact;
	private String added;
	private String published;
	private String city;
	private String country;
	private int relevance;
	private String pestle;
	private String source;
	@Column(length = 400)
	private String title;
	private int likelihood;		

	
	public String getCitylng() {
		return citylng;
	}

	public void setCitylng(String citylng) {
		this.citylng = citylng;
	}

	public String getCitylat() {
		return citylat;
	}

	public void setCitylat(String citylat) {
		this.citylat = citylat;
	}



	

	public String getEndYear() {
		return endYear;
	}

	public void setEndYear(String endYear) {
		this.endYear = endYear;
	}



	public int getIntensity() {
		return intensity;
	}

	public void setIntensity(int intensity) {
		this.intensity = intensity;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getInsight() {
		return insight;
	}

	public void setInsight(String insight) {
		this.insight = insight;
	}

	public String getSwot() {
		return swot;
	}

	public void setSwot(String swot) {
		this.swot = swot;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getStartYear() {
		return startYear;
	}

	public void setStartYear(String startYear) {
		this.startYear = startYear;
	}

	public String getImpact() {
		return impact;
	}

	public void setImpact(String impact) {
		this.impact = impact;
	}

	public String getAdded() {
		return added;
	}

	public void setAdded(String added) {
		this.added = added;
	}

	public String getPublished() {
		return published;
	}

	public void setPublished(String published) {
		this.published = published;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getRelevance() {
		return relevance;
	}

	public void setRelevance(int relevance) {
		this.relevance = relevance;
	}

	public String getPestle() {
		return pestle;
	}

	public void setPestle(String pestle) {
		this.pestle = pestle;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getLikelihood() {
		return likelihood;
	}

	public void setLikelihood(int likelihood) {
		this.likelihood = likelihood;
	}

	// Constructors, getters, setters, and other methods
}
