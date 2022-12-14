package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Teams;

public class TeamHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("LeagueTeams");
	
	public void insertTeam(Teams t) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Teams> showAllTeams(){
		EntityManager em = emfactory.createEntityManager();
		List<Teams> allTeams = em.createQuery("SELECT t FROM Teams t").getResultList();
		return allTeams;
	}
	
	public Teams findTeam(String nameToLookUp) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Teams> typedQuery = em.createQuery("select th from Teams th where th.teamName = :selectedName", Teams.class);
		
		typedQuery.setParameter("selectedName", nameToLookUp);
		typedQuery.setMaxResults(1);
		
		Teams foundTeam;
		
		try {
			foundTeam = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			foundTeam = new Teams(nameToLookUp);
		}
		em.close();
		
		return foundTeam;
	}
	
	public Teams searchForTeamById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Teams found = em.find(Teams.class, idToEdit);
		em.close();

		return found;
	}
	
	public void updateTeam(Teams toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public void deleteTeam (Teams toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Teams> typedQuery = em.createQuery("select t from Teams t where t.teamName = :selectedName", Teams.class);
		typedQuery.setParameter("selectedName", toDelete.getTeamName());
		typedQuery.setMaxResults(1);
		Teams result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
}
