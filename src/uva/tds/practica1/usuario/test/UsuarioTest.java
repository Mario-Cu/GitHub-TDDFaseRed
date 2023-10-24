package uva.tds.practica1.usuario.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UsuarioTest {

	@Test
	void testConstructorUsuarioNombreLimiteInferior() {
		Usuario usr = new Usuario("33036946E","A");
		assertEquals("C",usr.getNombre());
		assertEquals(0,usr.getCoste());
	}
	
	@Test
	void testConstructorUsuarioNombreLimiteSuperior() {
		Usuario usr = new Usuario("33036946E","Usuario15caract");
		assertEquals("C",usr.getNombre());
		assertEquals(0,usr.getCoste());
	}

	@Test
	void testConstructorUsuarioNoValidoNombreMenorLimiteInferior() {
		assertThrows(IllegalArgumentException.class,()->{
			new Usuario("33036946E","");
		});
	}
	
	@Test
	void testConstructorUsuarioNoValidoNombreMayorQueLimiteSuperior() {
		assertThrows(IllegalArgumentException.class,()->{
			new Usuario("33036946E","Usuario15caracte");
		});
	}
	
	@Test
	void testConstructorCartaNoValidoNombreNulo() {
		assertThrows(IllegalArgumentException.class,()->{
			new Usuario("33036946E",null);
		});
	}


}
