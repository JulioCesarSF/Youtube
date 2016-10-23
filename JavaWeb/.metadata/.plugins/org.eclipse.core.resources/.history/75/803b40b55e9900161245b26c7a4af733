package br.com.julio.BO;

import java.sql.Connection;
import java.util.List;

import br.com.julio.DAO.ProdutoDAO;
import br.com.julio.beans.Produto;

//Na classe BO ficam as regras de negócio
//Os métodos devem seguir as regras (parametros) do DAO 
public abstract class ProdutoBO {

	public static void cadastrar(Produto produto, Connection con) throws Exception{
		//regra de negócio
		if(produto.getNome().length() < 2){
			throw new Exception("Nome inválido");
		}
		//Chamar o DAO correspondente para efetuar a operação no banco
		new ProdutoDAO().adicionar(produto, con);
	}
	
	public static List<Produto> listar(Connection con) throws Exception{
		return new ProdutoDAO().listar(con);
	}
	
}
