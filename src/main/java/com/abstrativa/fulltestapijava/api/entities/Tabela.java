package com.abstrativa.fulltestapijava.api.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import com.abstrativa.fulltestapijava.api.enums.StatusEnum;

@Entity
@Table(name = "Tabelas")
public class Tabela implements Serializable {

	private static final long serialVersionUID = -1311624377030793946L;

	
	private UUID id;
	private String nome;
	private Date atualizacao;
	private Date criacao;
	private Integer pagina;
	private BigDecimal valor;
	private String content;
    private byte[] foto;
	private StatusEnum status;
	
	/**
	 * 
	 */
	public Tabela() {
	}

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
		name = "UUID",
		strategy = "org.hibernate.id.UUIDGenerator"
	)
	@Column(name = "id", updatable = false, nullable = false)
	public UUID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(UUID id) {
		this.id = id;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the pagina
	 */
	public Integer getPagina() {
		return pagina;
	}

	/**
	 * @param pagina the pagina to set
	 */
	public void setPagina(Integer pagina) {
		this.pagina = pagina;
	}

	/**
	 * @return the valor
	 */
	public BigDecimal getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	/**
	 * @return the content
	 */
	@Lob 
	@Column(length=512)
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the foto
	 */
	@Lob
	public byte[] getFoto() {
		return foto;
	}

	/**
	 * @param foto the foto to set
	 */
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	/**
	 * @return the status
	 */
	@Enumerated(EnumType.STRING)
	public StatusEnum getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	/**
	 * @return the atualizacao
	 */
	@Temporal(TemporalType.TIMESTAMP)
	public Date getAtualizacao() {
		return atualizacao;
	}

	/**
	 * @param atualizacao the atualizacao to set
	 */
	public void setAtualizacao(Date atualizacao) {
		this.atualizacao = atualizacao;
	}

	/**
	 * @return the criacao
	 */
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCriacao() {
		return criacao;
	}

	/**
	 * @param criacao the criacao to set
	 */
	public void setCriacao(Date criacao) {
		this.criacao = criacao;
	}
	
	@PreUpdate
	public void preUpdate() {
		atualizacao = new Date();
	}
	
	public void prePersist() {
		final Date atual = new Date();
		criacao = atual;
		atualizacao = atual;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Tabela [id=");
		builder.append(id);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", atualizacao=");
		builder.append(atualizacao);
		builder.append(", criacao=");
		builder.append(criacao);
		builder.append(", pagina=");
		builder.append(pagina);
		builder.append(", valor=");
		builder.append(valor);
		builder.append(", content=");
		builder.append(content);
		builder.append(", foto=");
		builder.append(Arrays.toString(foto));
		builder.append(", status=");
		builder.append(status);
		builder.append("]");
		return builder.toString();
	}

}
