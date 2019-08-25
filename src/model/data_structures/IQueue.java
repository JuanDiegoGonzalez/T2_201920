package model.data_structures;

public interface IQueue <T> 
{
	/**
	 * Añade un elemento al final de la cola
	 * @param item elemento a añadir
	 */
	public void enqueue(T item);
	
	/**
	 * Saca el elemento al frente de la cola
	 * @return el elemento al frente de la cola
	 */
	public T dequeue();
	
	/**
	 * Retorna el número de elementos de la cola
	 * @return el número de elementos de la cola
	 */
	public int darNumeroElementos();
}