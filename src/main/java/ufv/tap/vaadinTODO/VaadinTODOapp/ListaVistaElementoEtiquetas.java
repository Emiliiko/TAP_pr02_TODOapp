package ufv.tap.vaadinTODO.VaadinTODOapp;

import java.util.ArrayList;

public class ListaVistaElementoEtiquetas {
	
	private ArrayList<VistaElementoEtiqueta> etiquetas;
	
	public ListaVistaElementoEtiquetas() {
		etiquetas = new ArrayList<VistaElementoEtiqueta>();
	}
	
	
	public ArrayList<VistaElementoEtiqueta> getVistaEtiquetas() {
		return etiquetas;
	}



	public void addEtiqueta(VistaElementoEtiqueta vet) {
		etiquetas.add(vet);
	}
}
