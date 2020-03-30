package com.magrabbit.batch;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.magrabbit.entity.Brand;
import com.magrabbit.entity.Product;

/**
 * Product rơMapper
 * 
 * @author Chiem Lam Mai
 * @since 01-10-2019
 */
public class ProductRowMapper implements RowMapper<Product> {

	/**
	 * Mappping product and data in database
	 */
	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {

		Product product = new Product();

		product.setProductId(rs.getInt("product_id"));
		product.setProductName(rs.getString("product_name"));
		product.setQuantity(rs.getInt("quantity"));
		product.setPrice(rs.getDouble("price"));
		product.setSaleDate(rs.getDate("sale_date"));
		product.setImage(rs.getString("image"));
		product.setDescription(rs.getString("description"));

		Brand brand = new Brand();
		brand.setBrandId(rs.getInt("brand_id"));
		brand.setBrandName(rs.getString("brand_name"));
		product.setBrandEntity(brand);

		return product;
	}
}