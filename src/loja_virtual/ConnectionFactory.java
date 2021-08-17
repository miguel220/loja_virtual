package loja_virtual;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	
	public DataSource dataSource;

	public ConnectionFactory() {
		//conexão ao banco de dados
		ComboPooledDataSource combo = new ComboPooledDataSource();
		combo.setJdbcUrl("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC");
		combo.setUser("root");
		combo.setPassword("@Miguel012");
		
		this.dataSource = combo;
		
	}

	public Connection recuperarConexao() throws SQLException {
		return this.dataSource.getConnection();
	}

}
