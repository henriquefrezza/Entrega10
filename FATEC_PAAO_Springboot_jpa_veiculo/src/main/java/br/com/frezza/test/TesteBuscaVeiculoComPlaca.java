package br.com.frezza.test;

import javax.persistence.EntityManager;

import br.com.frezza.model.bean.Veiculo;
import br.com.frezza.model.repository.JPAUtil;

public class TesteBuscaVeiculoComPlaca {

	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();

		Veiculo v = manager.find(Veiculo.class, 3L);

		System.out.println(v);

		manager.close();
		JPAUtil.close();
	}

}
