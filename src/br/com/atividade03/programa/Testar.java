package br.com.atividade03.programa;

import java.util.Date;
import java.util.List;

import br.com.atividade03.dao.GenericDao;
import br.com.fiap.entity.Caminhao;
import br.com.fiap.entity.Transportadoras;

public class Testar {

	public static void main(String[] args) {

		Transportadoras clientes = new Transportadoras();
		clientes.setNome("Mario Kart");
		clientes.setEmail("xxxxxxx@gmail.com");

		GenericDao<Transportadoras> daoCli = new GenericDao<Transportadoras>(Transportadoras.class);
		GenericDao<Caminhao> daoPed = new GenericDao<Caminhao>(Caminhao.class);

		daoCli.adicionar(clientes);

		System.out.println("=================================================================================");
		System.out.println("Cliente " + clientes.getNome() +" adicionado");
		System.out.println("=================================================================================");

	    Caminhao pedidos = new Caminhao();
	    pedidos.setClientes(clientes);
	    pedidos.setData(new Date());
	    pedidos.setDescricao("Celular Iphone 8");
	    pedidos.setValor(9.999);
	    
	    daoPed.adicionar(pedidos);

		System.out.println("=================================================================================");
		System.out.println("Pedido " + pedidos.getIdpedido() +" adicionado para o cliente " + pedidos.getClientes().getNome());
		System.out.println("=================================================================================");	    
		
		
		System.out.println("Executando o método listar...");
		
		// Recuperar clientes
		List<Transportadoras> lisclientes = daoCli.listar();
		for (Transportadoras cliente : lisclientes) {
			System.out.println("Result dao.listar = " + cliente.getNome() + " - " + cliente.getEmail());
		}


		System.out.println("=================================================================================");
		System.out.println("Buscando Cliente Pelo ID: ");
		System.out.println("=================================================================================");	

		// Busca cliente pelo ID
		Transportadoras x = new Transportadoras();
		x = (Transportadoras) daoCli.buscar(1);
		System.out.println("Result por id: " + x.getIdcliente() + " - " + x.getNome());
		
		System.out.println("Atualizando cliente.");
		daoCli.atualizar(clientes);

		System.out.println("Removendo pedido.");
		daoPed.remover(pedidos);
		
		System.out.println("Removendo cliente.");
		daoCli.remover(clientes);

	}


}
