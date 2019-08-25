package test.logic;

import static org.junit.Assert.*;
import model.logic.MVCModelo;

import org.junit.Before;
import org.junit.Test;

public class TestMVCModelo {
	
	private MVCModelo modelo;

	
	@Before
	public void setUp1() {
		modelo= new MVCModelo();
	}
	
	public void setUp2() {
		modelo= new MVCModelo();
		try {
			modelo.cargarArchivoCSV();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Test
	public void testMVCModelo() {
		assertTrue(modelo!=null);
		assertEquals(0, modelo.darTamano());  // Modelo con 0 elementos presentes.
	}

	@Test
	public void testDarTamano() {
		setUp2();
		assertTrue( modelo.darTamano()> 0);  // Modelo con mas de  0 elementos presentes.
	}



}
