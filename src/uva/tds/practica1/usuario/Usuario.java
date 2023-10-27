package uva.tds.practica1.usuario;

/**
 * Clase que representa un usuario.
 */
public class Usuario {
	
	/**
	 * Creacion de un usuario
	 * @param nif Identificador de una persona. Debe tener 9 caracteres
	 * @param nombre Palabra con la que se denomina a una persona. Debe tener entre 1 y 15 caracteres
	 * @throws IllegalArgumentException si la longitud de nif es mayor o menor que 9 
	 * @throws IllegalArgumentException si nif utiliza las letras I,Ñ,O,U.
	 * @throws IllegalArgumentException si el resto de la division del numero nif entre 23 no coincide con su letra asociada 
	 */
	public Usuario(String nif, String nombre) {
		
	}

	public String getNif() {
		return null;
	}
	
	public String getNombre() {
		return null;
	}
	
	public Usuario getUsuarioPorNif(String nif) {
		return null;
	}
	

 	@Override
	public boolean equals(Object o) {
		return false;
	}

 
}
