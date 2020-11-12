package app.model.entity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name = "Processos")
public class Processos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
	@Column(name = "id",unique=true, nullable = false)
    private Long id;
 
	@Column
    private String nuPub;
 
	@Column
    private String nuPedido;
 
	@Column
    private Date dtPublic;
	
	@Column
    private String requerentes;
    
	@Column
    private String titulo;
	
	@Column
    private String nuProcesso;
    
	
	public String getNuProcesso() {
		return nuProcesso;
	}

	public void setNuProcesso(String nuProcesso) {
		this.nuProcesso = nuProcesso;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNuPub() {
		return nuPub;
	}

	public void setNuPub(String nuPub) {
		this.nuPub = nuPub;
	}

	public String getNuPedido() {
		return nuPedido;
	}

	public void setNuPedido(String nuPedido) {
		this.nuPedido = nuPedido;
	}

	public Date getDtPublic() {
		return dtPublic;
	}

	public void setDtPublic(Date dtPublic) {
		this.dtPublic = dtPublic;
	}

	public String getRequerentes() {
		return requerentes;
	}

	public void setRequerentes(String requerentes) {
		this.requerentes = requerentes;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}
