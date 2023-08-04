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

    public static <T extends Comparable<T>> T[ ] creaSubArregloDe(T[ ] arreglo, int indiceInferior,
								 int indiceSuperior)	
	throws Exception {
	Comparable[ ] subArreglo;	
	int longitudDeSubArreglo;

	if(arreglo == null) {
	    throw new Exception("Null no debe ser el primer parámetro");
	}

	if(indiceInferior < 0 || indiceSuperior >= arreglo.length) {
	    throw new Exception("Alguno de los índices límites está fuera del rango del arreglo");
	}
	
	if(indiceInferior > indiceSuperior) {
	    throw new Exception("El índice inferior debe ser menor o igual que el indice superior");
	}

	longitudDeSubArreglo = 1 + indiceSuperior - indiceInferior;
	subArreglo = new Comparable[longitudDeSubArreglo];

	for(int i = 0; i < longitudDeSubArreglo; i++) {
	    subArreglo[i] = arreglo[indiceInferior + i];
	}

	return (T[ ]) subArreglo;	
    }

    /**
     * Este método devuelve una cadena con el contenido del arreglo parámetro
     * @param arreglo Es el arreglo cuyo contenido será coloado en la cadena a devolver
     * @return Si el parámetro no es null, devuelve una cadena en el cual se indica el
     * contenido del arreglo. En caso contrario, solamente se devuelve la cadena "null"
     */
    public static <T extends Comparable<T>> String construyeCadenaDeArreglo(T[ ] arreglo) {
	/* En esta variable se construirá la cadena que indica el contenido del parámetro,
	 * si el parémetro no es null. En caso contrario, devolveremos la cadena "null"
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
