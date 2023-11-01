package uva.tds.practica1.sistema.test;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.time.LocalTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uva.tds.practica1.recorrido.*;

class SistemaTest {
	private Recorrido recorrido1;
	private Recorrido recorrido2;
	private Recorrido recorrido3;
	private LocalDate fecha;
	private LocalTime hora;
	
	@BeforeEach
	void setUp() throws Exception {
		fecha = LocalDate.of(2002, 7, 18);
		hora = LocalTime.of(12, 30);
		recorrido1 = new Recorrido("1","origen","destino","autobus",0,fecha,hora,1,1);
		recorrido2 = new Recorrido("2","origen","destino","autobus",0,fecha,hora,1,1);
		recorrido3 = new Recorrido("3","origen","destino","autobus",0,fecha,hora,1,1);
	}

	@Test
	void testAñadirRecorridoAlSistema(){
		Sistema sistema = new Sistema();
		sistema.añadirRecorrido(recorrido1);
		assertTrue(sistema.getRecorridos.contains(recorrido1));
	}
	void testAñadirRecorridoAlSistemaNoValidoDosRecorrridosConMismoIdentificador() {
		
		assertThrows(IllegalStateException.class, () ->{
			Recorrido recorrido1Copia = new Recorrido("1","origen","destino","autobus",0,fecha,hora,1,1);
			Sistema sistema = new Sistema();
			sistema.añadirRecorrido(recorrido1);
			sistema.añadirRecorrido(recorrido1Copia);
		});
	}

}
