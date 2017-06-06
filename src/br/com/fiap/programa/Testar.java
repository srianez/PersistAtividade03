package br.com.fiap.programa;

import java.util.Date;
import java.util.List;


import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Caminhao;
import br.com.fiap.entity.Entrega;
import br.com.fiap.entity.Transportadora;


public class Testar {

	public static void main(String[] args) {

		//carrega transportadora
		Transportadora transportadora = new Transportadora();
		transportadora.setNome("TransFiap");
		
		//carrega objeto caminhao
		Caminhao caminhao = new Caminhao();
		
		caminhao.setPlaca("GGB-7174");
		caminhao.setTransportadora(transportadora);
		
		Entrega entrega = new Entrega();
		entrega.setCaminhao(caminhao);
		entrega.setNomeItem("Notebook Dell");

		GenericDao<Transportadora> daoTrans = new GenericDao<Transportadora>(Transportadora.class);
		GenericDao<Caminhao> daoCam = new GenericDao<Caminhao>(Caminhao.class);
		GenericDao<Entrega> daoEnt = new GenericDao<Entrega>(Entrega.class);

		daoTrans.adicionar(transportadora); //insere a transportadora
		System.out.println("Transportadora " + transportadora.getNome() +" adicionada");
		
		daoCam.adicionar(caminhao); //insere o caminhao
		System.out.println("Caminhao " + caminhao.getPlaca() +" adicionado");
		
		daoEnt.adicionar(entrega); //insere a entrega 
		System.out.println("Entrega do item " + entrega.getNomeItem()+" adicionada");
    

		
//		// Recuperar clientes
//		List<Transportadora> lisclientes = daoCli.listar();
//		for (Transportadora cliente : lisclientes) {
//			System.out.println("Result dao.listar = " + cliente.getNome() + " - " + cliente.getEmail());
//		}
//
//
//
//		// Busca cliente pelo ID
//		Transportadora x = new Transportadora();
//		x = (Transportadora) daoCli.buscar(1);
//		System.out.println("Result por id: " + x.getIdcliente() + " - " + x.getNome());
//		
//		System.out.println("Atualizando cliente.");
//		daoCli.atualizar(clientes);
//
//		System.out.println("Removendo pedido.");
//		daoPed.remover(pedidos);
//		
//		System.out.println("Removendo cliente.");
//		daoCli.remover(clientes);

	}


}
