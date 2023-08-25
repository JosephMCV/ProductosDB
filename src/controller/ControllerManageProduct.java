/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import models.Product;
import services.ServiceProducts;

/**
 *
 * @author david
 */
public class ControllerManageProduct {

    public ControllerManageProduct() {
    }
    
    public void updateProduct(Product product) throws SQLException{
        Object[] values = {product.getCode(), product.getName(), product.getPrice(), product.getCategory(), product.getDistributor()};
        ServiceProducts.getINSTANCE().updateProduct(values);
    }
    
    public int deleteProduct(String code) throws SQLException{
        int op = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar el producto?", "Ventana de confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(op==0){
            ServiceProducts.getINSTANCE().deleteProduct(code);
        }
        return op;
    }
}
