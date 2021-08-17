package loja_virtual;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();
		try (Connection conec = factory.recuperarConexao()) {
			conec.setAutoCommit(false);

			try (PreparedStatement stm = conec.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)",
					Statement.RETURN_GENERATED_KEYS)) {

				adicionarVariavel("Suco", "Suco de laranja", stm);

				conec.commit();

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("ROLLBACK EXECUTADO");
				conec.rollback();
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
				System.out.println("O id criado foi: " + id);
			}

		}
	}

}
