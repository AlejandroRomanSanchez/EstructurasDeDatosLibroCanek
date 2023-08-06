package pruebas;

import clasesMejoradas.Arreglo;
import clasesMejoradas.EnteroComparable;

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
    public static void main(String[ ] args) throws Exception {
	/* Creamos los enteros comparables que vamos a guardar en el arreglo para las pruebas del método
	 * creaSubArregloDe( )
	 */
	EnteroComparable entero1 = new EnteroComparable(4);
	EnteroComparable entero2 = new EnteroComparable(0);
	EnteroComparable entero3 = new EnteroComparable(2);
	EnteroComparable entero4 = new EnteroComparable(1);
	EnteroComparable entero5 = new EnteroComparable(5);

	// Creamos los arreglo que vamos a usar en las pruebas
	EnteroComparable[ ] arregloVacio = { }; // Un arreglo sin elementos que usaremos para las pruebas
	// Arreglo de enteros que usaremos para las pruebas
	EnteroComparable[ ] arregloEnteros = {entero1, entero2, entero3, entero4, entero5};
	// En esta variable se guardarán los sub-arreglos creados conforme vayan siendo creados
	Comparable[ ] subArreglo;

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
	} catch(Exception excepcion) {
	    System.out.println("Excepción por tener el primer parámetro como null\n");
	}
	
	try {
	    Arreglo.creaSubArregloDe(arregloVacio, 4, 9);
	} catch(Exception excepcion) {
	    System.out.println("Excepción por tener un arreglo vacío como parámetro\n");
	}

	try {
	    Arreglo.creaSubArregloDe(arregloEnteros, -1, 4);
	} catch(Exception excepcion) {
	    System.out.println("Excepción por poner el extremo inferior como un índice negativo\n");
	}

	try {
	    Arreglo.creaSubArregloDe(arregloEnteros, 2, 5);
	} catch(Exception excepcion) {
	    System.out.println("Excepcion por poner el extremo superior igual a la longitud del arreglo\n");
	}

	try {
	    Arreglo.creaSubArregloDe(arregloEnteros, 3, 9);
	} catch(Exception excepcion) {
	    System.out.println("Excepción por poner el extremo superior mayor que la longitud del arreglo\n");
	}

	try {
	    Arreglo.creaSubArregloDe(arregloEnteros, 4, 2);
	} catch(Exception excepcion) {
	    System.out.println("Excepción por poner los extremos del sub-arreglo a crear al revés\n");
	}

	System.out.println("Sub-arreglo que comienza en el índice 2 y termina en ese mismo índice:");
	subArreglo =  Arreglo.creaSubArregloDe(arregloEnteros, 2, 2);
	System.out.println("El sub-arreglo es: " + Arreglo.construyeCadenaDeArreglo(subArreglo) + "\n");

	System.out.println("Sub-arreglo que comienza en el índice 0 y termina en el índice 1:");
	subArreglo = Arreglo.creaSubArregloDe(arregloEnteros, 0, 1);
	System.out.println("El sub-arreglo es: " + Arreglo.construyeCadenaDeArreglo(subArreglo) + "\n");

	System.out.println("Sub-arreglo que comienza en el índice 1 y termina en el índice 3:");
	subArreglo = Arreglo.creaSubArregloDe(arregloEnteros, 1, 3);
	System.out.println("El sub-arreglo es: " + Arreglo.construyeCadenaDeArreglo(subArreglo) + "\n");
    }
}
