package pruebas;

import clasesMejoradas.EnteroComparable;

/**
 * Esta clase sirve para hacer pruebas a la clase EnteroComparable
 * @author Alejandro Román Sánchez
 * @version 5 de agosto del 2023
 * @since Libro de Canek
 */
public class PruebaEnteroComparable {
    /**
     * Este es el método main para la clase que nos permite probar a EnteroComparable
     */
    public static void main(String[ ] args) {
	// Creamos los objetos que usaremos para hacer las pruebas
	EnteroComparable entero1 = new EnteroComparable(5);
	EnteroComparable entero2 = new EnteroComparable(11);
	EnteroComparable entero3 = new EnteroComparable(11);

	// Probamos el método toString( ) de la clase EnteroComparable
	System.out.println("\nEl entero1 es: " + entero1.toString( ));
	System.out.println("El entero2 es: " + entero2.toString( ));
	System.out.println("El entero3 es: " + entero3.toString( ));

	// Probamos el método compareTo( ) de la clase EnteroComparable
	System.out.println("\nEl entero1 es menor que el entero2: " + entero1.compareTo(entero2));
	System.out.println("El entero2 es igual que el entero3: " + entero2.compareTo(entero3));
	System.out.println("El entero2 es mayor que el entero1: " + entero2.compareTo(entero1));
    }
}
