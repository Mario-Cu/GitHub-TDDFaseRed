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
	 * Metodo que devuelve el precio total de los billetes de un usuario
	 * (Recordar que el precio de un billete de tren, tiene un 10% de descuento con respecto al precio del recorrido)
	 * @param locUsr localizador del usuario
	 * @throws IllegalArgumentException si el descuento del 10% en los billetes de tren no es aplicado
	 * @throws IllegalArgumentException si el localizador de usuario es nulo
	 * @return
	 */
	public float obtenerPrecioTotal(String locUsr) {
		
		return 0;
	}
	
	/**
	 * Metodo que devuelve un arraylist con los recorridos en una fecha dada
	 * @param fecha Fecha en la que se buscan los recorridos
	 * @return arraylist con los recorridos en una determinada fecha
	 * @throws IllegalArgumentException si la fecha es nula
	 * 
	 */
	public ArrayList<Recorrido> getRecorridosPorFecha(LocalDate fecha) {
		
		return null;
	}

}
