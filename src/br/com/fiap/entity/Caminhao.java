package br.com.fiap.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "caminhao", schema = "projetofinal")
public class Caminhao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cnpj")
	private Transportadoras transportadora;

	@Column(name = "placa", length = 45)
	private String placa;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Transportadoras getTransportadora() {
		return transportadora;
	}

	public void setTransportadora(Transportadoras transportadora) {
		this.transportadora = transportadora;
	}
}
