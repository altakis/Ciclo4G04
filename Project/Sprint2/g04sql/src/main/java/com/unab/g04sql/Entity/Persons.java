package com.unab.g04sql.Entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="persons")
public class Persons {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

	@Column(name = "tipo_documento", nullable = false, length = 5)
    private String tipoDocumento;
	
	@Column(name = "documento", nullable = false, unique  = true, length = 12)
    private String documento;
	
	@Column(name = "primer_nombre", nullable = false, length = 20)
    private String primerNombre;
	
	@Column(name = "segundo_nombre", length = 20)
    private String segundoNombre;
	
	@Column(name = "primer_apellido", nullable = false, length = 20)
    private String primerApellido;
	
	@Column(name = "segundo_apellido", length = 20)
    private String segundoApellido;
	
	@Column(name = "correo", nullable = false, unique = true, length = 40)
    private String correo;
	
	@Column(name = "telefono", nullable = false, unique = true, length = 20)
    private String telefono;
	
	@Column(name = "fecha_nacimiento", nullable = false)
    private Date fechaNacimiento;
	
	@Column(name = "direccion", nullable = false, length = 100)
    private String direccion;
	
	@Column(name = "estado", nullable = false)
    private Boolean estado;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "usuario_id", nullable = false)
	private Users usuarioId;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "ciudad_id", nullable = false)
	private Cities ciudadId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Users getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Users usuarioId) {
		this.usuarioId = usuarioId;
	}

	public Cities getCiudadId() {
		return ciudadId;
	}

	public void setCiudadId(Cities ciudadId) {
		this.ciudadId = ciudadId;
	}	
	
}
