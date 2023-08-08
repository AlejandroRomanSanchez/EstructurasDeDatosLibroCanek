package pruebas;

import clasesMejoradas.Arreglo;
import java.lang.Comparable;
import java.util.Comparator;

/**
 * Esta clase sirve para hacer preubas a la clase Arreglo
 * @author Alejandro Román Sánchez
 * @version 04 de agosto del 2023
 * @since Libro de Canek
 */
public class PruebaArreglo {
    /**
     * Este es el método main de la clase. En este método hacemos las pruebas para la clase Arreglo
     */
    public static void main(String[ ] args) {
	// Creamos los arreglo que vamos a usar en las pruebas
	Integer[ ] arregloVacio = { }; // Un arreglo sin elementos que usaremos para las pruebas
	// Arreglo de enteros que usaremos para las pruebas
	Integer[ ] arregloEnteros = {4, 0, 2, 1, 5};
	// Esta arreglo servirá para ordenarlo por medio del método selectionSort
	Integer[ ] arregloParaSelectionSort = {21, 8, 8, 38, 43, 17, 26, 97, 40, 27, 6, 34, 76, 86, 66, 81, 75,
					       95, 51, 52};
	// En esta variable se guardarán los sub-arreglos creados conforme vayan siendo creados
	Object[ ] subArreglo;	
	
	/* Comienza pruebas para el método imprimeArreglo( ) aplicado a null, el arreglo vacío y un arreglo con
	 * enteros comparables
	 */
	System.out.println("\nLos arreglos que vamos a utilizar para las pruebas:");
	System.out.println("\nParámetro null: " + Arreglo.construyeCadenaDeArreglo(null));
	System.out.println("Arreglo vacío: "+ Arreglo.construyeCadenaDeArreglo(arregloVacio));
	System.out.println("Arreglo de enteros: " + Arreglo.construyeCadenaDeArreglo(arregloEnteros) + "\n");

	/* Comenzamos las pruebas para el método creaSubArregloDe( ) mediante null, un arreglo vacío y un arreglo
	 * con enteros comparables
	 */
	System.out.println("Pruebas para el método creaSubArreglo:\n");
	try {
	    Arreglo.creaSubArregloDe(null, 4, 1);
	} catch(NullPointerException excepcion) {
	    System.out.println("Excepción por tener el primer parámetro como null\n");
	}

	System.out.println("Sub-arreglo de un arreglo vacío:" );
	subArreglo = Arreglo.creaSubArregloDe(arregloVacio, 4, 9);
	System.out.println("El sub-arreglo es: " + Arreglo.construyeCadenaDeArreglo(subArreglo) + "\n");
	
	System.out.println("Los siguientes sub-arreglos son para el arreglo: "
			   + Arreglo.construyeCadenaDeArreglo(arregloEnteros) + "\n");
	System.out.println("Sub-arreglo que comeinza en el índice -1 y termina en el índice 4");
	subArreglo = Arreglo.creaSubArregloDe(arregloEnteros, -1, 4);
	System.out.println("El sub-arreglo es: " + Arreglo.construyeCadenaDeArreglo(subArreglo) + "\n");

	System.out.println("Sub-arreglo que comienza en el índice 2 y termina en el índice 5");
	subArreglo = Arreglo.creaSubArregloDe(arregloEnteros, 2, 5);
	System.out.println("El sub-arreglo es: " + Arreglo.construyeCadenaDeArreglo(subArreglo) + "\n");

	System.out.println("Sub-arreglo que comienza en el índice 3 y termina en el índice 9");
	subArreglo = Arreglo.creaSubArregloDe(arregloEnteros, 3, 9);
	System.out.println("El sub-arreglo es: " + Arreglo.construyeCadenaDeArreglo(subArreglo) + "\n");
   
	System.out.println("Sub-arreglo que comienza con el índice 4 y termina en el índice 2:");
	subArreglo = Arreglo.creaSubArregloDe(arregloEnteros, 4, 2);
	System.out.println("El sub-arreglo es: " + Arreglo.construyeCadenaDeArreglo(subArreglo) + "\n");

	System.out.println("Sub-arreglo que comienza en el índice 2 y termina en ese mismo índice:");
	subArreglo = Arreglo.creaSubArregloDe(arregloEnteros, 2, 2);
	System.out.println("El sub-arreglo es: " + Arreglo.construyeCadenaDeArreglo(subArreglo) + "\n");

	System.out.println("Sub-arreglo que comienza en el índice 0 y termina en el índice 1:");
	subArreglo = Arreglo.creaSubArregloDe(arregloEnteros, 0, 1);
	System.out.println("El sub-arreglo es: " + Arreglo.construyeCadenaDeArreglo(subArreglo) + "\n");

	System.out.println("Sub-arreglo que comienza en el índice 1 y termina en el índice 3:");
	subArreglo = Arreglo.creaSubArregloDe(arregloEnteros, 1, 3);
	System.out.println("El sub-arreglo es: " + Arreglo.construyeCadenaDeArreglo(subArreglo) + "\n");

	// Comienzan las pruebas para el método búsquedaBinaria(arreglo, elemento)	
	Integer[ ] enterosOrdenados = {12, 14, 21, 33, 50, 50, 53, 53, 53, 53};
	Integer elementoABuscar;
	String cadenaDeArregloOrdenado = Arreglo.construyeCadenaDeArreglo(enterosOrdenados);

	System.out.println("Comienzan las pruebas para el método busquedaBinaria");
	
	try {
	    System.out.println("Índice que guardar a la cadena 'Java' en null:"
			       + Arreglo.busquedaBinaria(null, "Java"));
	} catch(NullPointerException excepcion) {
	    System.out.println("Excepción por ingresar null como primer parámetro\n");
	}
	    
	System.out.println("Arrreglo ordenado con enteros: " + cadenaDeArregloOrdenado);
	System.out.println("Índice que guarda el número 6 en el arreglo ordenado: "
			   + Arreglo.busquedaBinaria(enterosOrdenados, 6));

	System.out.println("Índice que guarda el número 33 en el arreglo ordenado: "
			   + Arreglo.busquedaBinaria(enterosOrdenados, 33));

	for(int i = 0; i < enterosOrdenados.length; i++) {
	    elementoABuscar = enterosOrdenados[i];
	    System.out.println("Índice que guarda el número " + elementoABuscar + " en el arreglo ordenado: "
			       + Arreglo.busquedaBinaria(enterosOrdenados, elementoABuscar)+ "\n");
	}

	// Comienzan las pruebas para el método estaEnElRango( )
	System.out.println("Pruebas para el método estaEnElRango( )");
	System.out.println("El número -3 es índice de " + cadenaDeArregloOrdenado + " : "
			   + Arreglo.estaEnElRango(enterosOrdenados, -3));
	
	System.out.println("El número 4 es índice de " + cadenaDeArregloOrdenado + " : "
			   + Arreglo.estaEnElRango(enterosOrdenados, 4));

	System.out.println("El número 20 es índice de " + cadenaDeArregloOrdenado + " : "
			   + Arreglo.estaEnElRango(enterosOrdenados, 20));

	try {
	    Arreglo.estaEnElRango(null, 7);
	} catch(NullPointerException excepcion) {
	    System.out.println("Excepción por ingresar a null como primer parámetro\n");
	}

	// Comienzan las pruebas para el método intercambiaLosIndicesDe( )
	System.out.println("Pruebas para el método intercambiaLosIndicesDe( )");

	try {
	    Arreglo.intercambiaLosIndicesDe(null, 6, 19);
	} catch(NullPointerException excepcion) {
	    System.out.println("Excepción por ingresar null como primer parámetro");
	}

	System.out.println("Intercambia los índices 6 y 19 del arreglo vacío");
	Arreglo.intercambiaLosIndicesDe(arregloVacio, 6, 19);
	System.out.println(Arreglo.construyeCadenaDeArreglo(arregloVacio));

	System.out.println("Intercambia los índices 6 y 19 del arreglo ordenado con enteros");
	Arreglo.intercambiaLosIndicesDe(enterosOrdenados, 6, 19);
	System.out.println(Arreglo.construyeCadenaDeArreglo(enterosOrdenados));

	System.out.println("Intercambia los índices 6 y 1 del arreglo ordenado con enteros");
	Arreglo.intercambiaLosIndicesDe(enterosOrdenados, 6, 1);
	System.out.println(Arreglo.construyeCadenaDeArreglo(enterosOrdenados)+ "\n");

	// Comienzan las pruebas para el método quickSort(arreglo, indiceInferior, indiceSuperior, comparador)
	System.out.println("Pruebas para el método quickSort(arreglo, indiceInferior, indiceSuperior, "
			   + "comparador)");
	// Prueba de quickSort para un arreglo vacío
	System.out.println("Estado inicial del arreglo: "
			   + Arreglo.construyeCadenaDeArreglo(arregloVacio));
	Arreglo.quickSort(arregloVacio);
	System.out.println("Ahora el arreglo sin previo orden ahora es: "
			   + Arreglo.construyeCadenaDeArreglo(arregloVacio) + "\n");
	// Prueba de quickSort para un arreglo no vacío
	System.out.println("Estado inicial del arreglo "
			   + Arreglo.construyeCadenaDeArreglo(arregloEnteros));
	Arreglo.quickSort(arregloEnteros);
	System.out.println("Ahora el arreglo sin previo orden es: "
			   + Arreglo.construyeCadenaDeArreglo(arregloEnteros) + "\n");
	// Prueba de quickSort para un arreglo no vacío
	System.out.println("Estado inicial del arreglo: "
			   + Arreglo.construyeCadenaDeArreglo(enterosOrdenados));
	Arreglo.quickSort(enterosOrdenados);
	System.out.println("Ahora el arreglo sin previo orden ahora es: "
			   + Arreglo.construyeCadenaDeArreglo(enterosOrdenados) + "\n");

	// Comienzan las pruebas para selectionSort
	System.out.println("Pruebas para selectionSort");
	
	System.out.println("Estado inicial del arreglo: "
			   + Arreglo.construyeCadenaDeArreglo(arregloParaSelectionSort));
	Arreglo.quickSort(arregloParaSelectionSort);
	System.out.println("El mismo arreglo ahora ordenado por selectionSort: "
			   + Arreglo.construyeCadenaDeArreglo(arregloParaSelectionSort) + "\n");
    }
}
