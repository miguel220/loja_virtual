package loja_virtual;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestaListaCategoria {

	public static void main(String[] args) throws SQLException {
		
		
		try(Connection conec = new ConnectionFactory().recuperarConexao()){
			
			CategoriaDao categoriaDao = new CategoriaDao(conec);
			
			List<Categoria> categorias = categoriaDao.listaComProduto();
			categorias.stream().forEach(ct -> {
				System.out.println(ct.getNome());
				
					for(Produto produto : ct.getProdutos()) {
						System.out.println(ct.getNome() + " - " + produto.getNome());
					}
				
				});
		}
		
		

	}

}
