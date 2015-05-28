package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistencia.ClienteDao;

import datautil.ConversaoData;

import entidade.Cliente;


@WebServlet("/controlecliente")
public class ControleCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	ClienteDao cd = null;
	
    public ControleCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		verificarAcao(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		verificarAcao(request, response);
	}

	protected void verificarAcao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");

		if (cd == null) {
			cd = new ClienteDao();
		}
		
		if (acao.equalsIgnoreCase("cadastro")) {
			cadastrarCliente(request, response);
		} else if (acao.equalsIgnoreCase("consulta")) {
			consultarClientes(request, response);
		} else if (acao.equalsIgnoreCase("excluir")) {
			excluirCliente(request, response);
		} else if (acao.equalsIgnoreCase("editar")) {
			editarCliente(request, response);
		} else if (acao.equalsIgnoreCase("alterar")) {
			alterarCliente(request, response);
		}else if(acao.equals("consultaclientepedido")){
			consultarClienteCadastroPedidos(request, response);
		}
	}
	
	protected void cadastrarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			/*Cliente c = new Cliente(null, 
					request.getParameter("nome"), 
					request.getParameter("email"), 
					request.getParameter("cpf"), 
					request.getParameter("sexo"), 
					new ConversaoData().dataParaJava(request.getParameter("dtnasc")));
			*/
			//c.setEndereco(e);
			
			Cliente cliente = new Cliente(request.getParameter("nome"),
					Integer.parseInt(request.getParameter("codigo")));
			
			
			cd.create(cliente);
			
			request.setAttribute("msg", "Cliente cadastrado com sucesso.");
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "Erro: " + e.getMessage());
		}
		request.getRequestDispatcher("cadastrocliente.jsp").forward(request, response);
	}
	
	protected void consultarClientes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			request.setAttribute("listaCliente", cd.findAll());
			request.getRequestDispatcher("consultacliente.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "Erro: " + e.getMessage());
			request.getRequestDispatcher("cadastrocliente.jsp").forward(request, response);
		}	
		
	}
	
	protected void consultarClienteCadastroPedidos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			request.setAttribute("listaCliente", cd.findAll());
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "Erro: " + e.getMessage());
		}
		request.getRequestDispatcher("cadastropedido.jsp").forward(request, response);
	}

	protected void excluirCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			Integer id = Integer.parseInt(request.getParameter("id"));
			Cliente cli = cd.findById(id);
			cd.delete(cli);
			request.setAttribute("msg", "Cliente excluido com sucesso.");
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "Erro: " + e.getMessage());
		}	
		consultarClientes(request, response);
	}

	protected void editarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Integer id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("cliente", cd.findById(id));
			request.getRequestDispatcher("editar.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "Erro: " + e.getMessage());
			request.getRequestDispatcher("cadastro.jsp").forward(request, response);
		}	
		
	}
	
	protected void alterarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			/*Cliente c = new Cliente(Integer.parseInt(request.getParameter("idcli")), 
					request.getParameter("nome"), 
					request.getParameter("email"), 
					request.getParameter("cpf"), 
					request.getParameter("sexo"), 
					new ConversaoData().dataParaJava(request.getParameter("dtnasc")));
			*/
			
			//c.setEndereco(e);
			//cd.update(c);
			
			request.setAttribute("msg", "Cliente alterado com sucesso.");
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "Erro: " + e.getMessage());
		}
		consultarClientes(request, response);
	}
}
