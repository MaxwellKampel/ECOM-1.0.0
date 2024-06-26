package com.ecomsite.api.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty(message="Product Name is required!")
    @Size(min=3, max=30, message="Product Name must be between 3 and 30 characters")
    private String name;
    
    @NotEmpty(message="Decription is required!")
    @Size(min=3, max=30, message="Description must be between 3 and 30 characters")
    private String description;
    
    @NotEmpty(message="Decription is required!")
    private Double price;
    
    @NotEmpty(message="Type of Product is required")
    @Size(min=3, max=30, message="Valid product type must be between 3 and 30 characters")
    private String type;
    
    @NotEmpty(message="Type of Product is required")
    @Size(min=3, max=30, message="Valid product type must be between 3 and 30 characters")
    private String brand;
    
//    Inventory or stock
    @NotEmpty(message="Stock is required")
    @Min(value=0, message="cannot be less than 0")
    private String stock;
    
    @NotNull
    private Boolean isLive;
    
    
    
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    
//    ----- Relationship
//    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
//    private List<Order> orders;
    
//    @ManyToMany for categories

    public Product() {}
    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public Boolean getIsLive() {
		return isLive;
	}

	public void setIsLive(Boolean isLive) {
		this.isLive = isLive;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
    
    
}
