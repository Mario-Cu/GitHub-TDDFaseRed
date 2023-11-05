package uva.tds.practica1.sistema;
import uva.tds.practica1.recorrido.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import uva.tds.practica1.billete.*;

public class Sistema {
	
	

	public Sistema() {
		
	}
	/**
	 * Devuelve el arraylist que guardara los recorridos
	 * @return arraylist que guardara los recorridos
	 */
	public ArrayList<Recorrido> getRecorridos(){
		return null;
	}
	/**
	 * Añade un recorrido al arraylist de recorridos
	 * @param recorrido 
	 * @throws IllegalStateException cuando se añade un recorrido con un identificador igual a otro
	 */
	public void añadirRecorrido(Recorrido recorrido) {
	}
	/**
	 * Elimina un recorrido del arraylist de recorridos
	 * @throws IllegalStateException cuando se elimina un recorrido con billetes asociados
	 */
	public void eliminarRecorrido(String id) {
		
	}
	/**
	 * Actualiza la fecha de un recorrido
	 * @param id identificador del recorrido
	 * @param fecha fecha nueva del reocorrido
	 */
	public void actualizarFechaRecorrido(String id,LocalDate fecha) {
	
	}
	/**
	 * Actualiza la hora de un recorrido 
	 * @param id identificador del recorrido
	 * @param hora hora nueva del recorrido
	 */
	public void actualizarHoraRecorrido(String id,LocalTime hora) {
		
	}
	/**
	 * Añade un billete al arraylist de billetes
	 * @param billete billete a añadir al arraylists
	 */
	public void añadirBillete(Billete billete) {	
	}
	
}
