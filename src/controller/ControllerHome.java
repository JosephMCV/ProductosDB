package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import models.Product;
import services.ServiceProducts;

public class ControllerHome {
    
    ArrayList<Object[]> products;

    public ControllerHome() throws SQLException {
    }

    public ArrayList<Object[]> getProducts() {
        return products;
    }       
    
    public ArrayList<Object[]> searchProducts(String code) throws SQLException{
        products = new ArrayList<>();
        try {
            ResultSet rs = ServiceProducts.getINSTANCE().searchProduct(code);
            int columnCount = rs.getMetaData().getColumnCount();
            while(rs.next()){
                Object[] filas = new Object[columnCount+1];
                for (int i = 0; i < columnCount; i++) {
                    filas[i] = rs.getObject(i+1);
                }
                products.add(filas);
            }
            return products;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de busqueda", "SQL error", JOptionPane.ERROR_MESSAGE);
            throw new SQLException("Error de busqueda");
        }
    }
    
    public Product manageProduct(String code) throws SQLException{
        try {
            ResultSet rs = ServiceProducts.getINSTANCE().searchProduct(code);
            int columnCount = rs.getMetaData().getColumnCount();
            Product product = new Product();
            while(rs.next()){
                Object[] filas = new Object[columnCount+1];
                for (int i = 0; i < columnCount; i++) {
                    filas[i] = rs.getObject(i+1);
                }
                product = new Product(filas[0].toString(), filas[1].toString(), Double.parseDouble(filas[2].toString()), filas[3].toString(), filas[4].toString());
            }
            return product;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de busqueda", "SQL error", JOptionPane.ERROR_MESSAGE);
            throw new SQLException("Error de busqueda");
        }
    }
    
}
