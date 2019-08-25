package controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import model.data_structures.Queue;
import model.logic.MVCModelo;
import view.MVCView;

public class Controller {

	/* Instancia del Modelo*/
	private MVCModelo modelo;

	/* Instancia de la Vista*/
	private MVCView view;

	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new MVCView();
		modelo = new MVCModelo();
	}

	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;

		while( !fin ){

			view.printMenu();

			String in;
			in = lector.next();

			int option;

			try
			{
				option = Integer.parseInt(in);
			}
			catch(NumberFormatException e)
			{
				option = 0;
			}			

			switch(option)
			{
			case 1:

				try
				{
					int numElementos = modelo.cargarArchivoCSV();
					System.out.println("Archivo cargado. Número de elementos: " + numElementos + "\n---------");

					Double[] datosPrimero = modelo.darPrimerDato();
					Double[] datosUltimo = modelo.darUltimoDato();

					System.out.println("Datos primer viaje: Id zona de origen: " + datosPrimero[0] + "; Id zona de destino: " + datosPrimero[1] + "; Hora: " + datosPrimero[2] + "; Tiempo promedio: " + datosPrimero[3]);
					System.out.println("Datos último viaje: Id zona de origen: " + datosUltimo[0] + "; Id zona de destino: " + datosUltimo[1] + "; Hora: " + datosUltimo[2] + "; Tiempo promedio: " + datosUltimo[3] + "\n---------");
				}
				catch(Exception e)
				{
					System.out.println("Se produjo un error al cargar los archivos.\n---------");
				}

				break;

			case 2:

				System.out.println("--------- \nDar hora inicial para la búsqueda: ");

				in = lector.next();
				int horaInicial;					

				try
				{
					horaInicial = Integer.parseInt(in);
				}
				catch(NumberFormatException e)
				{
					System.out.println("Debe ingresar un número.\n---------");
					break;
				}					

				if(horaInicial < 0 || horaInicial > 23)
				{
					System.out.println("Debe ingresar una hora válida.\n---------");
					break;
				}

				Queue respuesta = modelo.darClusterMasGrande(horaInicial);

				System.out.println("Número de viajes del cluster: " + respuesta.darNumeroElementos());

				while(respuesta.darNumeroElementos()>0)
				{
					Double[] datos = (Double[]) respuesta.dequeue();
					System.out.println("Hora: " + datos[2] + "; Id zona de origen: " + datos[0] + "; Id zona de destino: " + datos[1] + "; Tiempo promedio: " + datos[3]);
				}

				System.out.println("---------");
				break;

			case 3:

				int numeroViajesBuscados;
				int horaBuscada;
				try
				{
					System.out.println("--------- \nDar cantidad de viajes a buscar: ");
					numeroViajesBuscados = lector.nextInt();
					System.out.println("--------- \nDar hora a buscar: ");
					horaBuscada = lector.nextInt();
				}
				catch(InputMismatchException e)
				{
					System.out.println("Debe ingresar valores numéricos\n---------");
					break;
				}

				if(numeroViajesBuscados < 0 || horaBuscada < 0 || horaBuscada > 23)
				{
					System.out.println("Debe ingresar valores válidos\n---------");
					break;
				}

				Queue listaRespuesta = modelo.darUltimosViajesSegunHora(numeroViajesBuscados, horaBuscada);

				if(listaRespuesta.darNumeroElementos() == 0)
				{
					System.out.println("No hay viajes registrados a esa hora.\n---------");
					break;
				}

				while(listaRespuesta.darNumeroElementos()>0)
				{
					Double[] datos = (Double[]) listaRespuesta.dequeue();
					System.out.println("Hora: " + datos[2] + "; Id zona de origen: " + datos[0] + "; Id zona de destino: " + datos[1] + "; Tiempo promedio: " + datos[3]);
				}

				System.out.println("---------");
				break;

			case 4: 
				System.out.println("--------- \n Hasta pronto !! \n---------"); 
				lector.close();
				fin = true;
				break;	

			default: 
				System.out.println("--------- \n Opcion Invalida !! \n---------");
				break;
			}
		}
	}
}