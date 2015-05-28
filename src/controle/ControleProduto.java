package controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistencia.ProdutoDao;

import entidade.Produto;



@WebServlet("/controleproduto")
public class ControleProduto extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	ProdutoDao produtoDao = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		verificarAcao(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		verificarAcao(request, response);
	}
	
	private void verificarAcao(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		if(produtoDao == null){
			produtoDao = new ProdutoDao();
		}
		
		if(acao.equals("cadastro")){
			cadastrarProduto(request, response);
		}else if(acao.equals("consulta")){
			consultarProduto(request, response);
		}
		
	}

	private void consultarProduto(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("listaProduto", produtoDao.findAll());
			request.getRequestDispatcher("consultaproduto.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "Erro: " + e.getMessage());
			request.getRequestDispatcher("cadastroproduto.jsp").forward(request, response);
		}
	}

	private void cadastrarProduto(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Produto produto = new Produto(request.getParameter("nome"),
					Double.parseDouble(request.getParameter("valor")),
					Integer.parseInt(request.getParameter("quantidade")));
			
			produtoDao.create(produto);
			
			request.setAttribute("msg", "Produto Cadastrado com sucesso.");
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
		}
		
		request.getRequestDispatcher("cadastroproduto.jsp").forward(request, response);
		
	}
}
