package ufv.tap.vaadinTODO.VaadinTODOapp;

import java.util.Date;

public class Tarea {

	private int ID;
	private String prioridad;
	private Date fecha;
	private String descripcion;
	private boolean completada;
	private String titulo; 
	private Etiqueta etiqueta;
	
	
	public Tarea(String titulo, String prioridad, Date fecha, String descripcion, boolean completada, Etiqueta etiqueta) {
		this.titulo = titulo;
		this.prioridad = prioridad; // '', 'Alta', 'Media', 'Baja'
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.completada = completada;
		this.etiqueta = etiqueta;
	}


	public Etiqueta getEtiqueta() {
		return etiqueta;
	}


	public String getPrioridad() {
		return prioridad;
	}


	public Date getFecha() {
		return fecha;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public boolean isCompletada() {
		return completada;
	}


	public String getTitulo() {
		return titulo;
	}
	
	public int getID() {
		return ID;
	}
	
	
}
