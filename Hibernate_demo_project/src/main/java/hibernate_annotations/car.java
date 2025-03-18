package hibernate_annotations;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="car_details") // it shows Car_details as the table name in database only ,not affected in java
public class car {
	
	@Id
	@Column(name="car_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	// nullable -> we cannot enter null values (default nullable is true)
	//length -> fixing the length of the varchar (default value is varchar(225))
	@Column(name = "car_brand" ,nullable = false , length = 15) 			
	private String brand;
	
	@Column(name = "car_price")
	private int price;
	
	//unique -> it will not allow the duplicate value (default is true)
	@Column(name = "car_color" ,unique = false)
	private String color;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
}
