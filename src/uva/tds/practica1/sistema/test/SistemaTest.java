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
		recorrido1 = new Recorrido("1","origen","destino","autobus",0,fecha,hora,5,1);
		recorrido2 = new Recorrido("2","origen","destino","autobus",0,fecha,hora,5,1);
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
	void testComprarBilleteEnSistema(){
		Sistema sistema = new Sistema();
		ArrayList<Billete> billetes = new ArrayList<Billete>();
		Billete billetePrueba = new Billete("LocNorm", recorrido1, usuario);
		billetes.add(billetePrueba);
		sistema.comprarBilletes("LocNorm",usuario,recorrido1,1);
		assertEquals(billetes,sistema.getBilletes());
		assertEquals(4,recorrido1.getPlazas());
	}
	
	@Test
	void testComprarBilletesReservados(){
		Sistema sistema = new Sistema();
		ArrayList<Billete> billetesReservados = new ArrayList<Billete>();
		Billete billetePrueba = new Billete("LocNorm", recorrido1, usuario);
		billetesReservados.add(billetePrueba);
		sistema.comprarBilletesReservados("LocNorm");
		assertEquals(billetesReservados,sistema.getBilletesReservados());
	}
	
	@Test
	void testComprarBilletesReservadosNoValidoLocalizadorNulo(){
		Sistema sistema = new Sistema();
		ArrayList<Billete> billetesReservados = new ArrayList<Billete>();
		Billete billetePrueba = new Billete("LocNorm", recorrido1, usuario);
		billetesReservados.add(billetePrueba);
		assertThrows(IllegalStateException.class, () ->{
			sistema.comprarBilletesReservados(null);
		});
	}
	
	@Test
	void testDevolverBilleteEnSistema(){
		Sistema sistema = new Sistema();
		ArrayList<Billete> billetes = new ArrayList<Billete>();
		Billete billetePrueba = new Billete("LocNorm", recorrido1, usuario);
		sistema.comprarBilletes("locNorm", usuario, recorrido1, 1);
		sistema.devolverBilletes("LocNorm",1);
		assertEquals(billetes,sistema.getBilletes());
		assertEquals(5,recorrido1.getPlazas());
	}
	
	@Test
	void testDevolverBilleteEnSistemaNoValidoBilleteNoComprado(){
		Sistema sistema = new Sistema();
                sistema.comprarBilletes("locNorm", usuario, recorrido1, 1);
		assertThrows(IllegalStateException.class, () ->{
			sistema.devolverBilletes("LocNor2",1);
		});
	} //no se habia comprado los billetes solo se habian añadido a el arraylist usado 
          // para comparar. Ademas no hace falta crear el billete a devolver.
	
	@Test
	void testDevolverBilleteEnSistemaNoValidoLocalizadorNulo(){
		Sistema sistema = new Sistema();
		sistema.comprarBilletes("locNorm", usuario, recorrido1, 1);
		assertThrows(IllegalStateException.class, () ->{
			sistema.devolverBilletes(null,1);
		});
	}//lo mismo que el anterior
	
	@Test
	void testDevolverBilleteEnSistemaNoValidoNumBilletesMenorQueUno(){
		Sistema sistema = new Sistema();
		sistema.comprarBilletes("locNorm", usuario, recorrido1, 1);
		assertThrows(IllegalStateException.class, () ->{
			sistema.devolverBilletes("locNorm",0);
		});
	} //Mismo que el anterior. Ademas no se habia cambiado el null del anterior test, 
          //por lo que eran dos casos no validos a la vez
	
	@Test
	void testComprarVariosBilletesEnSistema(){
		Sistema sistema = new Sistema();
		ArrayList<Billete> billetes = new ArrayList<Billete>();
		Billete billetePrueba = new Billete("LocNorm", recorrido1, usuario);
		for(int i = 1; i<4; i++) {
			billetes.add(billetePrueba);
		}
		sistema.comprarBilletes("LocNorm",usuario,recorrido1,3);
		assertEquals(billetes,sistema.getBilletes());
	}
	
	
	@Test
	void testComprarBilleteEnSistemaNoValidoPlazasInsuficientes(){
		Sistema sistema = new Sistema();
		assertThrows(IllegalStateException.class, () ->{
			sistema.comprarBilletes("LocNorm",usuario,recorrido1,6);
		});
	}
	
	@Test
	void testComprarBilleteEnSistemaNoValidoLocalizadorNulo(){
		Sistema sistema = new Sistema();
		assertThrows(IllegalStateException.class, () ->{
			sistema.comprarBilletes(null,usuario,recorrido1,5);
                     // no se habia cambiado el 6. Dos casos no validos a la vez.
		});
	}
	
	@Test
	void testComprarBilleteEnSistemaNoValidoUsuarioNulo(){
		Sistema sistema = new Sistema();
		assertThrows(IllegalStateException.class, () ->{
			sistema.comprarBilletes("LocNorm",null,recorrido1,5);
                        //mismo que anterior
		});
	}
	
	@Test
	void testComprarBilleteEnSistemaNoValidoRecorridoNulo(){
		Sistema sistema = new Sistema();
		assertThrows(IllegalStateException.class, () ->{
			sistema.comprarBilletes("LocNorm",usuario,null,6);
		});
	}
	
	@Test
	void testComprarBilleteEnSistemaNoValidoRecorridoNoExisteEnSistema(){
		Sistema sistema = new Sistema();
		sistema.añadirRecorrido(recorrido1);
		Recorrido recorridoNoEnSistema = new Recorrido("2","origen","destino","autobus",0,fecha,hora,5,1);
		assertThrows(IllegalStateException.class, () ->{
			sistema.comprarBilletes("LocNorm",usuario,recorridoNoEnSistema,6);
		});
	}
	
	@Test
	void testComprarBilleteEnSistemaNoValidoNumeroDeBilletesMenorQueUno(){
		Sistema sistema = new Sistema();
		assertThrows(IllegalStateException.class, () ->{
			sistema.comprarBilletes("LocNorm",usuario,recorrido1,0);
		});
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
	

}
