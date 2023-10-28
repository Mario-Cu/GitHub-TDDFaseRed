package uva.tds.practica1.test;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

class RecorridoTest {
	private LocalDate fecha;
	private LocalTime hora;
	@BeforeEach
	void setUp() {
		fecha = LocalDate.of(2002, 7, 18);
		hora = LocalTime.of(12, 30);
	}

	@Test
	void testConstructorRecorridoAutobusLimiteInferior() {
		Recorrido recorrido = new Recorrido("1","origen","destino","autobus",0,fecha,hora,1,1);
		assertEquals("1",recorrido.getId());
		assertEquals("origen",recorrido.getOrigen());
		assertEquals("destino",recorrido.getDestino());
		assertEquals("autobus",recorrido.getMedioTrasporte());
		assertEquals(0,recorrido.getPrecio());
		assertEquals(LocalDate.now(),recorrido.getFecha());
		assertEquals(LocalTime.now(),recorrido.getHora());
		assertEquals(1,recorrido.getPlazas());
		assertEquals(1,recorrido.getDuracion());
	}
	void testConstructorRecorridoAutobusLimiteSuperior() {
		Recorrido recorrido = new Recorrido("1","origen","destino","autobus",0,fecha,hora,50,1);
		assertEquals("1",recorrido.getId());
		assertEquals("origen",recorrido.getOrigen());
		assertEquals("destino",recorrido.getDestino());
		assertEquals("autobus",recorrido.getMedioTrasporte());
		assertEquals(0,recorrido.getPrecio());
		assertEquals(LocalDate.now(),recorrido.getFecha());
		assertEquals(LocalTime.now(),recorrido.getHora());
		assertEquals(50,recorrido.getPlazas());
		assertEquals(1,recorrido.getDuracion());
	}
	void testConstructorRecorridoTrenLimiteInferior() {
		Recorrido recorrido = new Recorrido("1","origen","destino","tren",0,fecha,hora,1,1);
		assertEquals("1",recorrido.getId());
		assertEquals("origen",recorrido.getOrigen());
		assertEquals("destino",recorrido.getDestino());
		assertEquals("tren",recorrido.getMedioTrasporte());
		assertEquals(0,recorrido.getPrecio());
		assertEquals(LocalDate.now(),recorrido.getFecha());
		assertEquals(LocalTime.now(),recorrido.getHora());
		assertEquals(1,recorrido.getPlazas());
		assertEquals(1,recorrido.getDuracion());
	}
	void testConstructorRecorridoTrenLimiteSuperior() {
		Recorrido recorrido = new Recorrido("1","origen","destino","tren",0,fecha,hora,250,1);
		assertEquals("1",recorrido.getId());
		assertEquals("origen",recorrido.getOrigen());
		assertEquals("destino",recorrido.getDestino());
		assertEquals("tren",recorrido.getMedioTrasporte());
		assertEquals(0,recorrido.getPrecio());
		assertEquals(LocalDate.now(),recorrido.getFecha());
		assertEquals(LocalTime.now(),recorrido.getHora());
		assertEquals(250,recorrido.getPlazas());
		assertEquals(1,recorrido.getDuracion());
	}
	
	void testConstructorRecorridoNoValidoIdentificadorMenorQueLimiteInferior() {
		
		assertThrows(IllegalArgumentException.class,() ->{
			new Recorrido("","origen","destino","autobus",0,fecha,hora,1,1);
		});
	}
	void testConstructorRecorridoNoValidoIdentificadorNulo() {
		
		assertThrows(IllegalArgumentException.class,() ->{
			new Recorrido(null,"origen","destino","autobus",0,fecha,hora,1,1);
		});
	}
	void testConstructorRecorridoNoValidoOrigenMenorQueLimiteInferior() {
		
		assertThrows(IllegalArgumentException.class,() ->{
			new Recorrido("1","","destino","autobus",0,fecha,hora,1,1);
		});
	}
	void testConstructorRecorridoNoValidoOrigenNulo() {
		
		assertThrows(IllegalArgumentException.class,() ->{
			new Recorrido("1",null,"destino","autobus",0,fecha,hora,1,1);
		});
	}
	void testConstructorRecorridoNoValidoDestinoMenorQueLimiteInferior() {
		
		assertThrows(IllegalArgumentException.class,() ->{
			new Recorrido("1","origen","","autobus",0,fecha,hora,1,1);
		});
	}
	void testConstructorRecorridoNoValidoDestinoNulo() {
		
		assertThrows(IllegalArgumentException.class,() ->{
			new Recorrido("1","origen",null,"autobus",0,fecha,hora,1,1);
		});
	}
	void testConstructorRecorridoNoValidoMedioTransporteDiferente() {
		assertThrows(IllegalArgumentException.class, () ->{
			new Recorrido("1","origen","destino","coche",0,fecha,hora,1,1);
		});
	}
	void testConstructorRecorridoNoValidoMedioTransporteVacio() {
		assertThrows(IllegalArgumentException.class, () ->{
			new Recorrido("1","origen","destino","",0,fecha,hora,1,1);
		});
	}
	void testConstructorRecorridoNoValidoMedioTransporteNulo() {
		assertThrows(IllegalArgumentException.class, () ->{
			new Recorrido("1","origen","destino",null,0,fecha,hora,1,1);
		});
	}
	void testConstructorRecorridoNoValidoPrecioMenorQueLimiteInferior() {
		assertThrows(IllegalArgumentException.class, () ->{
			new Recorrido("1","origen","destino","autobus",-1,fecha,hora,1,1);
		});
	}
	void testConstructorRecorridoNoValidoPrecioNoEntero() {
		assertThrows(IllegalArgumentException.class, () ->{
			new Recorrido("1","origen","destino","autobus",1.5,fecha,hora,1,1);
		});
	}
	void testConstructorRecorridoNoValidoPrecioNulo() {
		assertThrows(IllegalArgumentException.class, () ->{
			new Recorrido("1","origen","destino","autobus",null,fecha,hora,1,1);
		});
	}
	void testConstructorRecorridoNoValidoFechaNula() {
		assertThrows(IllegalArgumentException.class, () ->{
			new Recorrido("1","origen","destino","autobus",0,null,hora,1,1);
		});
	}
	void testConstructorRecorridoNoValidoHoraNula() {
		assertThrows(IllegalArgumentException.class, () ->{
			new Recorrido("1","origen","destino","autobus",0,fecha,null,1,1);
		});
	}
	void testConstructorRecorridoNoValidoAutobusPlazasMenorQueLimiteInferior() {
		assertThrows(IllegalArgumentException.class, () ->{
			new Recorrido("1","origen","destino","autobus",0,fecha,hora,0,1);
		});
	}
	void testConstructorRecorridoNoValidoAutobusPlazasMayorQueLimiteSuperior() {
		assertThrows(IllegalArgumentException.class, () ->{
			new Recorrido("1","origen","destino","autobus",0,fecha,hora,51,1);
		});
	}
	void testConstructorRecorridoNoValidoAutobusPlazasNoEnteras() {
		assertThrows(IllegalArgumentException.class, () ->{
			new Recorrido("1","origen","destino","autobus",0,fecha,hora,1.5,1);
		});
	}
	void testConstructorRecorridoNoValidoAutobusPlazasNulas() {
		assertThrows(IllegalArgumentException.class, () ->{
			new Recorrido("1","origen","destino","autobus",0,fecha,hora,null,1);
		});
	}
	void testConstructorRecorridoNoValidoTrenPlazasMenorQueLimiteInferior() {
		assertThrows(IllegalArgumentException.class, () ->{
			new Recorrido("1","origen","destino","tren",0,fecha,hora,0,1);
		});
	}
	void testConstructorRecorridoNoValidoTrenPlazasMayorQueLimiteSuperior() {
		assertThrows(IllegalArgumentException.class, () ->{
			new Recorrido("1","origen","destino","tren",0,fecha,hora,251,1);
		});
	}
	void testConstructorRecorridoNoValidoTrenPlazasNoEnteras() {
		assertThrows(IllegalArgumentException.class, () ->{
			new Recorrido("1","origen","destino","tren",0,fecha,hora,1.5,1);
		});
	}
	void testConstructorRecorridoNoValidoTrenPlazasNulas() {
		assertThrows(IllegalArgumentException.class, () ->{
			new Recorrido("1","origen","destino","tren",0,fecha,hora,null,1);
		});
	}
	void testConstructorRecorridoNoValidoMinutosMenorQueLimiteInferior() {
		assertThrows(IllegalArgumentException.class, () ->{
			new Recorrido("1","origen","destino","tren",0,fecha,hora,1,0);
		});
	}
	void testConstructorRecorridoNoValidoMinutosNoEnteros() {
		assertThrows(IllegalArgumentException.class, () ->{
			new Recorrido("1","origen","destino","tren",0,fecha,hora,1,1.5);
		});
	}
	void testRecorridoIgualAOtroPorMismoIdentificador() {
		Recorrido recorrido1 = new Recorrido("1","origen","destino","tren",0,fecha,hora,1,1);
		Recorrido recorrido2 = new Recorrido("1","origen","destino","tren",0,fecha,hora,1,1);
		assertEquals(recorrido1,recorrido2);
	}
	
}
