package br.com.felipe.docket.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Cartorio {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="nome")
	@NotBlank
	@Size(max=100)
	private String name;
	
	
	@Column(name="endereco")
	@NotBlank
	@Size(max=150)
	private String endereco;
	
	@Column(name="certidao")
	@NotBlank
	@Size(max=80)
	private String certidao;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCertidao() {
		return certidao;
	}
	public void setCertidao(String certidao) {
		this.certidao = certidao;
	}
	
	@Override
	public String toString() {
		
		return "Nome = " + this.name + "Endereço = " +  this.endereco + " Certidão = " + this.certidao;
	}
	
	
	
	

}
