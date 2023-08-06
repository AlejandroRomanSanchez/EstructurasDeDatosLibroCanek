package clasesMejoradas;

import java.util.Comparator;

/**
 * Esta clase agrega métodos estáticos tales que llevan a cabo operaciones sobre obejtos de la
 * clase Array.
 * @author Alejandro Román Sánchez
 * @param <T> debe ser un tipo que exteiende a la clase Operable<T>
 * @version 04 de agosto del 2023
 * @since Libro de Canek
 */
public class Arreglo {    
    public static <T> int busquedaBinaria(T[ ] arreglo, T elemento, Comparator<T> comparador) {
	int longitudDeArreglo;
	int puntoMedio;

	if(arreglo == null || arreglo.length == 0) {
	    return -1;
	}

	longitudDeArreglo = arreglo.length;
	puntoMedio = longitudDeArreglo / 2;

	if(comparador.compare(elemento, arreglo[puntoMedio]) == 0) {
	    return puntoMedio;
	}

	if(comparador.compare(elemento, arreglo[puntoMedio]) < 0) {
	    
	}

	return 0;
    }

    /**
     * Este método crea un sub-arreglo del arreglo parámetro. Los elementos guardados no son una copia de los del
     * arreglo original
     * @param arreglo Es el arreglo del cual se obtnedrá el sub-arreglo deseado
     * @param indiceInferior Es el índice del arreglo parámetro a partir del cual se tomará su elemento para que
     * sea el primer elemento del sub-arreglo a crear
     * @param indiceSuperior Es el índice del arreglo parámetro del cual se tomará su elemento para que sea el
     * último elemento del sub-arreglo a crear
     * @return Si el arreglo parámetro no es null y si los índices superior e inferior tienen sentido, entonces
     * obtenemos un sub-arreglo del arreglo parḿaetro restringido a esos índices
     */
    public static <T extends Comparable<T>> Comparable[ ] creaSubArregloDe(T[ ] arreglo, int indiceInferior,
								 int indiceSuperior)	
	throws Exception {
	Comparable[ ] subArreglo; // En esta variable se construirá el sub-arreglo a devolver	
	int longitudDeSubArreglo; // En esta variable se guardará la longitud del sub-arreglo a devolver

	// Si el primer argumento es null, lanzamos una excepción
	if(arreglo == null) {
	    throw new Exception("Null no debe ser el primer parámetro");
	}

	/* Si el arreglo parámetro no es null y alguno de los índices parámetros están fuera del rango de los
	 * índices del arreglo, lanzamos una excepción
	 */
	if(indiceInferior < 0 || indiceSuperior >= arreglo.length) {
	    throw new Exception("Alguno de los índices límites está fuera del rango del arreglo");
	}

	/* Si el arreglo parámetro no es null y si los índices de restricción están al revés, entonces lanzamos una
	 * excepción
	 */
	if(indiceInferior > indiceSuperior) {
	    throw new Exception("El índice inferior debe ser menor o igual que el indice superior");
	}

	/* Si el arreglo parámetro no es null y si los índices de restricción tienen sentido en su orden, procedemos
	 * a crear el sub-arreglo
	 */

	// Definimos la longitud del sub-arreglo que será devuelto
	longitudDeSubArreglo = 1 + indiceSuperior - indiceInferior; 
	subArreglo = new Comparable[longitudDeSubArreglo]; // Creamos el sub-arreglo que será devuelto

	/* Guardamos los elementos del arreglo parámetro que van del primer índice de restricción al segundo índice
	 * de restricción
	 */
	for(int i = 0; i < longitudDeSubArreglo; i++) {
	    subArreglo[i] = arreglo[indiceInferior + i];
	}

	return subArreglo;	
    }

    /**
     * Este método devuelve una cadena con el contenido del arreglo parámetro
     * @param arreglo Es el arreglo cuyo contenido será coloado en la cadena a devolver
     * @return Si el parámetro no es null, devuelve una cadena en el cual se indica el
     * contenido del arreglo. En caso contrario, solamente se devuelve la cadena "null"
     */
    public static <T> String construyeCadenaDeArreglo(T[ ] arreglo) {
	/* En esta variable se construirá la cadena que indica el contenido del parámetro,
	 * si el parámetro no es null. En caso contrario, devolveremos la cadena "null"
	 */
	String cadenaResultante = "null";

	/* Si el parámetro es null, ya no hacemos nada. En caso contrario, procedemos con
	 * el siguiente bloque if
	 */
	if(arreglo != null) {
	    // Construimos la cadena con el contenido del arreglo parámetro
	    cadenaResultante = "[ "; 
	    
	    for(int i = 0; i < arreglo.length; i++) {
		cadenaResultante += arreglo[i].toString( ) + " "; 
	    }
	    cadenaResultante += "]";
	}

	return cadenaResultante;
    }    
}
