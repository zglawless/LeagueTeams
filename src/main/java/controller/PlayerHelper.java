package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Players;


public class PlayerHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("LeagueTeams");
	
	public void insertPlayer(Players p) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Players> showAllPlayers() {
		EntityManager em = emfactory.createEntityManager();
		List<Players> allPlayers = em.createQuery("SELECT p FROM Players p").getResultList();
		return allPlayers;
	}
	
	public void deletePlayer (Players toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Players> typedQuery = em.createQuery("select p from Players p where p.name = :selectedName and p.number = :selectedNumber and p.startdate = :selectedStartDate", Players.class);
		typedQuery.setParameter("selectedName", toDelete.getName());
		typedQuery.setParameter("selectedNumber", toDelete.getNumber());
		typedQuery.setParameter("selectedStartDate", toDelete.getStartDate());
		typedQuery.setMaxResults(1);
		Players result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public Players searchForPlayerById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Players found = em.find(Players.class, idToEdit);
		em.close();

		return found;
	}
	
	public void updatePlayers(Players toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public List<Players> searchForPlayerByName(String name) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Players> typedQuery = em.createQuery("select p from Players p where p.name = :selectedName", Players.class);
		typedQuery.setParameter("selectedName", name);
		List<Players> foundPlayer = typedQuery.getResultList();
		em.close();

		return foundPlayer;
	}
	
	public void cleanUp() {
		emfactory.close();
	}

}
