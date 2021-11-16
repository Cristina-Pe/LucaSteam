package com.projecto.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Juego", schema = "public")

public class Juego {

	/**
	 * Definicion del modelo juego, sus atributos y metodos
	 */

	private int id;
	private String name;
	private String platform;
	private String year;
	private String genre;
	private String publisher;
	private String sales_NA;
	private String sales_EU;
	private String sales_JP;
	private String sales_Other;
	private String sales_Global;

	public Juego() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getSales_NA() {
		return sales_NA;
	}

	public void setSales_NA(String sales_NA) {
		this.sales_NA = sales_NA;
	}

	public String getSales_EU() {
		return sales_EU;
	}

	public void setSales_EU(String sales_EU) {
		this.sales_EU = sales_EU;
	}

	public String getSales_JP() {
		return sales_JP;
	}

	public void setSales_JP(String sales_JP) {
		this.sales_JP = sales_JP;
	}

	public String getSales_Other() {
		return sales_Other;
	}

	public void setSales_Other(String sales_Other) {
		this.sales_Other = sales_Other;
	}

	public String getSales_Global() {
		return sales_Global;
	}

	public void setSales_Global(String sales_Global) {
		this.sales_Global = sales_Global;
	}

	@Override
	public String toString() {
		return "Juego [id=" + id + ", name=" + name + ", platform=" + platform + ", year=" + year + ", genre=" + genre
				+ ", publisher=" + publisher + ", sales_NA=" + sales_NA + ", sales_EU=" + sales_EU + ", sales_JP="
				+ sales_JP + ", sales_Other=" + sales_Other + ", sales_Global=" + sales_Global + "]";
	}

	
	
	
}
