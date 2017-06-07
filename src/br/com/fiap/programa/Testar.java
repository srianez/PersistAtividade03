package br.com.fiap.programa;

import java.util.List;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Caminhao;
import br.com.fiap.entity.Entrega;
import br.com.fiap.entity.Transportadora;


public class Testar {

	public static void main(String[] args) {


		JTextField TransportadoraField = new JTextField(40);		
		JTextField CaminhaoField = new JTextField(20);	
		JTextField EntregaField = new JTextField(20);
	    //JTextField yField = new JTextField(5);

		//carrega transportadora
	    JPanel TransportadoraPanel = new JPanel();
	    TransportadoraPanel.add(new JLabel("Informe o nome da trasportadora:"));
	    TransportadoraPanel.add(TransportadoraField);
	    
	    //caso precise criar mais de um campo no mesmo panel (popup)
	    //myPanel.add(Box.createHorizontalStrut(15));
	    //myPanel.add(new JLabel("y:"));
	    //myPanel.add(yField);

	    //teste do valor imputado
	    //if (result == JOptionPane.OK_OPTION) {
	      //System.out.println("x value: " + TransportadoraField.getText());
	      //System.out.println("y value: " + yField.getText());
	    //}
	    
	    int result = JOptionPane.showConfirmDialog(null, TransportadoraPanel, "Transportadora", JOptionPane.OK_CANCEL_OPTION);
		
		Transportadora transportadora = new Transportadora();
		transportadora.setNome(TransportadoraField.getText());
	
	    
	    //carrega objeto caminhao
	    JPanel CaminhaoPanel = new JPanel();
	    CaminhaoPanel.add(new JLabel("Informe a placa do caminhão:"));
	    CaminhaoPanel.add(CaminhaoField);	
		int resultx = JOptionPane.showConfirmDialog(null, CaminhaoPanel, "Caminhão", JOptionPane.OK_CANCEL_OPTION);
		
	    Caminhao caminhao = new Caminhao();
		caminhao.setPlaca(CaminhaoField.getText());
		caminhao.setTransportadora(transportadora);
		
		
		//carrega objeto entrega
	    JPanel EntregaPanel = new JPanel();
	    EntregaPanel.add(new JLabel("Informe o Item da entrega:"));
	    EntregaPanel.add(EntregaField);	
		int resulty = JOptionPane.showConfirmDialog(null, EntregaPanel, "Entrega", JOptionPane.OK_CANCEL_OPTION);

	    Entrega entrega = new Entrega();
		
		entrega.setCaminhao(caminhao);
		entrega.setNomeItem(EntregaField.getText());

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
