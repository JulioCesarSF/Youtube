package br.com.julio.Conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public final class ConexaoFactory {

	private static ConexaoFactory conexao = null;
	
	public ConexaoFactory(){}
	
	public static ConexaoFactory getInst(){
		if(conexao == null){
			conexao = new ConexaoFactory();
		}		
		return conexao;
	}
	
	public Connection getConnection(String usuario, String senha) throws Exception{
		//endere�o para o seu servidor
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		
		//configurar o driver para o seu banco de dados
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		return DriverManager.getConnection(url, usuario, senha);
	}
	
}
