package br.com.frezza.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.frezza.model.bean.Pessoa;
import br.com.frezza.model.bean.Placa;
import br.com.frezza.model.bean.Veiculo;
import br.com.frezza.model.repository.JPAUtil;

public class TesteInsereDoisVeiculoParaUmaPessoa {

	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		transaction.begin();
		
		Pessoa p = new Pessoa();
		p.setNome("Henrique");
		List<Veiculo> veiculos = new ArrayList<>();
		Veiculo v1 = new Veiculo();
		v1.setAno("1991");
		v1.setCor("verde");
		v1.setMarca("subaru");
		v1.setModelo("impreza");
		Placa p1 = new Placa();
		p1.setCidade("Tokyo");
		p1.setIdentificador("xrs-1265");
		v1.setPlaca(p1);
		Veiculo v2 = new Veiculo();
		v2.setAno("2011");
		v2.setCor("azul");
		v2.setMarca("gm");
		v2.setModelo("corsa");
		Placa p2 = new Placa();
		p2.setCidade("São Bernardo");
		p2.setIdentificador("asf-3451");
		v2.setPlaca(p2);
		veiculos.add(v1);
		veiculos.add(v2);
		p.setVeiculos(veiculos);
		manager.persist(p);

		transaction.commit();

		manager.close();
		JPAUtil.close();

	}

}
