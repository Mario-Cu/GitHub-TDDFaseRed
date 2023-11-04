package uva.tds.practica1.sistema;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import uva.tds.practica1.billete.Billete;
import uva.tds.practica1.recorrido.Recorrido;
import uva.tds.practica1.usuario.Usuario;

public class Sistema {
	
	/**
	 * Clase que representa un sistema.
	 */

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
	 * Devuelve el arraylist que guardara los billetes
	 * @return arraylist que guardara los billetes
	 */
	public ArrayList<Billete> getBilletes(){
		return null;
	}
	
	/**
	 * Metodo para la compra de billetes en un sistema
	 * @param loc Localizador del billete
	 * @param usr Usuario que realiza la compra
	 * @param rec Recorrido al cual esta asociado el billete
	 * @param numBilletes Cantidad de billetes que busca comprar
	 * @throws IllegalArgumentException cuando localizador es nulo
	 * @throws IllegalArgumentException cuando usuario es nulo
	 * @throws IllegalArgumentException cuando recorrido es nulo
	 * @throws IllegalArgumentException cuando numBilletes es menor que 1
	 * @throws IllegalArgumentException cuando el numero de plazas del recorrido no tiene suficientes plazas libres
	 * @throws IllegalArgumentException cuando el recorrido no existe en el sistema
	 */
	public void comprarBilletes(String loc, Usuario usr, Recorrido rec, int numBilletes) {
		
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
	 * Metodo que permite comprar billetesReservados
	 * @param loc Localizador de los billetes
	 * @throws IllegalArgumentException cuando localizador es nulo
	 */
	public void comprarBilletesReservados(String loc) {

	}
	
	/**
	 * Metodo que devuelve una lista de los billetes Reservados
	 * @return arraylist que guarda los billetes reservados
	 */
	public ArrayList<Billete> getBilletesReservados() {

		return null;
	}
	
	/**
	 * Metodo para la devolucion de billetes
	 * @param loc Localizador del billete a devolver
	 * @param numBilletes Cantidad de billetes a devolver
	 * @throws IllegalArgumentException cuando localizador es nulo
	 * @throws IllegalArgumentException cuando numBilletes es menor que 1
	 * @throws IllegalArgumentException cuando localizador es nulo
	 * @throws IllegalArgumentException cuando loc no coincide con un billete previamente comprado
	 */
	public void devolverBilletes(String loc, int numBilletes) {
	
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
