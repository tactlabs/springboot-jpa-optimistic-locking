package com.gmm.entities;
//Author: Muthu Mariyappan G

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;



@Entity
@Table(name="games")
public class Games implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private Integer price;
	private Integer version;
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Id //specified the primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY) //uses the database identity column
	@Column(name="id",unique = true,nullable = false) //name is optional is variable name matches table field name
	public Integer getId() {
		return this.id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="name",nullable = false) // nullable checks whether null accepted, before db throws error
	public String getName() {
		return this.name;
	}
	
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	@Column(name="price",nullable = false) 
	public Integer getPrice() {
		return this.price;
	}
	
	public void setVersion(Integer version) {
		this.version = version;
	}
	
	@Version // version numbering, exclusive use to optimistic locking
	@Column(name="version",nullable = false) 
	public Integer getVersion() {
		return this.version;
	}
}

