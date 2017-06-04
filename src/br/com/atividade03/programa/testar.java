package br.com.atividade03.programa;

import java.util.List;

import javax.persistence.criteria.Order;

import br.com.atividade03.dao.GenericDao;
import br.com.atividade03.entity.Clientes;
import br.com.atividade03.utils.JpaUtil;

public class testar {

	public static void main(String[] args) {
		
		JpaUtil jpaUtil = new JpaUtil(); // e a unidade de persistência PersistAtividade03, conforme modelo comentado abaixo

		//EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersistAtividade03"); 
		//EntityManager em = entityManagerFactory.createEntityManager();		
		
		GenericDao dao = GenericDao(); 
		

		//alimenta objeto cliente para novo cadastro
		Clientes clientes = new Clientes();
		clientes.setNome("Silas Ianez");
		clientes.setEmail("silas@gmail.com");
		
		dao.adicionar(clientes);
		
		//Recuperar clientes 
		List<Clientes> lisclientes = dao.listar();
		
		//atualizar
		dao.atualizar(clientes);
		
		//remove
		dao.remover(clientes);
		
		Clientes x = new Clientes();
		
		x = (Clientes) dao.buscar(1);
		

	}

//	private static GenericDao GenericDao() {
//		// TODO Auto-generated method stub
//		return null;
//	}
		

	}


	
}
