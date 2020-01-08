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
	
	
	public Tarea(int id, String titulo, String prioridad, Date fecha, String descripcion, boolean completada, Etiqueta etiqueta) {
		this.ID = id;
		this.titulo = titulo;
		this.prioridad = prioridad; // 'Alta', 'Media', 'Baja', 'Sin Prioridad'
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.completada = completada;
		this.etiqueta = etiqueta;
	}


	public Tarea() {
		// TODO Auto-generated constructor stub
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

	public void setCompletada(boolean completada) {
		this.completada = completada;
	}


	public String getTitulo() {
		return titulo;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getPrioridadNum(){
		
		if(this.prioridad.equals("Alta"))
			return 3;
		else if(this.prioridad.equals("Media"))
			return 2;
		else if(this.prioridad.equals("Baja"))
			return 1;
		
		return 0;
	}
}
