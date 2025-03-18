package programs;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EstablishingConnection {
	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("karthik");
		System.out.println("connection established>>.");
	}
}
