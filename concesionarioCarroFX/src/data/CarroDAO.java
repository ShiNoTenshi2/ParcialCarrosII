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



	public ArrayList<Carro> fetchDisponibles() {
        ArrayList<Carro> carros = new ArrayList<>();

        return carros;
	}

	public ArrayList<Carro> fetchEliminados() {
        ArrayList<Carro> carros = new ArrayList<>();              
        
        return carros;
	}


	public void eliminar(int referencia) {

	}

	public void recuperar(int referencia) {

	}
	
	
	



}
