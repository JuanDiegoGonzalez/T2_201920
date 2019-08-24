package model.data_structures;

public class Queue <T extends Comparable<T>> implements IQueue <T> 
{
	
	private Node back;
	
	private int numeroElementos;
	private Node front;


	public Queue()
	{
		front = null;
		back = null;
		
		numeroElementos = 0;
		
	}
	public void enqueue(T item) 
	{
		if(back != null)
		{
		Node m = new Node();
		
		m.asignarDato(item);
		back.asignarSiguiente(m);
		back = m;		


		
		}
		else
		{
			Node m = new Node();
			m.asignarDato(item);
			front = m;
			back = m;
		}
		numeroElementos++;
	}


	public T dequeue()
	{
		T x= (T) front.darDato();
		front = front.darSiguente();
		
		return x;
	
	}
	public int darNumeroElementos()
	{
		return numeroElementos;
	}

}
