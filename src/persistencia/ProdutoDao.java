package persistencia;

import java.util.List;

import jdk.nashorn.internal.runtime.ListAdapter;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entidade.Produto;

public class ProdutoDao {
	
	Session session = null;
	
	Transaction transaction = null;
	
	public void create(Produto produto) throws Exception{
		
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		
		session.save(produto);
		
		transaction.commit();
		session.close();
	}
	
	public List<Produto> findAll() throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();		
		List<Produto> listaProduto = session.createQuery("FROM Produto").list();
		session.close();
		return listaProduto;
	}
	
}
