package dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Alquiler;

public class AlquilerDao {
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

	public int agregar(Alquiler objeto) {
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

	public void actualizar(Alquiler objeto) throws HibernateException {
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

	public void eliminar(Alquiler objeto) throws HibernateException {
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

	public Alquiler traer(int idAlquiler) {
		Alquiler objeto = null;
		try {
			iniciaOperacion();
			objeto = (Alquiler) session.get(Alquiler.class, idAlquiler);
			Hibernate.initialize(objeto.getPropiedad());
		} finally {
			session.close();
		}
		return objeto;
	}

	public List<Alquiler> traer() {
		List<Alquiler> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Alquiler a inner join fetch a.propiedad order by a.fechaDesde asc").list();
			
		} finally {
			session.close();
		}
		return lista;
	}

	public List<Alquiler> traer(LocalDate desde, LocalDate hasta){
		List<Alquiler> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Alquiler a inner join fetch a.propiedad where a.fechaDesde >= \"" + desde + "\" AND <= \"" +  hasta + "\"" ).list();
		} finally {
			session.close();
		}
		return lista;
	}
}
