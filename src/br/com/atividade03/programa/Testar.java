package br.com.atividade03.programa;

import java.util.Date;
import java.util.List;

import br.com.atividade03.dao.GenericDao;
import br.com.atividade03.entity.Clientes;
import br.com.atividade03.entity.Pedidos;

public class Testar {

	public static void main(String[] args) {

		Clientes clientes = new Clientes();
		clientes.setNome("Mario Kart");
		clientes.setEmail("xxxxxxx@gmail.com");

		GenericDao<Clientes> daoCli = new GenericDao<Clientes>(Clientes.class);
		GenericDao<Pedidos> daoPed = new GenericDao<Pedidos>(Pedidos.class);

		daoCli.adicionar(clientes);

		System.out.println("=================================================================================");
		System.out.println("Cliente " + clientes.getNome() +" adicionado");
		System.out.println("=================================================================================");

	    Pedidos pedidos = new Pedidos();
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
		List<Clientes> lisclientes = daoCli.listar();
		for (Clientes cliente : lisclientes) {
			System.out.println("Result dao.listar = " + cliente.getNome() + " - " + cliente.getEmail());
		}


		System.out.println("=================================================================================");
		System.out.println("Buscando Cliente Pelo ID: ");
		System.out.println("=================================================================================");	

		// Busca cliente pelo ID
		Clientes x = new Clientes();
		x = (Clientes) daoCli.buscar(1);
		System.out.println("Result por id: " + x.getIdcliente() + " - " + x.getNome());
		
		System.out.println("Atualizando cliente.");
		daoCli.atualizar(clientes);

		System.out.println("Removendo pedido.");
		daoPed.remover(pedidos);
		
		System.out.println("Removendo cliente.");
		daoCli.remover(clientes);

	}


}
