package lojaVirtual;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemocao {
	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connFactory = new ConnectionFactory();
		Connection conn = connFactory.recuperaConexao();
		
		int id = 10;
		
		PreparedStatement stm = conn.prepareStatement("DELETE FROM PRODUTO WHERE ID = ?");
		
		stm.setInt(1, id);
		stm.execute();
		
		
		//Retorna quantas linhas foram afetadas pelo stm
		Integer linhasModificadas = stm.getUpdateCount();
		System.out.println("Quantidade de linhas excluidas: " + linhasModificadas);
		
	}

}
