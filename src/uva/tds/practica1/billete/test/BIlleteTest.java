package uva.tds.practica1.billete.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uva.tds.practica1.recorrido.Recorrido;
import uva.tds.practica1.usuario.Usuario;

class BIlleteTest {
	private Usuario usrNormal;
	private Recorrido recorridoNormal;
	private LocalDate fecha;
	private LocalTime hora;

	
	@BeforeEach
	void setUp() {
		this.usrNormal = new Usuario("33036946E","UsuarioNormal");
		fecha = LocalDate.of(2002, 7, 18);
		hora = LocalTime.of(12, 30);
		this.recorridoNormal = new Recorrido("1","origen","destino","autobus",0,fecha,hora,1,1);

	}
	
	@Test
	void testConstructorBilleteLocalizadorLimiteInferior() {
		Billete billete = new Billete("L",recorridoNormal,usrNormal);
		assertEquals("L",billete.getLocalizador());
		assertEquals("1",recorridoNormal.getId());
		assertEquals("UsuarioNormal",usrNormal.getNombre());
	}
	
	@Test
	void testConstructorBilleteLocalizadorLimiteSuperior() {
		Billete billete = new Billete("Loc8cara",recorrido,usuario);
		assertEquals("Loc8cara",billete.getLocalizador());
		assertEquals("1",recorridoNormal.getId());
		assertEquals("UsuarioNormal",usrNormal.getNombre());
	}

	@Test
	void testConstructorBilleteNoValidoLocalizadorMenorLimiteInferior() {
		assertThrows(IllegalArgumentException.class,()->{
			new Billete("",recorridoNormal,usrNormal);
		});
	}
	
	@Test
	void testConstructorBilleteNoValidoLocalizadorMayorQueLimiteSuperior() {
		assertThrows(IllegalArgumentException.class,()->{
			new Billete("Loc8carac",recorridoNormal,usrNormal);
		});
	}
	
	@Test
	void testConstructorBilleteNoValidoLocalizadorNulo() {
		assertThrows(IllegalArgumentException.class,()->{
			new Billete(null,recorridoNormal,usrNormal);
		});
	}
	
	@Test
	void testConstructorBilleteNoValidoRecorridoNulo() {
		assertThrows(IllegalArgumentException.class,()->{
			new Billete("LocNorm",null,usrNormal);
		});
	}
	
	@Test
	void testConstructorBilleteNoValidoUsuarioNulo() {
		assertThrows(IllegalArgumentException.class,()->{
			new Billete("LocNorm",recorridoNormal,null);
		});
	}


}
