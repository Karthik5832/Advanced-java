package com.jsp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.GroceryServices.GroceryService;
import com.jsp.dto.GroceryShop;

@Controller
public class GroceryShopController {
    @Autowired
    private GroceryService service;
    
  
    @RequestMapping("/")
    public ModelAndView showHomePage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home"); // Set the view name to home.jsp
        return modelAndView; // Return the ModelAndView object
    }

    // Show form to add a new grocery item
    @RequestMapping("/add")
    public ModelAndView showAddForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("groceryShop", new GroceryShop()); // Add the model attribute
        modelAndView.setViewName("addItem"); // Set the view name
        return modelAndView; // Return the ModelAndView object
    }

    // Save the new grocery item
    @RequestMapping("/save")
    public String addGroceryItem(@ModelAttribute("groceryShop") GroceryShop item) {
        service.addGroceryItem(item);
        return "redirect:/products"; // Redirect to product list after saving
    }

    // Display all grocery items
    @RequestMapping("/products")
    public ModelAndView displayAllProducts() {
        List<GroceryShop> products = service.getAllProducts();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("productList"); // Set the view name
        modelAndView.addObject("products", products); // Add the model attribute
        return modelAndView; // Return the ModelAndView object
    }

    // Search for grocery items
    @RequestMapping("/search")
    public ModelAndView searchProducts(@ModelAttribute("groceryShop") GroceryShop item) {
        List<GroceryShop> results = service.searchProducts(item.getName());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("searchResults"); // Set the view name
        modelAndView.addObject("results", results); // Add the model attribute
        return modelAndView; // Return the ModelAndView object
    }

    // Purchase a grocery item
    @RequestMapping("/purchase")
    public ModelAndView purchaseProduct(@ModelAttribute("groceryShop") GroceryShop item) {
        String bill = service.purchaseProduct(item.getId(), item.getStockQuantity());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("bill"); // Set the view name
        modelAndView.addObject("message", bill); // Add the model attribute
        return modelAndView; // Return the ModelAndView object
    }
}
