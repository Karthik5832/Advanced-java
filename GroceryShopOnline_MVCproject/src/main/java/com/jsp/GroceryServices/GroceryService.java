package com.jsp.GroceryServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.dao.GroceryShopdao;
import com.jsp.dto.GroceryShop;

@Service
public class GroceryService {
    
    @Autowired
    private GroceryShopdao dao;

    public void addGroceryItem(GroceryShop item) {
        dao.insertEmployee(item);
    }

    public List<GroceryShop> getAllProducts() {
        return dao.findAll();
    }

    public List<GroceryShop> searchProducts(String name) {
        return dao.searchByName(name);
    }

    public String purchaseProduct(int i, int quantity) {
        GroceryShop item = dao.searchGroceryShopItem(i);
        if (item != null && item.getStockQuantity() >= quantity) {
            item.setStockQuantity(item.getStockQuantity() - quantity);
            dao.insertEmployee(item); // Save the updated item
            return "Bill: " + (item.getPrice() * quantity);
        }
        return "Product not available";
    }
}