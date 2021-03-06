package co.edu.usbcali.demo.modelo;
// Generated 6/05/2017 09:27:07 AM by Hibernate Tools 5.2.1.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Usuarios generated by hbm2java
 */
@Entity
@Table(name = "usuarios", schema = "public")
public class Usuarios implements java.io.Serializable {

	private long usuCedula;
	private TiposUsuarios tiposUsuarios;
	private String usuNombre;
	private String usuLogin;
	private String usuClave;
	private Set<Consignaciones> consignacioneses = new HashSet<Consignaciones>(0);
	private Set<Retiros> retiroses = new HashSet<Retiros>(0);

	public Usuarios() {
	}

	public Usuarios(long usuCedula, String usuNombre, String usuLogin, String usuClave) {
		this.usuCedula = usuCedula;
		this.usuNombre = usuNombre;
		this.usuLogin = usuLogin;
		this.usuClave = usuClave;
	}

	public Usuarios(long usuCedula, TiposUsuarios tiposUsuarios, String usuNombre, String usuLogin, String usuClave,
			Set<Consignaciones> consignacioneses, Set<Retiros> retiroses) {
		this.usuCedula = usuCedula;
		this.tiposUsuarios = tiposUsuarios;
		this.usuNombre = usuNombre;
		this.usuLogin = usuLogin;
		this.usuClave = usuClave;
		this.consignacioneses = consignacioneses;
		this.retiroses = retiroses;
	}

	@Id

	@Column(name = "usu_cedula", unique = true, nullable = false, precision = 10, scale = 0)
	public long getUsuCedula() {
		return this.usuCedula;
	}

	public void setUsuCedula(long usuCedula) {
		this.usuCedula = usuCedula;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tusu_codigo")
	public TiposUsuarios getTiposUsuarios() {
		return this.tiposUsuarios;
	}

	public void setTiposUsuarios(TiposUsuarios tiposUsuarios) {
		this.tiposUsuarios = tiposUsuarios;
	}

	@Column(name = "usu_nombre", nullable = false, length = 50)
	public String getUsuNombre() {
		return this.usuNombre;
	}

	public void setUsuNombre(String usuNombre) {
		this.usuNombre = usuNombre;
	}

	@Column(name = "usu_login", nullable = false, length = 30)
	public String getUsuLogin() {
		return this.usuLogin;
	}

	public void setUsuLogin(String usuLogin) {
		this.usuLogin = usuLogin;
	}

	@Column(name = "usu_clave", nullable = false, length = 50)
	public String getUsuClave() {
		return this.usuClave;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuarios")
	public Set<Consignaciones> getConsignacioneses() {
		return this.consignacioneses;
	}

	public void setConsignacioneses(Set<Consignaciones> consignacioneses) {
		this.consignacioneses = consignacioneses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuarios")
	public Set<Retiros> getRetiroses() {
		return this.retiroses;
	}

	public void setRetiroses(Set<Retiros> retiroses) {
		this.retiroses = retiroses;
	}

}
