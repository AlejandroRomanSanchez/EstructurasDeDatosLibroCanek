package pruebas;

import clasesMejoradas.Arreglo;

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
	Integer[ ] arregloVacio = { }; // Un arreglo sin elementos que usaremos para las pruebas
	Integer[ ] arregloEnteros = {4, 0, 2, 1, 5}; // Arreglo de enteros que usaremos para las pruebas

	/* Comienza pruebas para el método imprimeArreglo aplicado a null, el arreglo vacío y un arreglo con
	 * enteros
	 */
	System.out.println("\nParámetro null: " + Arreglo.construyeCadenaDeArreglo(null));
	System.out.println("Arreglo vacío: "+ Arreglo.construyeCadenaDeArreglo(arregloVacio));
	System.out.println("Arreglo de enteros: " + Arreglo.construyeCadenaDeArreglo(arregloEnteros) + "\n");
	
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

	try {
	    System.out.println("Sub-arreglo que comienza en el índice 4 y termina en ese mismo índice\n");
	    Arreglo.creaSubArregloDe(arregloEnteros, 4, 4);
	} catch(Exception excepcion) {
	    System.out.println("Algo no contemplado sucedió, revisa el código\n");
	}
    }
}
