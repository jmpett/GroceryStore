package controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.Item;

public class ItemDao {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("grocerystore");

	public void cleanUp() {
		emfactory.close();
	}
	
	public void deleteItem(Item toDelete) { //<==== Needs looked at
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Item> typedQuery = em.createQuery("select i from Item i where i.item = :selectedItem and i.department = :selectedDepartment",Item.class);
		typedQuery.setParameter("selectedItem", toDelete.getItem());
		typedQuery.setParameter("selectedDepartment", toDelete.getDepartment());
		typedQuery.setMaxResults(1);
		Item result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public void insertItem(Item toInsert) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toInsert);
		em.getTransaction().commit();
		em.close();
	}

	public void updateItem(Item toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public List<Item> showAllItems() {
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Item> typedQuery = em.createQuery("select i from Item i", Item.class);
		List<Item> foundTeams = typedQuery.getResultList();
		em.close();
		return foundTeams;
	}
	
	public List<Item> showAllMeat(){
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Item> typedQuery = em.createQuery("select i from Item i where i.department = 'Meat'", Item.class);
		List<Item> foundTeams = typedQuery.getResultList();
		em.close();
		return foundTeams;
	}
	
	public List<Item> showAllProduce(){
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Item> typedQuery = em.createQuery("select i from Item i where i.department = 'Produce'", Item.class);
		List<Item> foundTeams = typedQuery.getResultList();
		em.close();
		return foundTeams;
	}
	
	public List<Item> showAllAlcohol(){
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Item> typedQuery = em.createQuery("select i from Item i where i.department = 'Alcohol'", Item.class);
		List<Item> foundTeams = typedQuery.getResultList();
		em.close();
		return foundTeams;
	}
	
	public Item searchForItemByItemID(int id) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Item found = em.find(Item.class, id);
		em.close();
		return found;
	}
}