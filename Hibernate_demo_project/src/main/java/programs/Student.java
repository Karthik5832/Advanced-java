package programs;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	
	//(@Id is used to fix the sid as primary key)
	@Id 
	private int sid;
	
	
	private String name;
	private int age;
	private String address;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
