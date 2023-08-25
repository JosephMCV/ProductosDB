/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import java.sql.SQLException;
import views.Home;

/**
 *
 * @author david
 */
public class ProductosDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        Home homeWindow = new Home();
        homeWindow.setVisible(true);
    }
    
}
