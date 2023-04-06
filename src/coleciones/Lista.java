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

    private Nodo cabeza;
    private Nodo rabo;
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

    private T buscaNodo(T elemento) {
	T resultado = null;
	Nodo recorredor = cabeza;

	if(recorredor != null) {	    
	    while(recorredor != null) {
		if(recorredor.elemento.equals(elemento)) {
		    resultado = recorredor.elemento;
		    break;
		}
		recorredor = recorredor.siguiente;
	    }
	}

	return resultado;
    }
    
    @Override
    public void elimina(T elemento) {

    }

    @Override
    public boolean contiene(T elemento) {
	return false;
    }

    @Override
    public boolean esVacia( ) {
	return false;
    }

    @Override
    public int getElementos( ) {
	return 0;
    }

    @Override
    public void limpia( ) {

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
