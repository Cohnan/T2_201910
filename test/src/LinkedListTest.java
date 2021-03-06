import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.data_structures.LinkedList;

/**
 * 
 */

/**
 * @author cohnan
 *
 */
class LinkedListTest {
	
	// Escenarios
	
	
	// Lista vacia
	private LinkedList<String> setUpEscenario0 () {
		return new LinkedList<String>();
	}
//	
	// Lista con 1 elemento
	private LinkedList<String> setUpEscenario1 () {
		LinkedList<String> lista = new LinkedList<> ();
		lista.anadir("Elemento 1");
		
		return lista;
	}
	
	// Lista con 2 elementos
	private LinkedList<String> setUpEscenario2 () {
		LinkedList<String> lista = new LinkedList<> ();
		lista.anadir("Elemento 1");
		lista.anadir("Elemento 2");
		
		return lista;
	}

	// Lista con 3 elementos
	private LinkedList<String> setUpEscenario3 () {
		LinkedList<String> lista = new LinkedList<> ();
		lista.anadir("Elemento 1");
		lista.anadir("Elemento 2");
		lista.anadir("Elemento 3");
		
		return lista;
	}

/*
	*//**
	 * @throws java.lang.Exception
	 *//*
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	*//**
	 * @throws java.lang.Exception
	 *//*
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	*//**
	 * @throws java.lang.Exception
	 *//*
	@BeforeEach
	void setUp() throws Exception {
	}

	*//**
	 * @throws java.lang.Exception
	 *//*
	@AfterEach
	void tearDown() throws Exception {
	}
*/	
	
	/**
	 * Test method for {@link model.data_structures.LinkedList#LinkedList()}.
	 */
	@Test
	void testLinkedList() {
		LinkedList lista = setUpEscenario0();
		
		assertTrue(lista.darTamano() == 0, "El tamano deberia ser 0");
		try {
			lista.darActual();
		} catch(UnsupportedOperationException e) {
			// Debe llegar aca
		}
	}

	/**
	 * Test method for {@link model.data_structures.LinkedList#iterator()}.
	 */
	@Test
	void testIterator() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link model.data_structures.LinkedList#anadir(java.lang.Object)}.
	 */
	@Test
	void testAnadir() {
		LinkedList[] listas = {setUpEscenario0(), setUpEscenario1(), setUpEscenario2(), setUpEscenario3()};
		LinkedList lista;
		
		for (int i = 0; i < listas.length; i++) {
			lista = listas[i];
			lista.anadir("Elemento anadido");
			assertTrue(lista.darTamano() == i + 1, "El tamano de la lista debio aumentar en 1.");
			Object dato = lista.darActual();
			if (i == 0) {
				assertTrue(dato.equals("Elemento anadido"), "El elemento en la lista deberia ser el recien agregado");
			}
		}
	}


	/**
	 * Test method for {@link model.data_structures.LinkedList#eliminar(java.lang.Object)}.
	 */
	@Test
	void testEliminar() {
		LinkedList[] listas = {setUpEscenario1(), setUpEscenario2(), setUpEscenario3()};
		LinkedList lista;
		
		for (int i = 0; i < listas.length; i++) {
			lista = listas[i]; // i es el tamano de la lista menos 1
			System.out.println(i+1);
			lista.eliminar("Elemento 1");
			System.out.println("Lo puede hacer\n");
			assertTrue(lista.darTamano() == i, "El tamano de la lista debio disminuir en 1.");
			assertTrue(lista.darActual() != null, "Actual deberia existir.");
		}
	}

	/**
	 * Test method for {@link model.data_structures.LinkedList#recuperarEnPos(int)}.
	 */
	@Test
	void testRecuperarEnPos() {
		LinkedList[] listas = {setUpEscenario1(), setUpEscenario2(), setUpEscenario3()};
		LinkedList lista;
		
		for (int i = 0; i < listas.length; i++) {
			lista = listas[i]; // i es el tamano de la lista menos 1
			for (int j = 1; j < i+1; j++) {
				assertTrue(lista.recuperarEnPos(j - 1).equals("Elemento " + j));
			}
		}
	}

	/**
	 * Test method for {@link model.data_structures.LinkedList#reiniciarRecorrido()}.
	 */
	@Test
	void testReiniciarRecorrido() {
		LinkedList[] listas = { setUpEscenario2(), setUpEscenario3()};
		LinkedList lista;
		
		for (int i = 0; i < listas.length; i++) {
			lista = listas[i];
			lista.avanzar();
			lista.reiniciarRecorrido();
			assertTrue(lista.darActual().equals("Elemento 1"), "No reinicia correctamente");
		}
	}

	/**
	 * Test method for {@link model.data_structures.LinkedList#avanzar()}.
	 */
	@Test
	void testAvanzar() {
		LinkedList[] listas = {setUpEscenario2(), setUpEscenario3()};
		LinkedList lista;
		
		for (int i = 0; i < listas.length; i++) {
			lista = listas[i];
			assertTrue(lista.avanzar().equals("Elemento 2"), "No avanza correctamente");
		}
	}

	/**
	 * Test method for {@link model.data_structures.LinkedList#retroceder()}.
	 */
	@Test
	void testRetroceder() {
		LinkedList[] listas = {setUpEscenario2(), setUpEscenario3()};
		LinkedList lista;
		
		for (int i = 0; i < listas.length; i++) {
			lista = listas[i];
			lista.avanzar();
			assertTrue(lista.retroceder().equals("Elemento 1"), "No retrocede correctamente");
		}
	}

	/**
	 * Test method for {@link model.data_structures.LinkedList#tieneSiguiente()}.
	 */
	@Test
	void testTieneSiguiente() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link model.data_structures.LinkedList#tieneAnterior()}.
	 */
	@Test
	void testTieneAnterior() {
		fail("Not yet implemented");
	}

}