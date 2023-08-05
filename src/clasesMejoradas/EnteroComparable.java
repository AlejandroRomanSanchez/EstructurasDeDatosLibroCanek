package clasesMejoradas;

import java.util.Comparator;

/**
 * Esta clase es una implementación de la interfaz Comparable
 * @author Alejandro Román Sánchez
 * @version 5 de agosto del 2023
 * @since Libro de Canek
 */
public class EnteroComparable implements Comparable<EnteroComparable> {
    private int entero; // Este es el entero que representa el objeto de esta clase

    /**
     * Este es el contructor de la clase EnteroComparable
     * @param entero Es el entero que representa el objeto a crear
     */
    public EnteroComparable(int entero) {
	this.entero = entero; // El parámetro es el entero que representa el objeto a crear
    }

    /**
     * Este método devuelve el entero que representa el objeto
     * @return Es el entero que representa el objeto
     */
    public int getEntero( ) {
	// Solamente devolvemos el entero representado por el objeto
	return this.entero;
    }

    /**
     * Este método sobre-escrito compara el objeto con otro objeto de la clase EnteroComparable
     * @param enteroComparable Un objeto de la clase EnteroComparable
     * @return Si el atributo entero del objeto llamador es menor que el atributo entero del
     * objeto parámetro, se devuelve -1. Si estos atributos son iguales, se devuelve 0. Si el
     * atributo entero del llamador es mayor que el atributo entero del parámetro, se devuelve
     * 1
     */
    @Override
    public int compareTo(EnteroComparable enteroComparable) {
	int enteroLlamador = this.getEntero( ); // Este es el atributo entero del objeto llamador
	int enteroParametro = enteroComparable.getEntero( ); // Este es el atributo entero del objeto parámetro

	/* Si el entero del llamador es menor que el entero del parámetro, entonces el objeto llamador es menor
	 * que el objeto parámetro
	 */
	if(enteroLlamador < enteroParametro) {
	    return -1;
	}

	// Si el entero del llamador es igual al entero del parámetro, entonces ambos objetos son iguales
	if(enteroLlamador == enteroParametro) {
	    return 0;
	}

	/* Si el entero del llamador es mayor que el entero del parámetro, entonces el objeto llamador es mayor
	 * que el objeto parámetro
	 */
	return 1;
    }

    /**
     * Este método devuelve una cadena con el atributo entero del objeto invocador
     * @return Una cadena que indica el entero equivalente al objeto invocador
     */
    public String toString( ) {
	// Esta variable hace referencia al integer equivalente al objeto invocador
	Integer integerEquivalente = new Integer(this.getEntero( ));
	/* Obtenemos la cadena con el entero equivalente al objeto invocador por medio de aplicar el método
	 * toString( ) de la clase Integer al integer equivalente al invocador
	 */
	String cadenaResultante = integerEquivalente.toString( ); 

	return cadenaResultante;
    }
}
