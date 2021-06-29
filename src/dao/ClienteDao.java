package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Cliente;
import datos.Contacto;

public class ClienteDao {
	private static Session session;
	private Transaction tx;

	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}

	public int agregar(Cliente objeto) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return id;
	}
	
	public int agregarTodoJunto(Cliente objeto) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			Contacto contacto = objeto.getContacto();//  SE AGREGAN ESTAS LINEAS PARA QUE AGREGUE AL CLIENTE Y SU CONTACTO "AL MISMO TIEMPO"
			contacto.setCliente(objeto);//
			session.save(objeto.getContacto());//
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return id;
	}

	public void actualizar(Cliente objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}

	public void eliminar(Cliente objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}

	public Cliente traer(long idCliente) throws HibernateException {
		Cliente objeto = null;
		try {
			iniciaOperacion();
			objeto = (Cliente) session.get(Cliente.class, idCliente);
		} finally {
			session.close();
		}
		return objeto;
	}

	public Cliente traer(int dni) throws HibernateException {
		Cliente objeto = null;
		try {
			iniciaOperacion();
			objeto = (Cliente) session.createQuery("from Cliente c where c.dni=" + dni).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> traer() throws HibernateException {
		List<Cliente> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Cliente c").list();
		} finally {
			session.close();
		}
		return lista;
	}

	public Cliente traerClienteYContacto(long idCliente) throws HibernateException {
		Cliente objeto = null;
		try {
			iniciaOperacion();
			//String hql = "from Cliente c inner join fetch c.contacto where c.idCliente =" + idCliente;
			String hql="from Cliente c where c.idCliente="+idCliente;
			objeto = (Cliente) session.createQuery(hql).uniqueResult();
			Hibernate.initialize(objeto.getContacto());
		} finally {
			session.close();
		}
		return objeto;
	}
}