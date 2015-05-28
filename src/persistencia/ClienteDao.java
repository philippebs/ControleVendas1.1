package persistencia;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entidade.Cliente;

public class ClienteDao {

	// Session - Controle de acesso ao BD.
	Session session;

	// Session - Controle de Transa��o.
	Transaction transaction;

	public void create(Cliente c) throws Exception {

		// Abrir a sess�o de acesso ao BD.
		session = HibernateUtil.getSessionFactory().openSession();

		// Iniciando uma transa��o.
		transaction = session.beginTransaction();

		// A��o(Inserir) realizada no BD.
		session.save(c);

		// Confirmar a transa��o.
		transaction.commit();

		// Fechar a sess�o de acesso ao BD.
		session.close();
	}

	public void update(Cliente c) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.update(c);
		transaction.commit();
		session.close();
	}

	public void delete(Cliente c) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.delete(c);
		transaction.commit();
		session.close();
	}

	public List<Cliente> findAll() throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		// HQL(Hibernate Query Language) - Consultas realizadas na Classe.
		List<Cliente> lista = session.createQuery("from Cliente").list();
		session.close();
		return lista;
	}

	public Cliente findById(Integer id) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		Cliente c = (Cliente) session.get(Cliente.class, id);
		session.close();
		return c;
	}

}
