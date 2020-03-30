package com.magrabbit.entity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.magrabbit.utility.JsonDateSerializer;

/**
 * Product Entity
 * 
 * @author Chiem Lam Mai
 * @since 08-09-2019
 */
@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "product_id")
	private int productId;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "price")
	private Double price;

	@Column(name = "sale_date")
	@Temporal(TemporalType.DATE)
	private Date saleDate;

	@Column(name = "image")
	private String image;

	@Column(name = "description")
	private String description;

	@JoinColumn(name = "brand_id", referencedColumnName = "brand_id")
	@ManyToOne(fetch = FetchType.EAGER)
	private Brand brandEntity;

	public Product() {
	}

	/**
	 * @return the productId
	 */
	public int getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * @return the saleDate
	 */
	@JsonSerialize(using = JsonDateSerializer.class)
	public Date getSaleDate() {
		return saleDate;
	}

	/**
	 * @param saleDate the saleDate to set
	 */
	@JsonSerialize(using = JsonDateSerializer.class)
	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the brand
	 */
	public Brand getBrandEntity() {
		return brandEntity;
	}

	/**
	 * @param brand the brand to set
	 */
	public void setBrandEntity(Brand brandEntity) {
		this.brandEntity = brandEntity;
	}
}