package uva.tds.practica1.billete.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BIlleteTest {

	@Test
	void testConstructorBilleteLocalizadorLimiteInferior() {
		Billete billete = new Billete("L",recorrido,usuario);
		assertEquals("L",billete.getLocalizador());
		//assertSame("Recorrido",recorrido.getX());
		//assertSame("Usuario",usuario.getX());
	}
	
	@Test
	void testConstructorBilleteLocalizadorLimiteInferior() {
		Billete billete = new Billete("Loc8cara",recorrido,usuario);
		assertEquals("Loc8cara",billete.getLocalizador());
		//assertSame("Recorrido",recorrido.getX());
		//assertSame("Usuario",usuario.getX());
	}

	@Test
	void testConstructorBilleteNoValidoLocalizadorMenorLimiteInferior() {
		assertThrows(IllegalArgumentException.class,()->{
			new Billete("",recorrido,usuario);
		});
	}
	
	@Test
	void testConstructorBilleteNoValidoLocalizadorMayorQueLimiteSuperior() {
		assertThrows(IllegalArgumentException.class,()->{
			new Billete("Loc8carac",recorrido,usuario);
		});
	}
	
	@Test
	void testConstructorBilleteNoValidoLocalizadorNulo() {
		assertThrows(IllegalArgumentException.class,()->{
			new Billete(null,recorrido,usuario);
		});
	}


}
