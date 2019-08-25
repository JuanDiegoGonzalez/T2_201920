package view;

import model.logic.MVCModelo;

public class MVCView 
{
	    /**
	     * Metodo constructor
	     */
	    public MVCView()
	    {}
	    
	    /**
	     * Imprime en consola el menú de la aplicación
	     */
		public void printMenu()
		{
			System.out.println("1. Cargar archivo de viajes - Primer trimestre");
			System.out.println("2. Buscar cluster más grande de viajes ordenados ascendentemente por hora a partir de una hora dada");
			System.out.println("3. Consultar últimos viajes para una hora dada");
			System.out.println("4. Exit");
			System.out.println("Dar el numero de opcion a resolver, luego oprimir tecla Return: (e.g., 1):");
		}
}