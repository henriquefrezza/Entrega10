package br.com.frezza.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.frezza.model.bean.Placa;
import br.com.frezza.model.repository.JPAUtil;

public class TesteRemovePlacaComVeiculoAssociado {

	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		transaction.begin();

		Placa p = manager.find(Placa.class, 1L);
		manager.remove(p);

		transaction.commit();

		manager.close();
		JPAUtil.close();
	}

}
