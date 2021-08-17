package loja_virtual;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestaInsercaoComProduto {

	public static void main(String[] args) throws SQLException {
		
		
		Produto comoda = new Produto("comoda", "comoda de quarto");
		
		try(Connection conec = new ConnectionFactory().recuperarConexao()){
			
		ProdutoDao produtoDao = new ProdutoDao(conec);
		produtoDao.salvar(comoda);
		List<Produto> listaProdutos = produtoDao.listar();
		listaProdutos.stream().forEach(lp -> System.out.println(lp));
		}
		
		System.out.println(comoda);
		

	}

}
