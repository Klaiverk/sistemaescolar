import java.sql.*;
import java.util.*;


public class conexaoBC {

		public static void insertBanco(String comando, String[] dados){

	        String url = "jdbc:mysql://localhost:3306/restaurante";
	        String username = "root";
	        String password = "";

	        String sql = comando;

	        try (Connection connection = DriverManager.getConnection(url, username, password);
	             PreparedStatement statement = connection.prepareStatement(sql)) {

	            statement.setString(1, dados[0]);
	            statement.setString(2, dados[1]);
	            statement.setString(3, dados[2]);

	            int rowsInserted = statement.executeUpdate();

	            if (rowsInserted > 0) {
	            	System.out.println("Inserção realizada com sucesso!");
	            } else {
	            	System.out.println("Falha ao inserir os dados.");
	            }

	        } catch (SQLException e) {
	        	System.out.println("Ocorreu um erro ao conectar ou executar a consulta: "+ e.getMessage());
	        }
	    }
}