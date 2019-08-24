package test.data_structures;

import static org.junit.Assert.assertEquals;



import org.junit.Test;

import model.data_structures.Queue;
import model.data_structures.Stack;

public class TestQueue 
{
	private Queue queue;

	public void setUp1() 
	{
		queue = new Queue();
		queue.enqueue("Hola");
	}
	
	public void setUp2() 
	{
		int x = 1;
		int y = 2;
		queue= new Queue();
		queue.enqueue(x);
		queue.enqueue(y);
	}
	
	@Test
	public void testNumeroElementos()
	{
		setUp1();
		assertEquals(1, queue.darNumeroElementos());
	}
	
	@Test
	public void testNode2()
	{
		setUp2();
		
		assertEquals(1, queue.dequeue());
		
		//Con el setUp2 y esta línea se prueban todos los métodos de la clase.
		assertEquals(2, queue.dequeue());
	}
}
