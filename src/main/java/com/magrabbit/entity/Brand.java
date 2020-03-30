package com.magrabbit.entity;

import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Brand Entity
 * 
 * @author Chiem Lam Mai
 * @since 08-09-2019
 */
@Entity
@Table(name = "brand")
public class Brand {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "brand_id")
	private int brandId;

	@Column(name = "brand_name")
	private String brandName;

	@Column(name = "logo")
	private String logo;

	@Column(name = "description")
	private String description;

	@JsonIgnore
	@OneToMany(mappedBy = "brandEntity", fetch = FetchType.LAZY)
	private Set<Product> productSet;

	public Brand() {
	}

	/**
	 * @return the brandId
	 */
	public int getBrandId() {
		return brandId;
	}

	/**
	 * @param brandId the brandId to set
	 */
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	/**
	 * @return the prandName
	 */
	public String getBrandName() {
		return brandName;
	}

	/**
	 * @param prandName the prandName to set
	 */
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	/**
	 * @return the logo
	 */
	public String getLogo() {
		return logo;
	}

	/**
	 * @param logo the logo to set
	 */
	public void setLogo(String logo) {
		this.logo = logo;
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
	 * @return the product
	 */
	public Set<Product> getProductSet() {
		return productSet;
	}

	/**
	 * @param product the product to set
	 */
	public void setProductSet(Set<Product> productSet) {
		this.productSet = productSet;
	}
}