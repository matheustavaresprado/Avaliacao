package app.model.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import app.model.entity.Processos;

public class ProcessosRepository {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("avaliacao");

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public void salvar(Processos processo) {
		EntityManager em = getEntityManager();

		em.getTransaction().begin();
		em.persist(processo);
		em.getTransaction().commit();
	}

	public List<Processos> buscar(String nuProcesso, String requerente) {
		EntityManager em = getEntityManager();
		List<Processos> processos = em.createQuery(
				"SELECT processos from Processos processos where processos.nuProcesso = ?1 and processos.requerentes = ?2")
				.setParameter(1, nuProcesso).setParameter(2, requerente).getResultList();
		
		return processos;
	}
}
