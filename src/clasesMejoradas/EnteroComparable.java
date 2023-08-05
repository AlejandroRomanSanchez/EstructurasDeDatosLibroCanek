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
    
    public int compareTo(EnteroComparable enteroComparable) {
	return 0;
    }
}