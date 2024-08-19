package com.maha.ecommerce.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "product")
public class Product extends BaseModel {
	private String title;
	private String description;
	private Double price;
	private String image;
	@ManyToOne
	private Category category;
	private Integer qty;
	private Integer numberOfOrders;
}

//1				->			1			=> M:1 Many to One.
//Product ------------------	Category
//M				<-			1
//====================================
//M							1


//Movie  ---------------------- 	Actor	=> Many to Many.
//1				->				M
//M				<-				1
//=====================================
//M								M
