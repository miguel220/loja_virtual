package loja_virtual;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestaListaCategoria {

	public static void main(String[] args) throws SQLException {
		
		
		try(Connection con = new ConnectionFactory().recuperarConexao()) {
            List<Categoria> categorias = new CategoriaDao(con).listaComProduto();
            for(Categoria categoria : categorias) {
                System.out.println(categoria.getNome());

                for(Produto produto : categoria.getProdutos()) {
                    System.out.println(categoria.getNome() + " - " + produto.getNome());
					}
				
				};
		}
		
		

	}

}
