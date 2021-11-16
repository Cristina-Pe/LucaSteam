package com.projecto.spring.model;

public class Ventas {

	private String Name;
	private String sales_NA;
	private String sales_EU;
	private String sales_JP;
	private String sales_Other;
	private String sales_Global;
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
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
	
}
