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
}
