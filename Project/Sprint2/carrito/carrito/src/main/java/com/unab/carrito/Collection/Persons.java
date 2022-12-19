package com.unab.carrito.Collection;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("Persons")
public class Persons {

	@Id
    private String id;

	@Field("tipoDocumento")
    private String tipoDocumento;
	
	@Field("documento")
    private String documento;
	
	@Field("primerNombre")
    private String primerNombre;
	
	@Field("segundoNombre")
    private String segundoNombre;
	
	@Field("primerApellido")
    private String primerApellido;
	
	@Field("segundoApellido")
    private String segundoApellido;
	
	@Field("correo")
    private String correo;
	
	@Field("telefono")
    private String telefono;
	
	@Field("fechaNacimiento")
    private Date fechaNacimiento;
	
	@Field("direccion")
    private String direccion;
	
	@Field("estado")
    private Boolean estado;
	
	@DBRef
	private Users usuarioId;
	
	@DBRef
	private Cities ciudadId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
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
