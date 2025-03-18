package com.jsp.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.dto.GroceryShop;

@Repository
public class GroceryShopdao {
	
	@Autowired
	EntityManager manager;
	
	@Autowired
	EntityTransaction transaction;
	
	//to insert item object into DB
	public void insertEmployee(GroceryShop groceryShop) {
		
		transaction.begin();
		manager.persist(groceryShop);
		transaction.commit();
	}
	
	//to search for an items based on Id
	public GroceryShop searchGroceryShopItem(int i) {
		
		GroceryShop groceryShop = manager.find(GroceryShop.class, i);
		return groceryShop;
	}
	
	//to update groceryShop stock in DB
	public void updateGroceryShop(GroceryShop newGroceryShop) {
		
		transaction.begin();
		manager.merge(newGroceryShop);
		transaction.commit();
	}
	
	//to display all employee details
	 public List<GroceryShop> findAll() {
	        TypedQuery<GroceryShop> query = manager.createQuery("SELECT g FROM GroceryItem g", GroceryShop.class);
	        return query.getResultList();
	    }
	 
	 // search item by name
	 public List<GroceryShop> searchByName(String name) {
		    TypedQuery<GroceryShop> query = manager.createQuery("SELECT g FROM GroceryItem g WHERE g.name LIKE :name", GroceryShop.class);
		    query.setParameter("name", "%" + name + "%");
		    return query.getResultList();
	 }
	

}
