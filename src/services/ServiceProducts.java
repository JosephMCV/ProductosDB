package services;

import connection.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.Product;
import org.mariadb.jdbc.Connection;

public class ServiceProducts {
    
    private static ServiceProducts INSTANCE = new ServiceProducts();
    
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private ConexionDB conn = new ConexionDB();
    private Connection con = conn.getConexion();  

    public ServiceProducts() {
    }

    public static ServiceProducts getINSTANCE() {
        return INSTANCE;
    } 
    
    public void createProduct(Object[] values) throws SQLException{
        try {
            String sql = "INSERT INTO `products`(`code`, `name`, `price`, `category`, `distribuitor`) VALUES ('"+ values[0] +"','"+ values[1] +"','"+ values[2] +"','"+ values[3] +"','"+ values[4] +"')";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            JOptionPane.showMessageDialog(null, "Se ha agregado el producto", "Producto añadido", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            throw new SQLException();
        }
    }
    
    public ResultSet searchProduct(String code) throws SQLException{
        String where = "";
        if(!"".equals(code)){
            where = "WHERE code = '" + code +"'";
        }try {
            String sql = "SELECT * FROM products " +where;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            throw new SQLException("Error de busqueda");
        }        
    }

    public void updateProduct(Object[] values) throws SQLException{
        try {
            String sql = "UPDATE `products` SET `code`='"+ values[0] +"',`name`='"+ values[1] +"',`price`='"+ values[2] +"',`category`='"+ values[3] +"',`distribuitor`='"+ values[4] +"' WHERE code = '"+ values[0] +"'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            JOptionPane.showMessageDialog(null, "Se ha actualizado el producto", "Producto editado", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            throw new SQLException();
        }
    }

    public void deleteProduct(String code) throws SQLException{
       try {
            String sql = "DELETE FROM `products` WHERE code = '"+code+"'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            JOptionPane.showMessageDialog(null, "Se ha eliminado el producto", "Producto eliminado", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            throw new SQLException();
        } 
    }
    
    public void deleteAll(Product producto){
        
    }

}
