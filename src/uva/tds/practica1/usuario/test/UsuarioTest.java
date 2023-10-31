package uva.tds.practica1.usuario.test;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uva.tds.practica1.usuario.Usuario;

class UsuarioTest {
	
	Usuario usrNormal;
	
	@BeforeEach
	void setUp() {
		this.usrNormal = new Usuario("33036946E","UsuarioNormal");
	}
	@Test
	void testConstructorUsuarioNombreLimiteInferior() {
		Usuario usr = new Usuario("33036946E","A");
		assertEquals("33036946E",usr.getNif());
		assertEquals("A",usr.getNombre());
	}
	
	@Test
	void testConstructorUsuarioNombreLimiteSuperior() {
		Usuario usr = new Usuario("63265691M","Usuario15caract");
		assertEquals("63265691M",usr.getNif());
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
		Usuario usr2 = new Usuario("3303694E","UsuarioNormal");
		assertTrue(usrNormal.equals(usr2));
	}


	@Test
	void testConstructorUsuarioNoValidoNIFNulo() {
		assertThrows(IllegalArgumentException.class,()->{
			new Usuario(null,"UsuarioNormal");
		});
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
	
	@Test
	void testConstructorNoValidoUsoLetraI() {
		assertThrows(IllegalArgumentException.class,()->{
			new Usuario("330369461I","UsuarioI");
		});	
	}
	
	@Test
	void testConstructorNoValidoUsoLetraÑ() {
		assertThrows(IllegalArgumentException.class,()->{
			new Usuario("330369461Ñ","UsuarioÑ");
		});	
	}
	
	@Test
	void testConstructorNoValidoUsoLetraO() {
		assertThrows(IllegalArgumentException.class,()->{
			new Usuario("330369461O","UsuarioO");
		});	
	}
	
	@Test
	void testConstructorNoValidoUsoLetraU() {
		assertThrows(IllegalArgumentException.class,()->{
			new Usuario("330369461U","UsuarioU");
		});	
	}
	
}