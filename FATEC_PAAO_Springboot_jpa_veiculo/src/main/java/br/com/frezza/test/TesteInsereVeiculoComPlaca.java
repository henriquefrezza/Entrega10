package br.com.frezza.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.frezza.model.bean.Placa;
import br.com.frezza.model.bean.Veiculo;
import br.com.frezza.model.repository.JPAUtil;

public class TesteInsereVeiculoComPlaca {

	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		transaction.begin();

		Placa p = new Placa();
		p.setIdentificador("abc-1234");
		p.setCidade("Sao Paulo");
		manager.persist(p);
		Veiculo v = new Veiculo();
		v.setAno("2018");
		v.setCor("azul");
		v.setMarca("Honda");
		v.setModelo("Civic");
		v.setPlaca(p);
		
		manager.persist(v);

		transaction.commit();

		manager.close();
		JPAUtil.close();
	}

}
