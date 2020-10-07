package application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		
		System.out.println("*-------------------------*");
		System.out.println("*          Start          *");
		System.out.println("*-------------------------*");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		Pessoa p = em.find(Pessoa.class, 2);
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		System.out.println(p);
		
		System.out.println();
		System.out.println("*-------------------------*");
		System.out.println("*          Done!          *");
		System.out.println("*-------------------------*");
		
		em.close();
		emf.close();
	}
}