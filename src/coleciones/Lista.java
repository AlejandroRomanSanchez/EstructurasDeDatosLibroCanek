package colecciones;

import interfaces.Coleccion;
import interfaces.IteradorLista;
import java.util.Iterator;

/**
 * Esta clase permite construir y manipular lista doblemente 
 * ligadas implementadas por medio de nodos.
 */
public class Lista<T> implements Coleccion<T> {
    /**
     * Esta clase privada permite construir y manipular 
     * nodos para la lista doblemente ligada. Cada nodo
     * consta de un elemento, un nodo siguiente y otro anterio
     */
    private class Nodo {
	/**
	 * Este atributo hace referencia al elemento que guarda 
	 * el nodo.
	 */
	public T elemento;
	/**
	 * Este atributo hace referencia al nodo anterior del 
	 * objeto nodo.
	 */
	public Nodo anterior;
	/**
	 * Este atributo hace referencia al nodo siguiente 
	 * del objeto nodo.
	 */
	public Nodo siguiente;

	/**
	 * Este es el constructor de la clase privada Nodo.
	 * Recibe un objeto de la clase T, y crea un nodo con
	 * atributo haciendo referencia al parámetro. Además,
	 * sus nodos anterior y siguiente harán referencia a
	 * null.
	 * @return elemento Es el objeto que será referenciado 
	 * con el atributo elemento del objeto que será 
	 * construido.
	 */
	public Nodo(T elemento) {
	    this.elemento = elemento;
	}
    }
    
    private class Iterador implements IteradorLista<T> {
	public Nodo anterior;
	public Nodo siguiente;
	public Iterador( ) {

	}
	@Override
	public boolean hasNext( ) {
	    return false;
	}
	@Override
	public T next( ) {
	    return null;
	}
	@Override
	public boolean hasPrevious( ) {
	    return false;
	}
	@Override
	public T previous( ) {
	    return null;
	}
	@Override
	public void start( ) {
	    
	}
	@Override
	public void end( ) {

	}	
    }

    /**
     * Esta variable hace referencia al primer elemento de la 
     * lista, si no es vacía. Cuando construimos a la lista
     * o cuando la lista es vacía, esta variable por defecto 
     * hace referencia a null.
     */
    private Nodo cabeza;
    /**
     * Esta variable hace referencia al último elemento de la 
     * lista, si no es vacía. Cuando construimos a la lista
     * o cuando la lista es vacía, esta variable por defecto 
     * hace referencia a null.
     */
    private Nodo rabo;
    /**
     * Esta variable guarda el número de elementos que 
     * acctualmente tiene la lista.
     */
    private int longitud;

    @Override
    /**
     * Este método agrega un elemento al final 
     * de la lista. 
     * @return elemento Es el elemento que será 
     * agregado al final de la lista.
     */
    public void agrega(T elemento) {
	/* Creamos un nodo que tendrá como elemento 
	 * el parámetro.
	 */
	Nodo nuevoNodo = new Nodo(elemento);
	/* Incrementamos una unidad a la longitud 
	 * de la lista.
	 */
	longitud++; 
	
	if(rabo == null) {
	    // Si la lista es vacía.
	    /* Hacemos que cabeza y rabo hagan
	     * referencia al nuevo nodo.
	     */
	    cabeza = nuevoNodo; 
	    rabo = nuevoNodo;
	} else {
	    // Si la lista no es vacía.
	    /* Hacemos que el nuevo nodo sea el siguiente
	     * de lo referenciado actualmente por rabo.
	     */
	    rabo.siguiente = nuevoNodo;
	    /* Hacemos que el anterior del nuevo nodo 
	     * haga referencia a lo referenciado actualmente 
	     * por rabo.
	     */
	    nuevoNodo.anterior = rabo;
	    /* Hacemos que rabo ahora haga referencia al nuevo
	     * nodo.
	     */
	    rabo = nuevoNodo;
	}
    }

    /**
     * Este método privado es auxiliar, nos permite encontrar el
     * primer nodo de la lista cuyo elemento coincida con el 
     * parámetro; para posteriormente devolver dicho nodo.
     * @param elemento Es el elemento que deberá tener el nodo que
     * se devolverá; cabe mencionar que sólo se devuelve la primera
     * coincidencia.
     * @return Es el primer nodo que tiene como elemento el parámetro.
     */
    private Nodo buscaNodo(T elemento) {
	// Esta variable hará referencia al resultado.
	Nodo resultado = null;
	/* Esta variable recorrerá la lista hasta que encuentre el primer
	 * nodo cuyo elemento coincida con el parámetro o hasta que haya
	 * recorrido a la lista en su totalidad.
	 */
	Nodo recorredor = cabeza;

	// Si la lista no es vacía, entonces deberemos recorrer a la lista
	if(recorredor != null) {
	    /* La primera condición para seguir recorriendo a la lista es 
	     * que la variable recorredor no haya recorrido toda la 
	     * lista aún.
	     */
	    while(recorredor != null) {
		/* Si encontramos el primer nodo cuyo elemento coincida
		 * con el parámetro, entonces hacemos que la variable
		 * resultado haga referencia a dicho nodo y terminamos 
		 * el recorrido; o equivalentemente, paramos el actual 
		 * ciclo while.
		 */
		if(recorredor.elemento.equals(elemento)) {
		    resultado = recorredor;
		    break;
		}
		/* Si en esta iteración aún no encontramos la primera
		 * coincidencia, entonces preparamos el escenario para 
		 * ahora analizar al siguiente nodo en la siguiente iteración.
		 */
		recorredor = recorredor.siguiente;
	    }
	}

	return resultado;
    }
    
    @Override
    /**
     * Este método elimina el primer nodo cuyo elemento 
     * coincide con el parámetro.
     * @param elemento Es el elemento que deberá tener el
     * nodo que será eliminado de la lista; cabe mencionar 
     * que dicho nodo deberá ser el primero de la lista que
     * tenga como elemento al parámetro.
     */
    public void elimina(T elemento) {
	/* Obtenemos el primer nodo cuyo elemento sea igual
	 * al parámetro, y lo referenciamos con esta variable.
	 */
	Nodo primeraCoincidencia = this.buscaNodo(elemento);

	/* Este bloque sólo es ejecutado si existe al menos
	 * un nodo en la lista cuyo elemento sea igual al 
	 * parámetro.
	 */
	if(primeraCoincidencia != null) {
	    // Es el siguiente de la primera coincidencia.
	    Nodo nodoSiguiente = primeraCoincidencia.siguiente;
	    // Es el anterior de la primera coincidencia.
	    Nodo nodoAnterior = primeraCoincidencia.anterior;
	    longitud--; // Decrementamos una unidad a longitud.
	    
	    if(cabeza == rabo) {
		/* Si la cabeza y el rabo son el mismo, entonces
		 * sólo hacemos que cabeza y rabo hagan referencia
		 * a null
		 */
		cabeza = null;
		rabo = null;
		return;
	    }
	    if(primeraCoincidencia == cabeza) {
		/* Si la variable primeraCoincidencia hace
		 * referencia a cabeza, significa que lo
		 * referenciado actualmente por cabeza será
		 * eliminado.
		 */
		nodoSiguiente.anterior = null;
		/* Hacemos que cabeza haga referencia al siguiente
		 * de lo referenciado por primeraCoincidencia.
		 */
		cabeza = nodoSiguiente;
		return;
	    }
	    if(primeraCoincidencia == rabo) {
		/* Si la variable primeraCoincidencia hace
		 * referencia a rabo, significa que lo
		 * referenciado actualmente por rabo será
		 * eliminado.
		 */
		nodoAnterior.siguiente = null;
		/* Hacemos que rabo haga referenacia al anterior
		 * de lo referenciado por primeraCoincidencia
		 */
		rabo = nodoAnterior;
		return;
	    } else {
		/* En cualquier otro caso, significa que un nodo
		 * será eliminado y dicho no se encuentra ni al inicio
		 * ni al final de la lista. En este caso, hacemos que 
		 * el siguiente del anterior de primeraCoincidencia 
		 * haga referencia al siguiente de primeraCoincidencia
		 * y hacemos que el siguiente de primeraCoincidencia
		 * ahora haga referencia al anterior de 
		 * primeraCoincidencia. 
		 */
		nodoAnterior.siguiente = nodoSiguiente;
		nodoSiguiente.anterior = nodoAnterior;
		return;
	    }
	}
    }

    @Override
    /**
     * Este método verifica si un elemento se encuentra en la lista
     * @param elemento Es el elemento a veriricar si se encuentra en 
     * la lista.
     * @return Si el parámetro se encuentra en la lista, devolvemos 
     * true; en caso contrario, false
     */
    public boolean contiene(T elemento) {
	/* Esta variable hace referencia al primer nodo cuyo elemento
	 * es igual al parámetro. En caso de que no exista dicho nodo,
	 * entonces esta variable hace referencia a null.
	 */	
	Nodo posibleCoincidencia = this.buscaNodo(elemento);
	/* Esta variable guarda el resultado booleano de verificar si
	 * el parámetro está en la lista. Esta verificación se hace en 
	 * términos de lo referenciado por la variable
	 * posibleCoincidencia. Si dicha variable hace referencia a null,
	 * entonces el parámetro no se encuentra en la lista; en caso 
	 * contrario, significa que sí se encuentra.
	 */
	boolean resultado = posibleCoincidencia != null;
	
	return resultado;
    }

    @Override
    /**
     * Este método verifica si la lista es vacía.
     * @return Si la lista es vacía, entonces devuelve true. En caso
     * contrario, false.
     */
    public boolean esVacia( ) {
	// sólo verificamos si la longitud de la lista es cero.
	return longitud == 0;
    }

    @Override
    /**
     * Este método devuelve el número de elementos que tienes la lista.
     * @return El número de elementos que actualmente tiene la lista.
     */
    public int getElementos( ) {
	// Sólo devolvemos lo actualmente guardado en longitud.
	return longitud;
    }

    @Override
    /**
     * Este método elimina todos los elementos de la lista, haciéndola
     * vacía; es decir, la lista regresa a su estado inicial.
     */
    public void limpia( ) {
	// La cabeza y el rabo ahora hacen referencia a null
	cabeza = null;
	rabo = null;
	// Ahora la lista no tiene elementos.
	longitud = 0;
    }

    @Override
    public Iterator<T> iterator( ) {
	return null;
    }

    @Override
    public String toString( ) {
	return null;
    }

    @Override
    public boolean equals(Object o) {
	return false;
    }

    public int getLongitud( ) {
	return 0;
    }

    public void agregaFinal(T elemento) {

    }

    public void agregaInicio(T elemento) {

    }

    public T eliminaPrimero( ) {
	return null;
    }

    public T eliminaUltimo( ) {
	return null;
    }

    public T getPrimero( ) {
	return null;
    }

    public T getUltimo( ) {
	return null;
    }

    public T get(int i) {
	return null;
    }

    public Lista<T> copia( ) {
	return null;
    }
    
    public Lista<T> reversa( ) {
	return null;
    }

    public int indiceDe(T elemento) {
	return 0;
    }

    public IteradorLista<T> iteradorLista( ) {
	return null;
    }
}
