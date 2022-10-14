package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.RosterDetails;

public class RosterDetailsHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("LeagueTeams");
	
	public void insertNewRosterDetails(RosterDetails r) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(r);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<RosterDetails> getRosters(){
		EntityManager em = emfactory.createEntityManager();
		List<RosterDetails> allDetails = em.createQuery("SELECT r FROM RosterDetails r").getResultList();
		return allDetails;
	}
	
	public RosterDetails searchForRosterDetailsById(Integer tempId) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		RosterDetails found = em.find(RosterDetails.class, tempId);
		em.close();
		return found;
	}
	
	public void deleteRoster(RosterDetails rosterToDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<RosterDetails> typedQuery = em.createQuery("SELECT detail from RosterDetails detail where detail.id= :selectedId", RosterDetails.class);
		typedQuery.setParameter("selectedId", rosterToDelete.getId());
		
		typedQuery.setMaxResults(1);
		
		RosterDetails result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public void updateRoster(RosterDetails toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	
}
