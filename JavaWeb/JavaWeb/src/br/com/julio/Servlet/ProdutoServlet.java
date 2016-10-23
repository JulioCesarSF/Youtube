package br.com.julio.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.julio.BO.ProdutoBO;
import br.com.julio.Conexao.ConexaoFactory;
import br.com.julio.beans.Produto;

//Servlet é o controller no caso
//Ele quem vai fazer a comunicação entre o JSP e o Back-end
//Ele herda a HttpServlet

//Deve-ser configurar o caminho do servlet, pode-se fazer pelo web.xml ou pela anotação

@WebServlet("/Produto")
@SuppressWarnings("serial")
public class ProdutoServlet extends HttpServlet{

	
	//doPost para cadastrar
	//página de cadastro é cadastro.jsp
	//doPost vem do formulário
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Esses parametros são o names no formulário na página JSP
		//Já faremos o formulário
		String nome = req.getParameter("nome");
		String valor = req.getParameter("valor");
		
		//Objeto Produto para cadastrar (deve ter um construtor adquado, vamos modificar)
		Produto produto = new Produto(nome, Double.parseDouble(valor));
		
		//Objeto Connection
		Connection con = null;
		
		try {
			//Abrir a conexão
			con = ConexaoFactory.getInst().getConnection("youtube", "1234");
			//Chamar o BO para validar a regra de negócio e efetuar
			//operação no banco chamando DAO
			ProdutoBO.cadastrar(produto, con);
			
			//adicionar uma mensagem de sucesso
			//vou usar bootstrap no jsp			
			req.setAttribute("tipoMensagem", "alert alert-success");
			req.setAttribute("mensagem", "Cadastro realizado com sucesso!");
			
		} catch (Exception e) {	
			//modificar de local para retornar a mensagem
			req.setAttribute("tipoMensagem", "alert alert-danger");
			req.setAttribute("mensagem", "Cadastro NÃO realizado!");
			e.printStackTrace();			
		}finally {
			//como abrimos uma conexão a mesma deve ser fechada
			try {
				if(con != null){
					con.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			
			}
			//efetuado o cadastro ou não mandamos para a tela cadastrar.jsp
			req.getRequestDispatcher("cadastrar.jsp").forward(req, resp);
		}
	}//já adicionaremos mais coisas para passar ao JSP, como uma msg de sucesso
	
	//doGet para listar
	//página para listar é listar.jsp
	//só lembrar, doGet vem de/pela URL
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//lista
		List<Produto> lista = null;
		
		Connection con = null;
		
		try{
			con = ConexaoFactory.getInst().getConnection("youtube", "1234");
			
			//recuperados a lista do banco
			lista = ProdutoBO.listar(con);
			
			//passamos a lista como atributo para o jsp
			req.setAttribute("lista", lista);
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(con != null){
					con.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			req.getRequestDispatcher("listar.jsp").forward(req, resp);
		}
		
		
	}
}
