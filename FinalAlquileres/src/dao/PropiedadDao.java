package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Propiedad;

public class PropiedadDao {
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

	public int agregar(Propiedad objeto) {
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

	public void actualizar(Propiedad objeto) throws HibernateException {
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

	public void eliminar(Propiedad objeto) throws HibernateException {
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

	public Propiedad traer(long idPropiedad){
		Propiedad objeto = null;
		try {
			iniciaOperacion();
			objeto = (Propiedad) session.get(Propiedad.class, idPropiedad);
		} finally {
			session.close();
		}
		return objeto;
	}

	public List<Propiedad> traer() {
		List<Propiedad> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Propiedad p order by p.precioBase asc").list();
		} finally {
			session.close();
		}
		return lista;
	}

	public List<Propiedad> traer(boolean tieneAscensor) {
		List<Propiedad> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Departamento d where d.tieneAscensor = " + tieneAscensor).list();
		} finally {
			session.close();
		}
		return lista;
	}
	
	
}