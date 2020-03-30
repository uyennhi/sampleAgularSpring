package com.magrabbit.batch;

import java.io.IOException;
import java.io.Writer;

import org.springframework.batch.item.file.FlatFileHeaderCallback;

/**
 * Flat file header
 * 
 * @author Chiem Lam Mai
 * @since 01-10-2019
 */
public class ProductHeader implements FlatFileHeaderCallback {

	/**
	 * Set header for output csv file
	 * 
	 * @param writer
	 */
	@Override
	public void writeHeader(Writer writer) throws IOException {
		writer.write("Product ID, ProductName, Quantity, Price, Brand ID, Brand Name, Sale Date, Image, Description");
	}
}