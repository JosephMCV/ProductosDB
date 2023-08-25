/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.SQLException;
import models.Product;
import services.ServiceProducts;

/**
 *
 * @author david
 */
public class ControllerCreateProduct {

    public ControllerCreateProduct() {
    }
    
    public void createProduct(Product product) throws SQLException{
        Object[] values = {product.getCode(), product.getName(), product.getPrice(), product.getCategory(), product.getDistributor()};
        ServiceProducts.getINSTANCE().createProduct(values);
    }
    
}
