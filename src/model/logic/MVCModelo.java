package model.logic;

import java.io.FileReader;

import com.opencsv.CSVReader;

import model.data_structures.INode;
import model.data_structures.Node;
import model.data_structures.Queue;
import model.data_structures.Stack;

/**
 * Definicion del modelo del mundo
 */
public class MVCModelo {
	/**
	 * Atributos del modelo del mundo
	 */
	private Stack stack;

	private Queue queue;

	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public MVCModelo()
	{
		stack = new Stack();
		queue = new Queue();
	}

	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamano()
	{
		return stack.darNumeroElementos();
	}

	/**
	 * Metodo que carga el archivo CSV
	 */
	public int cargarArchivoCSV() throws Exception
	{
		boolean primeraLectura = true;

		CSVReader reader = new CSVReader(new FileReader("./data/prueba.csv"));

		for(String[] line: reader)
		{
			if(!primeraLectura)
			{
				Double[] dato = {Double.parseDouble(line[0]), Double.parseDouble(line[1]), Double.parseDouble(line[2]), Double.parseDouble(line[3]), Double.parseDouble(line[4]), Double.parseDouble(line[5]), Double.parseDouble(line[6])}; 
				stack.push(dato);
				queue.enqueue(dato);
			}
			primeraLectura = false;
		}
		reader.close();
		return stack.darNumeroElementos();
	}	

	public Double[] darPrimerDato()
	{
		return (Double[]) queue.darPrimerDato();
	}

	public Double[] darUltimoDato()
	{
		return (Double[]) queue.darUltimoDato();
	}

	public Queue darClusterMasGrande(int horaInicial)
	{
		Queue respuesta = new Queue();
		Queue actual = new Queue();
		double horaActual = horaInicial;

		while(queue.darNumeroElementos()>0)
		{
			Double[] datoActual = (Double[]) queue.dequeue();

			if(datoActual[2] >= horaActual)
			{
				actual.enqueue(datoActual);
				horaActual = datoActual[2];
			}
			else if(actual.darNumeroElementos() > respuesta.darNumeroElementos())
			{
				while(respuesta.darNumeroElementos()>0)
				{
					respuesta.dequeue();
				}

				while(actual.darNumeroElementos()>0)
				{
					respuesta.enqueue(actual.dequeue());
				}
				horaActual = horaInicial;
				
				if(datoActual[2] >= horaActual)
				{
					actual.enqueue(datoActual);
					horaActual = datoActual[2];
				}
			}
			else
			{
				while(actual.darNumeroElementos()>0)
				{
					actual.dequeue();
				}
				horaActual = horaInicial;
				
				if(datoActual[2] >= horaActual)
				{
					actual.enqueue(datoActual);
					horaActual = datoActual[2];
				}
			}	
		}

		return respuesta;
	}

	public Queue darUltimosViajesSegunHora(int numViajes, int hora)
	{
		Queue respuesta = new Queue();
		
		while(respuesta.darNumeroElementos() < numViajes && stack.darNumeroElementos() > 0)
		{
			Double[] datos = (Double[]) stack.pop();
			
			if(datos[2] == hora)
			{
				respuesta.enqueue(datos);
			}			
		}		
		return respuesta;
	}
}