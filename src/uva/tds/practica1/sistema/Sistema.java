package uva.tds.practica1.sistema;
import uva.tds.practica1.recorrido.*;
import uva.tds.practica1.usuario.Usuario;

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
	 * Elimina un recorrido del arraylist de recorridos	 * @throws IllegalStateException cuando se elimina un recorrido con billetes asociados
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
	/**
	 * Reserva un billete 
	 * @param Localizador localizador del billete reservado 
	 * @param usuario usuario que realiza la reserva
	 * @param recorrido recorrido del que se reveran billetes 
	 * @param numBilletes cantidad de billetes reservados
	 */
	public void reservarBilletes(String Localizador,Usuario usuario,Recorrido recorrido,int numBilletes) {
		
	}
	/**
	 * Devuelve un arraylist con todos los billetes reservados que tienen el mismo localizador
	 * @param Localizador localizador de los billetes reservados
	 * @return arraylist que contiene los billetes reservados
	 */
	public ArrayList<Billete> getReservaBilletes(String Localizador) {
		return null;
	}
	/**
	 * Anula la reserva de billetes reservados
	 * @param Localizador localizador de los billetes reservados
	 * @param numBilletes cantidad de billetes reservados a anular
	 */
	public void anularReservaBilletes(String Localizador, int numBilletes) {
		
	}
}
