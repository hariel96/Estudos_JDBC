package lojaVirtual;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connFactory = new ConnectionFactory();
	
		Connection conn = connFactory.recuperaConexao();

		PreparedStatement stm = conn.prepareStatement("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
		stm.execute();
		ResultSet rst = stm.getResultSet();
		
		while(rst.next()) {
			Integer id = rst.getInt("ID");
			String nome = rst.getString("Nome");
			String descricao = rst.getString("Descricao");
			System.out.println(id+" "+nome+" "+descricao);
			
		}
		
	}

}
