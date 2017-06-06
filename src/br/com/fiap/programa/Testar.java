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
		transportadora.setNome("TransBonita");
		
		//carrega objeto caminhao
		Caminhao caminhao = new Caminhao();
		
		caminhao.setPlaca("ABC-9999");
		caminhao.setTransportadora(transportadora);
		
		//carrega objeto entrega
		Entrega entrega = new Entrega();
		
		entrega.setCaminhao(caminhao);
		entrega.setNomeItem("Carro Ferrari");

		GenericDao<Transportadora> daoTrans = new GenericDao<Transportadora>(Transportadora.class);
		GenericDao<Caminhao> daoCam = new GenericDao<Caminhao>(Caminhao.class);
		GenericDao<Entrega> daoEnt = new GenericDao<Entrega>(Entrega.class);

		daoTrans.adicionar(transportadora); //insere a transportadora
		System.out.println("Transportadora " + transportadora.getNome() +" adicionada");
		
		daoCam.adicionar(caminhao); //insere o caminhao
		System.out.println("Caminhao " + caminhao.getPlaca() +" adicionado");
		
		daoEnt.adicionar(entrega); //insere a entrega 
		System.out.println("Entrega do item " + entrega.getNomeItem()+" adicionada");
    
		
		System.out.println("========== Lista de caminhões cadastrados ==========");
		
		List<Caminhao> listcaminhao = daoCam.listar();
		for (Caminhao lcaminhao : listcaminhao) {
			System.out.println("Caminhão: " + lcaminhao.getPlaca());
		}
		
		System.out.println("====================================================");
		
		
		System.out.println("========== Lista de transportadoras cadastradas ==========");
		
		List<Transportadora> listTrans = daoTrans.listar();
		for (Transportadora lTransportadora : listTrans) {
			System.out.println("Transportadora: " + lTransportadora.getNome());
		}
		
		System.out.println("====================================================");

		
		System.out.println("================ Lista de entregas =================");
		List<Entrega> listEnt = daoEnt.listar();
		for (Entrega lEntrega : listEnt) {
			System.out.println("Entrega do item " + lEntrega.getNomeItem() + " efetuada pelo caminhão " +  lEntrega.getCaminhao().getPlaca()  +
					           " da transportadora " + lEntrega.getCaminhao().getTransportadora().getNome());
		}	
		System.out.println("====================================================");

		
		System.out.println("Atualizando Caminhão " + caminhao.getId() + " de placa " + caminhao.getPlaca());
		daoCam.atualizar(caminhao);

		System.out.println("Removendo entrega " + entrega.getIdEntrega()+ " do item " + entrega.getNomeItem() + " realizada pelo caminhão " + entrega.getCaminhao() );
		daoEnt.remover(entrega);

	}

}
