package lojaVirtual;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connFactory = new ConnectionFactory();
		try (Connection conn = connFactory.recuperaConexao()) {
			conn.setAutoCommit(false);

			try (PreparedStatement stm = conn.prepareStatement("INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES (?,?)",
					Statement.RETURN_GENERATED_KEYS);) {

				adicionarVariavel("Copo", "Copo Coca cola", stm);
				adicionarVariavel("TV", "45 Polegadas", stm);

				conn.commit();

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Rollback foi executado!");
				conn.rollback();
			}
		}
	}

	private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
		stm.setString(1, nome);
		stm.setString(2, descricao);

		stm.execute();

		try (ResultSet rst = stm.getGeneratedKeys()) {
			while (rst.next()) {
				Integer id = rst.getInt(1);

				System.out.println("O Id criado foi: " + id);
			}
		}
	}

}
