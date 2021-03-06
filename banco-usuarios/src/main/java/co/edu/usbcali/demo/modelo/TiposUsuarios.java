package co.edu.usbcali.demo.modelo;
// Generated 6/05/2017 09:27:07 AM by Hibernate Tools 5.2.1.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TiposUsuarios generated by hbm2java
 */
@Entity
@Table(name = "tipos_usuarios", schema = "public")
public class TiposUsuarios implements java.io.Serializable {

	private long tusuCodigo;
	private String tusuNombre;
	private Set<Usuarios> usuarioses = new HashSet<Usuarios>(0);

	public TiposUsuarios() {
	}

	public TiposUsuarios(long tusuCodigo, String tusuNombre) {
		this.tusuCodigo = tusuCodigo;
		this.tusuNombre = tusuNombre;
	}

	public TiposUsuarios(long tusuCodigo, String tusuNombre, Set<Usuarios> usuarioses) {
		this.tusuCodigo = tusuCodigo;
		this.tusuNombre = tusuNombre;
		this.usuarioses = usuarioses;
	}

	@Id

	@Column(name = "tusu_codigo", unique = true, nullable = false, precision = 10, scale = 0)
	public long getTusuCodigo() {
		return this.tusuCodigo;
	}

	public void setTusuCodigo(long tusuCodigo) {
		this.tusuCodigo = tusuCodigo;
	}

	@Column(name = "tusu_nombre", nullable = false, length = 50)
	public String getTusuNombre() {
		return this.tusuNombre;
	}

	public void setTusuNombre(String tusuNombre) {
		this.tusuNombre = tusuNombre;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tiposUsuarios")
	public Set<Usuarios> getUsuarioses() {
		return this.usuarioses;
	}

	public void setUsuarioses(Set<Usuarios> usuarioses) {
		this.usuarioses = usuarioses;
	}

}
