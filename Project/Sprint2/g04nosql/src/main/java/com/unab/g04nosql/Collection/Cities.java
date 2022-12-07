package com.unab.g04nosql.Collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("Cities")
public class Cities {

	@Id
    private String id;

	@Field("codigo")
    private String codigo;
	
	@Field("nombre")
    private String nombre;
	
	@Field("estado")
    private Boolean estado;
	
	@DBRef
	private Departments departmentId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Departments getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Departments departmentId) {
		this.departmentId = departmentId;
	}	 
}
