package com.learning.building.model;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;

@Entity
@Table(name="spent")
public class Spent {
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(nullable=false)
	private String description;
	
	@NotNull @Min(value=1)
	@Column(nullable=false)
	private Double price;
	
	
	@ManyToOne
	@JoinColumn(name="material_type_id")
	private MaterialType materialType;
	
	@Column(nullable=false)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate registerDate;

	private static final NumberFormat numberFormat = NumberFormat.getNumberInstance(new Locale("pt", "BR"));
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public MaterialType getMaterialType() {
		return materialType;
	}

	public void setMaterialType(MaterialType materialType) {
		this.materialType = materialType;
	}

	public Double getPrice() {
		return price;
	}
	
	public String getPriceFormated(){
		return convertPriceToString(price);
	}
	
	public void setPrice(Double value) {
		this.price = value;
	}
	
	public static NumberFormat getNumberformat() {
		return numberFormat;
	}
	
	public static String convertPriceToString(double price){
		return numberFormat.format(price);
	}
	
	public static double formatStringToPrice(String strPrice) throws ParseException{
		return numberFormat.parse(strPrice).doubleValue();
	}

	public LocalDate getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(LocalDate registerDate) {
		this.registerDate = registerDate;
	}
	
}
