package model.data_structures;

public class Stack<T extends Comparable<T>> implements IStack<T>
{
	private T[] elementos;
	private int tamanio;
	private int numeroElementos;
	private T top;

	public Stack()
	{
		tamanio = 1;
		elementos = (T[]) new Object[ tamanio];
		top = null; 
		numeroElementos = 0;
	}


	public void push(T item)
	{

		if(numeroElementos == tamanio)
		{
			tamanio = tamanio*2;	

			T [ ] copia = elementos;
			elementos = (T[]) new Object[tamanio];
			for ( int i = 0; i < tamanio; i++)
			{
				elementos[i] = copia[i];
			} 

		}	
		elementos[numeroElementos] = item;
		top = item;


		numeroElementos++;


	}

	@Override
	public T pop() 
	{
		T x = top;
		elementos[numeroElementos-1] =null;
		top = elementos[numeroElementos-2];
		numeroElementos --;
		if(numeroElementos == (tamanio/4))
		{
			tamanio = tamanio/2;	

			T [ ] copia = elementos;
			elementos = (T[]) new Object[tamanio];
			for ( int i = 0; i < tamanio; i++)
			{
				elementos[i] = copia[i];
			} 

		}

		return x;
		
	}





}