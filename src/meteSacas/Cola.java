package meteSacas;

import abstractas.MeteSaca;

/**
 * Esta clase permite construir y manipular colas.
 */
public class Cola<T> extends MeteSaca<T> {
    @Override
    /**
     * Este método agrega un elemento a la cola. Sólo podemos agregar
     * elementos distinto de null, y son agregados al final de la cola.
     * @param elemento El elemento a agregar en la cola.
     */
    public void mete(T elemento) {
	/* Si el parámetro es null, entonces se lanzará una excepción.
	 * Pero como en la interfaz MeteSAca no se tiene declarada 
	 * excepción alguna, entonces deberemos de manejar esta 
	 * excepción mediante un bloque catch-try
	 */
	try {
	    // Si el parámetro es null, se lanzará una excepción.
	    if(elemento == null) {
		throw new Exception( );
	    } 

	    /* Si el parámetro no es null, creamos un nuevo nodo cuyo
	     * elemento sea el parámetro.
	     */
	    Nodo nuevoNodo = new Nodo(elemento);	    
	    if(this.rabo == null) {
		/* Si el rabo es null, significa que la cola es vacía,
		 * y lo que vamos a agregar será su único elemento que
		 * tendrá. Por ello, cabeza y rabo ahrán referencia al
		 * nuevo nodo.
		 */
		this.cabeza = nuevoNodo;
		this.rabo = nuevoNodo;
	    } else {
		/* Si el rabo no es null, significa que existe la cola
		 * no es vacía. Por ello, el siguiente de rabo ahora
		 * será el nuevo nodo y posteriormente el rabo también
		 * será este nuevo nodo.
		 */
		this.rabo.siguiente = nuevoNodo;
		this.rabo = nuevoNodo;
	    }
	} catch(Exception excepcion) {
	    System.out.println("Las colas no pueden almacenar a null.");
	}
    }

    @Override
    public String toString( ) {
	return null;
    }
}
