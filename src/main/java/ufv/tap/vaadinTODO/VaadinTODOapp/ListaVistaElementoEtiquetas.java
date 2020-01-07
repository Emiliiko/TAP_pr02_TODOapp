package ufv.tap.vaadinTODO.VaadinTODOapp;

import java.util.ArrayList;

public class ListaVistaElementoEtiquetas {
	
	private ArrayList<VistaElementoEtiqueta> etiquetas;
	
	public ListaVistaElementoEtiquetas() {
		etiquetas = new ArrayList<VistaElementoEtiqueta>();
	}
	
	
	public ArrayList<VistaElementoEtiqueta> getEtiquetas() {
		return etiquetas;
	}



	public void addTarea(VistaElementoEtiqueta vet) {
		etiquetas.add(vet);
	}
}
