package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Carro;


public class CarroDAO {
    private Connection connection;

    public CarroDAO(Connection connection) {
        this.connection = connection;
    }

    public ArrayList<Carro> fetchDisponible() {
        ArrayList<Carro> carros = new ArrayList<>(); 
        String sql = "SELECT * FROM Carro WHERE is_deleted=0";  
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) { 
            while (rs.next()) {  
                int referencia = rs.getInt("referencia");  
                String marca = rs.getString("marca");   
                String modelo = rs.getString("modelo");
                String color = rs.getString("color");   
                int cantidad = rs.getInt("cantidad");     

                Carro carro = new Carro(referencia, marca, modelo, color, cantidad);
                carros.add(carro); 
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
        return carros; 
    }

	public ArrayList<Carro> fetchEliminados() {
        ArrayList<Carro> carros = new ArrayList<>();              
        String sql = "SELECT * FROM Carro WHERE is_deleted=1";  
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) { 
            while (rs.next()) {  
                int referencia = rs.getInt("referencia");  
                String marca = rs.getString("marca");   
                String modelo = rs.getString("modelo");   
                String color = rs.getString("color");   
                int cantidad = rs.getInt("cantidad");     

                Carro carro = new Carro(referencia, marca, modelo, color, cantidad);
                carros.add(carro); 
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }

        return carros;
	}

	public void eliminar(int referencia) {
        String sql = "UPDATE Carro SET is_deleted=1 WHERE referencia=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, referencia);  
            stmt.executeUpdate(); 
        } catch (SQLException e) {
            e.printStackTrace();  
        }
    }


	public void recuperar(int referencia) {
        String sql = "UPDATE Carro SET is_deleted=0 WHERE referencia=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, referencia);  
            stmt.executeUpdate(); 
        } catch (SQLException e) {
            e.printStackTrace();  
        }
    }
	
	
	



}
