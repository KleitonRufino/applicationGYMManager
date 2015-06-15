package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	public static Connection getConnection() {
		String url = "jdbc:postgresql://localhost:5432/gym_manager";
		String login = "postgres";
		String senha = "admin";
		try {
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection(url, login, senha);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

}