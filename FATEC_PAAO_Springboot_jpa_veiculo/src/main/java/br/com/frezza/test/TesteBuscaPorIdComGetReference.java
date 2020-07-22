package br.com.frezza.test;

import javax.persistence.EntityManager;

import br.com.frezza.model.bean.Veiculo;
import br.com.frezza.model.repository.JPAUtil;

public class TesteBuscaPorIdComGetReference {

	public static void main(String[] args) {
		
		EntityManager manager = JPAUtil.getEntityManager();
		Veiculo v = manager.getReference(Veiculo.class,  1L);
		System.out.println(v);
		manager.close();
		JPAUtil.close();
	}

}
