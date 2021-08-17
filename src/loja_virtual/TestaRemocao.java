package loja_virtual;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory factory = new ConnectionFactory();
		Connection conec = factory.recuperarConexao();
		
		PreparedStatement stm = conec.prepareStatement("DELETE FROM PRODUTO WHERE ID > ?");
		
		stm.setInt(1, 1);
		stm.execute();
		
		Integer linhasModificadas = stm.getUpdateCount();
		
		System.out.println("Quantidades de linhas modificadas: " + linhasModificadas);

	}

}
