package lojaVirtual;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class TestaInsercaoComProduto {

	public static void main(String[] args) throws SQLException {
		Produto comoda = new Produto("Comoda", "Comoda Vermelha");

		try (Connection connection = new ConnectionFactory().recuperaConexao()) {
			ProdutoDao produtoDao = new ProdutoDao(connection);

			List<Produto> listaDeProdutos = produtoDao.listar();
			listaDeProdutos.parallelStream().forEach(lp -> System.out.println(lp));
			
			
				// Insere um produto
//			produtoDao.salvar(comoda);
				//Printa o produto inserido
//		}
//		System.out.println(comoda);
		
		
		
//				Buscando por ID
//		try(Connection connection = new ConnectionFactory().recuperaConexao()) {
//			
//			ProdutoDao produtoDao = new ProdutoDao(connection);
//			produtoDao.buscaPorId(11);
//		}

	
	}
	}
}
