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
    /**
     * Este método ordena el arreglo parámetro por medio del algoritmo quickSort. Los elementos de este arreglo
     * deben implementar la interfaz Comaprable<T>
     * @param arreglo Es el arreglo de elementos que implemento la interfaz Comparable<T> que será ordenada
     * por medio del algoritmo quicksort
     */
    public static <T extends Comparable<T>> void quickSort(T[ ] arreglo) {
	/* solamente aplicamos la sobre-escritura del método quickSort con el arreglo parámetro de este método
	 * como el primer parámetro y se toma una lambda para indicar que donde aparezca el método compare, se
	 * tomará el código de la lambda parámetro
	 */
	quickSort(arreglo, (objeto1, objeto2) -> objeto1.compareTo(objeto2));
    }
    
    /**
     * Este método aplica el algoritmo quickSort para ordenar al arreglo parámetro. El orden que se tomarán en
     * cuenta para ordenar los elementos de este arreglo está determinado por el parámetro comparador
     * @param arreglo Es el arreglo que será ordenado por medio del algoritmo quickSort
     * @param comparador Este parámetro determina el orden que tomarán los elementos del arreglo parámetro
     * para que puedan ser ordenados por medio del algoritmo quickSort
     */
    public static <T> void quickSort(T[ ] arreglo, Comparator<T> comparador) {
	int longitudDeArreglo; // Esta variable guardará la longitud del arreglo parámetro

	// Si al primer parámetro es null, entonces lanzamos una excepción
	if(arreglo == null) {
	    throw new NullPointerException("El primer parámetro ingresado fue null");
	}
	// Como el primer parámetro es un arreglo, podemos asignar la longitud de éste a una variable
	longitudDeArreglo = arreglo.length;

	/* Aplicamos el método sobrecargado de quickSort, en el cual el índice inferior es 0, mientras que el
	 * superior es el último índice del arreglo parámetro
	 */
	Arreglo.quickSort(arreglo, 0, longitudDeArreglo - 1, comparador); 
    }
    
    /**
     * Este método ordena un sub-arreglo del arreglo parámetro por medio del algoritmo quickSort. Este
     * sub-arreglo está determinado por los índices parámetros. Además, los elementos del sub-arreglo serán
     * ordenados de acuerdo a un Comparator del mismo tipo que el arreglo
     * @param arreglo Es el arreglo que será ordenado por medio del algoritmo quickSort
     * @param indiceInferior Es el índice inferior del sub-arreglo que será tomado del arreglo parámetro para
     * ser ordenado
     * @param indiceSuperior Es el índice superior del sub-arreglo que será tomado del arreglo parámetro para
     * ser ordenado
     * @param comparador Los elementos del sub-arreglo serán ordenados de acuerdo al orden proporcionado por
     * este parámetro
     */
    private static <T> void quickSort(T[ ] arreglo, int indiceInferior, int indiceSuperior,
				     Comparator<T> comparador) {
	/* Este iterador irá recorriendo el sub-arreglo, en ocasiones de manera ascendente y en otras
	 * descendente, comenzando desde el índice una unidad a la derecha del índice inferior del
	 * sub-arreglo
	 */
	int iteradorInferior;
	/* Este iterador irá recorriendo el sub-arreglo de manera descendente, comenzando desde el último
	 * índice del sub-arreglo
	 */
	int iteradorSuperior;
	// Esta variable guardará el elemento del sub-arreglo actual correspondiente al iterador inferior
	T elementoEnIteradorInferior;
	// Esta variable guardará el elemento del sub-arreglo actual correspondiente al iterador superior
	T elementoEnIteradorSuperior;
	// Esta variable siempre guardará el elemento del índice inferior del sub-arreglo
	T elementoEnIndiceInferior;

	// Si el primer parámetro es null, entonces lanzamos una excepción
	if(arreglo == null) {
	    throw new NullPointerException("El primer parámetro ingresado es null");
	}
	
	/* Si los índices extremos del sub-arreglo son iguales o están al revés en la lista de parámetros,
	 * entonces el sub-arreglo solamente tiene un elemento o es vacío; por lo que este método no hace nada
	 */
	if(indiceSuperior <= indiceInferior) {
	    return;
	}

	/* Como el arreglo parámetro no es null ni es vacío ni tiene un único elemento, entonces tiene sentido
	 * hacer las siguientes asignaciones.
	 */
	// El iterador inferior comienza una unidad a la derecha del índice inferior del sub-arreglo
	iteradorInferior = indiceInferior + 1; 
	iteradorSuperior = indiceSuperior; // El iterador superior comienza en el último índice del sub-arreglo
	// Para facilitar la lectura, asignamos los siguientes elementos del arreglo con sus respectivos índices
	elementoEnIndiceInferior = arreglo[indiceInferior];
	elementoEnIteradorInferior = arreglo[iteradorInferior];
	elementoEnIteradorSuperior = arreglo[iteradorSuperior];

	/* Los dos iteradores irán recorriendo el sub-arreglo según el siguiente ciclo while, siempre y cuando
	 * el iterador inferior actual sea menor que el iterador superior actual
	 */
	while(iteradorInferior < iteradorSuperior) {
	    if(comparador.compare(elementoEnIteradorInferior, elementoEnIndiceInferior) > 0
	       && comparador.compare(elementoEnIteradorSuperior, elementoEnIndiceInferior) <= 0) {
		/* Si el elemento del iterador inferior es mayor que el elemento del índice inferior y si el
		 * elemento del iterador superior es menor o igual que el elemento del índice inferior, entonces
		 * el iterador inferior se mueve una unidad a la derecha y el superior una unidad a la izquierda
		 */
		Arreglo.intercambiaLosIndicesDe(arreglo, iteradorInferior, iteradorSuperior);
		iteradorInferior = iteradorInferior + 1;
		iteradorSuperior = iteradorSuperior - 1;
	    } else if(comparador.compare(elementoEnIteradorInferior, elementoEnIndiceInferior) <= 0) {
		/* Si el elemento del iterador inferior es menor o igual que el elemento del índice inferior o
		 * si el elemento del iterador superior es mayor que el elementos del índice inferior. Además,
		 * si el elemento del iterador inferior es menor o igual que el elemento del índice inferior,
		 * entonces recorremos el iterador inferior una unidad a la derecha
		 */
		iteradorInferior = iteradorInferior + 1;
	    } else {
		/* Si el elemento del iterador inferior es menor o igual que el elemento del índice inferior o
		 * si el elemento del iterador superior es mayor que el elemento del índice inferior. Además, si
		 * el elemento del iterador inferior es mayor que el elemento del índice inferior, recorremos el
		 * iterador superior una unidad a la izquierda
		 */
		iteradorSuperior = iteradorSuperior - 1;
	    }

	    // Actualizamos los elementos que están en los iteradores actuales
	    elementoEnIteradorInferior = arreglo[iteradorInferior];
	    elementoEnIteradorSuperior = arreglo[iteradorSuperior];
	}

	/* Si el iterador inferior actual es mayor o igual que el iterador superior actual, verificamos si
	 * el elemento del iterador inferior es mayor que el elemento del índice inferior. En caso de que esto
	 * se cumpla, recorremos el iterador inferior una unidad a la izquierda
	 */
	if(comparador.compare(elementoEnIteradorInferior, elementoEnIndiceInferior) > 0) {
	    iteradorInferior = iteradorInferior - 1;
	}

	// Intercambiamos los elementos que están el índice inferior del sub-arreglo con el iterador inferior
	Arreglo.intercambiaLosIndicesDe(arreglo, indiceInferior, iteradorInferior);
	/* Aplicamos quickSort para ordenar a los dos sub-arreglos del sub-arreglo que se obtienen de dividir
	 * a este último con respecto al iterador inferior actual (este es el pivote). Estos dos sub-arreglos
	 * nuevos no tienen al elemento guardado en el iterador inferior actual
	 */
	Arreglo.quickSort(arreglo, indiceInferior, iteradorInferior - 1, comparador);
	Arreglo.quickSort(arreglo, iteradorInferior + 1, indiceSuperior, comparador);
    }
    
    /**
     * Este método intercambia los elementos correspondientes a los índices parámetros del arreglo
     * @param arreglo Es el arreglodel cual intercambiaremos índices
     * @param indice1 Un índice del arreglo a ser intercambiado
     * @param indice2 Un índice del arreglo a ser intercambiado
     */
    public static <T> void intercambiaLosIndicesDe(T[ ] arreglo, int indice1, int indice2) {
	/* En esta variable guardaremos el elemento que se encuentra en el indice1 para que no sea eliminado de
	 * la memoria, y seamos capaces de llevarlo a indice2
	 */
	T elementoAuxiliar;
	// Esta vairable nos indica si indice1 está en el rango de índices del arreglo
	boolean indice1EstaEnElRango = Arreglo.estaEnElRango(arreglo, indice1);
	// Esta variable nos indica si indice2 está en el rango de índices del arreglo
	boolean indice2EstaEnElRango = Arreglo.estaEnElRango(arreglo, indice2);

	// Si el primer parámetro es null, lanzamos una excepción
	if(arreglo == null) {
	    throw new NullPointerException("El primer parámetro ingresado es un null");
	}       

	// Si alguno de los dos índices ingresados está fuera del rango de índices del arreglo, no hacemos nada
	if(indice1EstaEnElRango == false || indice2EstaEnElRango == false) {
	    return;
	}

	// Si los dos índices ingresados están en el rango de índices de arreglo, procedemos a lo siguiente:

	/* Guardamos el elemento de arreglo cuya posición es indice1 en la variable elementoAuxiliar, para que
	 * que no se borre de la memoria y podamos ser capaces de moverlo a la posición indice2 de arreglo
	 */
	elementoAuxiliar = arreglo[indice1];
	// Movemos el elemento de arreglo cuya posición es indice2 a la posición indice1
	arreglo[indice1] = arreglo[indice2];
	// El elemento original que estaba en indice1 lo movemos a la posición indice2
	arreglo[indice2] = elementoAuxiliar; 
    }

    /**
     * Este método verifica si el índice parámetro está en el rango de índices del arreglo parámetro
     * @param arreglo El arreglo del que vamos a verificar si tiene al índice parámetro en su rango
     * @param indice Es el índice que verificaremos si está en el rango del arreglo parámetro
     * @return Si el índice está en el rango del arreglo, se devuelve true. En caso contrario, se
     * devuelve false
     */
    public static <T> boolean estaEnElRango(T[ ] arreglo, int indice) {
	/* En esta variable se guardará true si el índice está en el arreglo. En caso contrario, se devuelve
	 * false
	 */
	boolean resultadoBooleano = false; 
	int longitudDeArreglo; // Esta variable guardará la longitud del arreglo, si éste no es null

	// Si al primer parámetro es null, se lanza una excepción
	if(arreglo == null) {
	    throw new NullPointerException("El primer parámetro ingresado es null");
	}

	// Si el primer parámetro no es null, entonces podemos obtener la longitud del arreglo parámetro
	longitudDeArreglo = arreglo.length;

	// Si el índice está en el rango del arreglo, vamos a devovler true. En caso contrario, false
	if(0 <= indice && indice < longitudDeArreglo) {
	    resultadoBooleano = true;
	}

	return resultadoBooleano;
    }
    
    /**
     * Este método lleva a cabo una búsqueda binaria sobre un arreglo parámetro previamente ordenado
     * @param arreglo Es el arreglo previamente ordenado al cual le haremos una búsqueda binaria
     * @param elemento Es el elemento que buscaremos en el arreglo por medio de una búsqueda binaria
     * @return Si el elemento se encuentra en el arreglo, obtenemos un índice de este arreglo tal que
     * guarda el elemento buscado. En caso contrario, devuelve -1
     */
    public static <T extends Comparable<T>> int busquedaBinaria(T[ ] arreglo, T elemento) {
	/* Aplicamos la sobrecarga del método busquedaBinaria( ), en el cual para el método compare( ) se
	 * utiliza el código de la lambda presentada como tercer parámetro
	 */
	return busquedaBinaria(arreglo, elemento, (objeto1, objeto2) -> objeto1.compareTo(objeto2));
    }
    
    /**
     * Este método lleva a cabo una búsqueda binaria sobre el arreglo parámetro. Es importante que el arreglo
     * parámetro tenga a sus elementos ordenados
     * @param arreglo Es el arreglo en el cual se hará la búsqueda binaria. Este arreglo debe tener sus
     * elementos ordenados
     * @param elemento Es el elemento que se bsucará en el arreglo por medio de una búsqueda binaria
     * @param comparador Este parámetro permite llevar a cabo comparaciones dentro del arreglo cuando
     * se hace la búsqueda binaria
     * @return Si el elemento a buscar se encuentra, se devuelve un índice del arreglo que guarda al elemento.
     * En caso contrario, se devuelve el número -1
     */
    public static <T> int busquedaBinaria(T[ ] arreglo, T elemento, Comparator<T> comparador) {
	/* En esta variable se hará referencia a la mitad del arreglo que posiblemente tenga al elemento que se
	 * está buscando, por lo que se le aplicará el método busquedaBinaria
	 */
	T[ ] subArregloAIterar = null;
	/* En esta variable se guardará el índice del arreglo que tiene al elemento, en caso de tenerlo. De lo
	 * contrario, guardará al número -1
	 */
	int indiceBuscado = 0; 
	int longitudDeArreglo; // Esta variable guardará la longitud del arreglo parámetro
	int puntoMedio; // Es el punto medio de los índice del arreglo parámetro

	// Si null es el primer parámetro, lanzamos un NullPointerException
	if(arreglo == null) {
	    throw new NullPointerException("El primer parámetro es un null");
	}

	/* Como ya sabemos que el primer parámetro no es null, obtenemos la longitud del arreglo parámetro y el
	 * punto medio de sus índices
	 */
	longitudDeArreglo = arreglo.length;
	puntoMedio = (longitudDeArreglo - 1) / 2;
	
	// Si el arreglo parámetro es vacío, devolvemos -1; pues no tiene al elemento que estamos buscando
	if(longitudDeArreglo == 0) {
	    indiceBuscado = -1;
	    return indiceBuscado;
	}

	/* Si el arreglo no es vacío, hacemos comparaciones con respecto al elemento que estamos buscando y a lo
	 * guardado en el punto medio de los índices del arreglo parámetro
	 */

	/* Si, según el comparador, el elemento que estamos buscando es exactamente igual a lo guardado en el
	 * punto medio de los índices del arreglo parámetro, entonces devolvemos ese punto medio
	 */
	if(comparador.compare(elemento, arreglo[puntoMedio]) == 0) {
	    return puntoMedio;
	}

	/* Si, según el comparador, el elemento que estamos buscando es menor que lo guardado en el punto
	 * medio de los índices del arreglo parámetro, entonces hacemos una búsqueda binaria sobre el
	 * sub-arreglo que corresponde a la mitad inferior del arreglo parámetro
	 */
	if(comparador.compare(elemento, arreglo[puntoMedio]) < 0) {
	    subArregloAIterar = (T[ ]) Arreglo.creaSubArregloDe(arreglo, 0, puntoMedio - 1);
	}

	/* Si, según el comparador, el elemento que estamos buscando es mayor que lo guardado en el punto
	 * medio de los índices del arreglo parámetro, entonces hacemos una búsqueda binaria sobre el
	 * sub-arreglo que corresponde a la mitad superior del arreglo parámetro
	 */
	if(comparador.compare(elemento, arreglo[puntoMedio]) > 0) {
	    subArregloAIterar = (T[ ]) Arreglo.creaSubArregloDe(arreglo, puntoMedio + 1, longitudDeArreglo);
	    /* Hacemos una conversión del índice del sub-arreglo al arreglo original, pues queremos obtener el
	     * índice en términos del arreglo parámetro y no se su sub-arreglo
	     */
	    indiceBuscado += puntoMedio + 1; 
	}

	/* Hacemos una conversión del índice del sub-arreglo al arreglo origninal, pues queremos obtener el
	 * índice en término del arreglo parámetro y no de sy sub-arreglo
	 */
	indiceBuscado += Arreglo.busquedaBinaria(subArregloAIterar, elemento, comparador);
	
	return indiceBuscado;
    }

    /**
     * Este método crea un sub-arreglo del arreglo parámetro. Los elementos guardados no son una copia de los del
     * arreglo original
     * @param arreglo Es el arreglo del cual se obtnedrá el sub-arreglo deseado
     * @param indiceInferior Es el índice del arreglo parámetro a partir del cual se tomará su elemento para que
     * sea el primer elemento del sub-arreglo a crear
     * @param indiceSuperior Es el índice del arreglo parámetro del cual se tomará su elemento para que sea el
     * último elemento del sub-arreglo a crear
     * @return Si el arreglo parámetro no es null y si los índices superior e inferior tienen sentido en su
     * orden, entonces obtenemos un sub-arreglo del arreglo parámetro restringido a esos índices. Si esto índice
     * obtenemos un arreglo vacío. Si el índice inferior es menor que cero, se tomará como índice cero. Si el
     * índice superior es mayor o igual que la longitud del arreglo, se tomará como el mayor índice que tiene
     * el arreglo parámetro
     */
    public static <T> Object[ ] creaSubArregloDe(T[ ] arreglo, int indiceInferior, int indiceSuperior) {
	Object[ ] subArreglo = { }; // En esta variable se construirá el sub-arreglo a devolver
	int longitudDeArreglo; // En esta variable se guardará a la longitud del arreglo parámetro
	int longitudDeSubArreglo; // En esta variable se guardará la longitud del sub-arreglo a devolver
	/* Esta variable originalmente guarda al índice inferior, pero si éste es menor que cero, entonces
	 * guardaremos al número cero en esta variable
	 */
	int nuevoIndiceInferior = indiceInferior;
	/* En esta variable originalmente guardamos al índice superior, pero si éste es mayor o igual que la
	 * longitud del arreglo parámetro, entonces guardaremos al mayor de los índices del arreglo
	 * parámetro en esta variable
	 */
	int nuevoIndiceSuperior = indiceSuperior;

	// Si el primer argumento es null, lanzamos una excepción
	if(arreglo == null) {
	    throw new NullPointerException("El primer parámetro es null");
	}

	// Como el primer parámetro no es null, podemos guardar la longitud del arreglo parámetro
	longitudDeArreglo = arreglo.length;

	// Si el arreglo parámetro es vacío, entonces devolvemos un arreglo vacío
	if(longitudDeArreglo == 0) {
	    return subArreglo;
	}

	/* Si el arreglo parámetro no es null y si los índices de restricción están al revés, entonces devolvemos
	 * un arreglo vacío
	 */
	if(indiceInferior > indiceSuperior) {	    
	    return subArreglo;
	}

	/* Si el índice inferior es menor que cero, entonces ahora consideraremos al cero como índice inferior
	 * del rango del arreglo parámetro que será tomado para construir el sub-arreglo
	 */
	if(indiceInferior < 0) {
	    nuevoIndiceInferior = 0;
	}

	/* Si el índice es mayor o igual que la longitud del arreglo parámetro, entonces ahora consideramos al
	 * mayor de sus índice como el índice superior del rango del arreglo parámetro que será tomado para
	 * construir el sub-arreglo
	 */
	if(indiceSuperior >= longitudDeArreglo) {
	    nuevoIndiceSuperior = longitudDeArreglo - 1;
	}

	// Definimos la longitud del sub-arreglo que será devuelto
	longitudDeSubArreglo = 1 + nuevoIndiceSuperior - nuevoIndiceInferior; 
	subArreglo = new Object[longitudDeSubArreglo]; // Creamos el sub-arreglo que será devuelto

	/* Guardamos los elementos del arreglo parámetro que van del primer índice de restricción al segundo
	 * índice de restricción
	 */
	for(int i = 0; i < longitudDeSubArreglo; i++) {
	    subArreglo[i] = arreglo[nuevoIndiceInferior + i];
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
