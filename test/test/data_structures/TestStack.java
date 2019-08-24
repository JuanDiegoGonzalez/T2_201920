package test.data_structures;

import static org.junit.Assert.*;

import org.junit.Test;

import model.data_structures.Stack;

public class TestStack
{
	private Stack stack;

	public void setUp1() 
	{
		stack = new Stack();
		stack.push("Hola");
	}
	
	public void setUp2() 
	{
		int x = 1;
		int y = 2;
		stack= new Stack();
		stack.push(x);
		stack.push(y);
		stack.push(x);
	}
	
	@Test
	public void testNumeroElementos()
	{
		setUp1();
		assertEquals(1, stack.darNumeroElementos());
	}
	
	@Test
	public void testNode2()
	{
		setUp2();
		
		assertEquals(1, stack.pop());
		
		//Con el setUp2 y esta l�nea se prueban todos los m�todos de la clase.
		assertEquals(2, stack.pop());
	}
}
