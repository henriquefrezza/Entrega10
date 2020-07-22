package br.com.frezza.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.frezza.model.bean.Veiculo;
import br.com.frezza.model.repository.JPAUtil;

public class TesteInsereUmVeiculo {
	
	public static void main (String[] args) {
		
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		
		Veiculo v = new Veiculo();
		v.setModelo("corsa");
		v.setCor("prata");
		v.setMarca("GM");
		v.setAno("2009");
		
		manager.persist(v);
		
		transaction.commit();
		manager.close();
		JPAUtil.close();
	}
}
