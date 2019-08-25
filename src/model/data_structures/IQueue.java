package model.data_structures;

public interface IQueue <T> 
{
	/**
	 * A�ade un elemento al final de la cola
	 * @param item elemento a a�adir
	 */
	public void enqueue(T item);
	
	/**
	 * Saca el elemento al frente de la cola
	 * @return el elemento al frente de la cola
	 */
	public T dequeue();
	
	/**
	 * Retorna el n�mero de elementos de la cola
	 * @return el n�mero de elementos de la cola
	 */
	public int darNumeroElementos();
}