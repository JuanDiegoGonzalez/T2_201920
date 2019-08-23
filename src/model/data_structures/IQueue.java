package model.data_structures;

public interface IQueue <T extends Comparable<T>> 
{
public void enqueue(T item);
public T dequeue();
}
