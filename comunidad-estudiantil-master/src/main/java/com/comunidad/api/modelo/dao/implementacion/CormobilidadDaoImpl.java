package com.comunidad.api.modelo.dao.implementacion;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.comunidad.api.modelo.dao.interfaz.ICormobilidadDao;
import com.comunidad.api.modelo.entidad.Basico;
import com.comunidad.api.modelo.entidad.Cormobilidad;

@Repository
public class CormobilidadDaoImpl implements ICormobilidadDao {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Cormobilidad> findAll() {
		return em.createQuery("from Cormobilidad").getResultList();
	}

	@Override
	public void save(Cormobilidad cormobilidad) {
		if (cormobilidad.getId() != null) {
			em.merge(cormobilidad);
		} else {
			em.persist(cormobilidad);
		}
	}

	@Override
	public Cormobilidad findById(Basico id) {
		return em.find(Cormobilidad.class, id);
	}

	@Override
	public void deleteById(Basico id) {
		em.remove(findById(id));
	}

}
