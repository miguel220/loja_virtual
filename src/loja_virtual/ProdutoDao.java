package loja_virtual;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDao {

	
	private Connection conec;
	
	
	public ProdutoDao(Connection conec) {
		this.conec = conec;
			
	}
	
	public void salvar(Produto produto) throws SQLException {
		
		String sql = "INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES (?, ?)";
		
		try(PreparedStatement pstm = conec.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			
			
			pstm.setString(1, produto.getNome());
			pstm.setString(2, produto.getDescricao());
			
			pstm.execute();
			
			try(ResultSet rst = pstm.getGeneratedKeys()){
				while(rst.next()) {
					produto.setId(rst.getInt(1));
				}
			}
			
		}
		
	}
	
	public List<Produto> listar() throws SQLException{
		List<Produto> produtos = new ArrayList<Produto>();
		
		String sql = "SELECT ID, NOME, DESCRICAO FROM PRODUTO";
		
		try(PreparedStatement pst = conec.prepareStatement(sql)){
			
			pst.execute();
			
			try(ResultSet rst = pst.getResultSet()){
				while(rst.next()) {
				Produto produto =	
						new Produto(rst.getInt(1), rst.getString(2), rst.getString(3));
				
				produtos.add(produto);
				}
			}
		}
		return produtos;
	}

	public List<Produto> busca(Categoria ct) throws SQLException {
		List<Produto> produtos = new ArrayList<Produto>();
		
		String sql = "SELECT ID, NOME, DESCRICAO FROM PRODUTO WHERE CATEGORIA_ID = ?";
		
		try(PreparedStatement pst = conec.prepareStatement(sql)){
			
			pst.setInt(1, ct.getId());
			
			pst.execute();
			
			try(ResultSet rst = pst.getResultSet()){
				while(rst.next()) {
				Produto produto =	
						new Produto(rst.getInt(1), rst.getString(2), rst.getString(3));
				
				produtos.add(produto);
				}
			}
		}
		return produtos;
	}
}
