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
		recorrido1 = new Recorrido("1","origen","destino","autobus",5,fecha,hora,50,1);
		recorrido2 = new Recorrido("2","origen","destino","autobus",5,fecha,hora,50,1);
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
		sistema.añadirBillete(billete);
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
	void testReservarBilletes() {
		Sistema sistema = new Sistema();
		sistema.reservarBilletes("LocNorm",recorrido1,1);
		ArrayList<Billete> reservaBillete = new ArrayList<Billete>();
		Billete billeteReservado = new Billete("LocNorm",recorrido1,usuario);
		reservaBillete.add(billeteReservado);  
		assertEquals(49,recorrido1.getPlazas());
		assertEquals(billeteReservado,sistema.getReserva("LocNorm"));
	}
	@Test
	void testReservarVariosBilletes() {
		Sistema sistema = new Sistema();
		ArrayList<Billete> reservaBilleteMultiple = new ArrayList<Billete>();
		Billete reservaBillete = new Billete("LocNorm", recorrido1, usuario);
		for(int i = 1; i<4; i++) {
			reservaBilleteMultiple.add(reservaBillete);
		}
		sistema.reservarBilletes("LocNorm",usuario,recorrido1,3);
		assertEquals(reservaBilleteMultiple,sistema.getReserva("LocNorm"));
	}
	@Test
	void testReservaBilletesNoValidaNumeroPlazasDisponiblesMenorQueMitadNumeroTotalPlazasAutobus() {
		Sistema sistema = new Sistema();
		Recorrido recorrido = new recorrido("1","origen","destino","autobus",5,fecha,hora,24,1);
		assertThrows(IllegalStateException.class, () ->{
			sistema.reservarBilletes("LocNorm",usuario,recorrido,1);
		});
	}
	void testReservaBilletesNoValidaNumeroPlazasDisponiblesMenorQueMitadNumeroTotalPlazasTren() {
		Sistema sistema = new Sistema();
		Recorrido recorrido = new recorrido("1","origen","destino","tren",5,fecha,hora,124,1);
		assertThrows(IllegalStateException.class, () ->{
			sistema.reservarBilletes("LocNorm",usuario,recorrido,1);
		});
	}
	void testReservaBilletesNoValidaPlazasInsuficientes() {
		Sistema sistema = new Sistema();
		assertThrows(IllegalStateException.class, () ->{
			sistema.reservarBilletes("LocNorm",usuario,recorrido1,51);
		});
	}
	void testReservaBilletesNoValidaRecorridoNoExistente() {
		Sistema sistema = new Sistema();
		assertThrows(IllegalStateException.class, () ->{
			sistema.reservarBilletes("LocNorm",usuario,null,1);
		});
	}
	void testReservaBilletesNoValidaLocalizadorNulo() {
		Sistema sistema = new Sistema();
		assertThrows(IllegalStateException.class, () ->{
			sistema.reservarBilletes(null,usuario,recorrido1,1);
		});
	}
	void testReservaBilletesNoValidaUsuarioNulo() {
		Sistema sistema = new Sistema();
		assertThrows(IllegalStateException.class, () ->{
			sistema.reservarBilletes("LocNorm",null,recorrido1,1);
		});
	}
	void testAnularReserva() {
		Sistema sistema = new Sistema();
		ArrayList<Billete> reservaBilletes = new ArrayList<Billete>();
		Billete billeteReservado = new Billete("LocNorm", recorrido1, usuario);
		reservaBilletes.add(billeteReservado);
		sistema.reservarBilletes("LocNorm",usuario,recorrido1,2);
		sistema.anularReservaBilletes("LocNorm",1);
		assertEquals(billeteReservado,sistema.getReserva("LocNorm"));
		assertEquals(49,recorrido1.getPlazas());
	}
	void testAnularReservaNoValidaBilleteNoPreviamenteReservados() {
		Sistema sistema = new Sistema();
		assertThrows(IllegalStateException.class, () ->{
			sistema.anularReservaBilletes("LocNorm",1);
		});
	}
	void testAnularReservaNoValidaLocalizadorNulo() {
		Sistema sistema = new Sistema();
		assertThrows(IllegalStateException.class, () ->{
			sistema.anularReservaBilletes(null,1);
		});
	}

}
