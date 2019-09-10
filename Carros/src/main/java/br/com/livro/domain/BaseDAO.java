package br.com.livro.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDAO {

	// URL de conexão com o banco de dados
	private static final String URL = "jdbc:mysql://localhost:3306/livro"; //?useTimezone=true&serverTimezone=UTC

	public BaseDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver"); // Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 8.0
		} catch (ClassNotFoundException e) {
			// Erro de driver JDBC (adicionar o driver .jar do MySQL em /WEB-INF/lib)
			e.printStackTrace();
		}
	}

	protected Connection getConnection() throws SQLException {
		// Conecta utilizando a URL, usuário e senha.
		Connection conn = DriverManager.getConnection(URL, "livro", "livro123");
		return conn;
	}

	public static void main(String[] args) throws SQLException {
		BaseDAO db = new BaseDAO();
		// Testa a conexão
		Connection conn = db.getConnection();
		System.out.println(conn);
	}
}
