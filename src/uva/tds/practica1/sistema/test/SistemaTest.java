package uva.tds.practica1.sistema.test;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uva.tds.practica1.recorrido.*;
import uva.tds.practica1.billete.*;
import uva.tds.practica1.usuario.*;
import uva.tds.practica1.sistema.*;
class SistemaTest {
	private Recorrido recorrido1;
	private Recorrido recorrido2;
	private Usuario usuario;
	private LocalDate fecha;
	private LocalTime hora;


		
	@BeforeEach
	void setUp() throws Exception {
		fecha = LocalDate.of(2002, 7, 18);
		hora = LocalTime.of(12, 30);
		recorrido1 = new Recorrido("1","origen","destino","autobus",4,fecha,hora,1,1);
		recorrido2 = new Recorrido("2","origen","destino","autobus",5,fecha,hora,1,1);
		usuario = new Usuario("33036946E","UsuarioNormal");
	}
	@Test
	void testAñadirRecorridoAlSistema(){
		Sistema sistema = new Sistema();
		ArrayList<Recorrido> recorridos = new ArrayList<Recorrido>();
		recorridos.add(recorrido1);
		sistema.añadirRecorrido(recorrido1);
		assertEquals(recorridos,sistema.getRecorridos());
	}
	
	
	@Test	
	void testAñadirRecorridoAlSistemaNoValidoDosRecorrridosConMismoIdentificador() {
			Recorrido recorrido1Copia = new Recorrido("1","origen","destino","autobus",0,fecha,hora,1,1);
			Sistema sistema = new Sistema();
			sistema.añadirRecorrido(recorrido1);
		assertThrows(IllegalStateException.class, () ->{
			sistema.añadirRecorrido(recorrido1Copia);
		});
	}
	
	
	@Test
	void testEliminarRecorridoDelSistema() {
		Sistema sistema = new Sistema();
		ArrayList<Recorrido> recorridos = new ArrayList<Recorrido>();
		recorridos.add(recorrido1);
		sistema.añadirRecorrido(recorrido1);
		sistema.añadirRecorrido(recorrido2);
		sistema.eliminarRecorrido(recorrido2.getId());
		assertEquals(recorridos,sistema.getRecorridos());
		
	}
	@Test
	void testEliminarRecorridoDelSistemaNoValidoRecorridoConBilletesAsociados() {
		Sistema sistema = new Sistema();
		Usuario usuario = new Usuario("33036946E","UsuarioNormal");
		Billete billete = new Billete("LocNorm",recorrido1,usuario);
		sistema.añadirRecorrido(recorrido1);
		assertThrows(IllegalStateException.class, () ->{
			sistema.eliminarRecorrido(recorrido1.getId());
		});
	}
	@Test
	void testActualizarRecorridoFecha() {
		Sistema sistema = new Sistema();
		LocalDate fechaNueva = LocalDate.of(2002, 7, 19);
		sistema.añadirRecorrido(recorrido1);
		sistema.actualizarFechaRecorrido(recorrido1.getId(),fechaNueva);
		assertEquals(fechaNueva,recorrido1.getFecha());
	}
	@Test
	void testActualizarRecorridoHora() {
		Sistema sistema = new Sistema();
		LocalTime horaNueva = hora = LocalTime.of(13, 00);
		sistema.añadirRecorrido(recorrido1);
		sistema.actualizarHoraRecorrido(recorrido1.getId(),horaNueva);
		assertEquals(horaNueva,recorrido1.getHora());
	}
	
	@Test
	void testObtenerPrecioTotal() {
		Sistema sistema = new Sistema();
		sistema.añadirRecorrido(recorrido1);
		sistema.añadirRecorrido(recorrido2);
		Billete billete = new Billete("LocNor1",recorrido1,usuario);
		Billete billete2 = new Billete("LocNor2",recorrido2,usuario);
		sistema.comprarBilletes("LocNor1", usuario, recorrido1, 1);
		sistema.comprarBilletes("LocNor2", usuario, recorrido2, 1);
		float precioTotal = sistema.obtenerPrecioTotal(usuario.getNif());
		assertEquals(precioTotal,9);
	}
	
	@Test	
	void testObtenerPrecioTotalNoValidoLocalizadorUsuarioNulo() {
			Sistema sistema = new Sistema();
		assertThrows(IllegalStateException.class, () ->{
			float precioTotal = sistema.obtenerPrecioTotal(null);
		});
	}
	
	@Test	
	void testObtenerPrecioTotalNoValidoDescuentoTrenNoAplicado() {
		Sistema sistema = new Sistema();
		Recorrido recorridoTren = new Recorrido("1","origen","destino","tren",5,fecha,hora,1,1);
		sistema.añadirRecorrido(recorridoTren);
		Billete billete = new Billete("LocNor1",recorridoTren,usuario);
		sistema.comprarBilletes("LocNor1", usuario, recorridoTren, 1);
		float precioTotal =sistema.obtenerPrecioTotal(usuario);
		assertThrows(IllegalStateException.class, () ->{
			assertEquals(precioTotal,5);
			
		});
	}
	
	@Test	
	void testObtenerRecorridoDisponiblesPorFecha() {
		Sistema sistema = new Sistema();
		ArrayList<Recorrido> recorridosEnFecha = new ArrayList<Recorrido>();
		sistema.añadirRecorrido(recorrido1);
		recorridosEnFecha.add(recorrido1);
		assertEquals(recorridosEnFecha,sistema.getRecorridosPorFecha(fecha));
	}
	
	@Test	
	void testObtenerRecorridoDisponiblesPorFechaNoValidoFechaNula() {
		Sistema sistema = new Sistema();
		assertThrows(IllegalStateException.class, () ->{
			sistema.getRecorridosPorFecha(null);
		});
	}
}
