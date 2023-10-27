package uva.tds.practica1.usuario.test;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import uva.tds.practica1.usuario.Usuario;

class UsuarioTest {

	@Test
	void testConstructorUsuarioNombreLimiteInferior() {
		Usuario usr = new Usuario("33036946E","A");
		assertEquals("33036946E",usr.getNif());
		assertEquals("A",usr.getNombre());
	}
	
	@Test
	void testConstructorUsuarioNombreLimiteSuperior() {
		Usuario usr = new Usuario("33036946E","Usuario15caract");
		assertEquals("33036946E",usr.getNif());
		assertEquals("Usuario15caract",usr.getNombre());
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
	void testConstructorUsuarioNoValidoNombreNulo() {
		assertThrows(IllegalArgumentException.class,()->{
			new Usuario("33036946E",null);
		});
	}
	
	@Test
	void testConstructorUsuarioIgualaOtroPorNIF() {
		Usuario usr = new Usuario("33036946E","UsuarioNormal");
		Usuario usr2 = new Usuario("3303694E","UsuarioNormal");
		assertTrue(usr.equals(usr2));
	}

	
	@Test
	void testConstructorUsuarioNIFLimite() {
		Usuario usr = new Usuario("33036946E","UsuarioNormal");
		assertEquals("33036946E",usr.getNif());
		assertEquals("Usuario15caract",usr.getNombre());
	}

	@Test
	void testConstructorUsuarioNoValidoNIFMenorLimiteInferior() {
		assertThrows(IllegalArgumentException.class,()->{
			new Usuario("3303694E","UsuarioNormal");
		});
	}
	
	@Test
	void testConstructorUsuarioNoValidoNIFMayorQueLimiteSuperior() {
		assertThrows(IllegalArgumentException.class,()->{
			new Usuario("330369461E","UsuarioNormal");
		});
	}
}
