package com.khoubyari.example.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "ground")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class BookGround {

	 public BookGround() {
	    }
	public BookGround(String name,String groundDescrption,String location,long price) {
		this.groundDescrption=groundDescrption;
		this.name=name;
		this.location=location;
		this.price=price;
	}
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable=false)
	private String name;
	
	@Column
	private String groundDescrption;
	
	@Column
	private String location;
	
	@Column
	private long price;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGroundDescrption() {
		return groundDescrption;
	}

	public void setGroundDescrption(String groundDescrption) {
		this.groundDescrption = groundDescrption;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}
	
	  @Override
	    public String toString() {
	        return "BookGround {" +
	                "id=" + id +
	                ", name='" + name + '\'' +
	                ", groundDescrption='" + groundDescrption + '\'' +
	                ", location='" + location + '\'' +
	                ", price=" + price +
	                '}';
	    }
}
