package br.com.frezza.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.frezza.model.bean.Veiculo;
import br.com.frezza.model.repository.JPAUtil;

public class TesteRemoveVeiculo {

	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		
		Veiculo v = manager.find(Veiculo.class,  1L);
		manager.remove(v);
		
		transaction.commit();
		
		manager.close();
		JPAUtil.close();
	}

}
