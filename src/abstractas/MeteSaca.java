package abstractas;

/**
 * Este método permite construir estructuras que puede almacenar 
 * elementos, pero lo único que tienen en común es que pueden
 * eliminar al primer elemento.
 */
public abstract class MeteSaca<T> {
    /**
     * Esta clase interna permite que en las estructuras MeteSacas
     * se pueda hacer uso del concepto de nodo. Estos nodos pueden
     * almacenar un elemento y tienen una referencia a un nodo
     * siguiente.
     */
    protected class Nodo {
	/**
	 * Este atributo hace referencia al elemento almacenado 
	 * actualmente en el nodo.
	 */
	public T elemento;
	/**
	 * Este atributo hace referencia al nodo siguiente del
	 * objeto.
	 */
	public Nodo siguiente;

	/**
	 * Este es el contructor del nodo, el parámetro será 
	 * referenciado por el atributo elemento del nodo, y su
	 * nodo siguiente será null.
	 * @param elemento El atributo elemento del nodo 
	 * inicialmente hará referencia a este parámetro.
	 */
	public Nodo(T elemento) {
	    /* El parámetro elemento hace referencia al parámetro y
	     * su nodo siguiente será null.
	     */
	    this.elemento = elemento;
	    this.siguiente = null;
	}
    }

    /**
     * Este atributo hará referencia al primer nodo de la estructura.
     */
    protected Nodo cabeza;
    /**
     * Este atributo ahrá referencia al último nodo de la estructura.
     */
    protected Nodo rabo;

    /** 
     * Este método permite agregar elementos a la estructura.
     * @elemento Es el elemento que será aregado a la estructura.
     */
    abstract public void mete(T elemento);

    /**
     * Este método permite eliminar elementos de la estructura. Sólo se 
     * le es permitido eliminar a su primer elemento.
     */
    public T saca( ) {
	/* Esta variable hará referencia al elemento a eliminar, si es
	 * que la estructura no es vacía.
	 */
	T elementoEliminado = null; 

	/* Si la estructura es vacía, no podremos eliminar elemento alguno,
	 * por lo que lanzaremos una excepción. Como dicha excepción no la
	 * declaramos en la firma de este método, debemos de manejarla por 
	 * medio de un bloque try-catch
	 */
	try {
	    // Si la estructura es vacía, sólo lanzamos una excepción.
	    if(this.cabeza == null) {
		throw new Exception( );
	    }

	    /* Si la estructura no es vacía, hacemos referencia al elemento
	     * que vamos a eliminar; a saber al primer elemento.
	     */
	    elementoEliminado = this.cabeza.elemento;
	    /* Ahora la cabeza será el nodo siguiente de lo actualmente
	     * referenciado por cabeza
	     */
	    this.cabeza = this.cabeza.siguiente;

	    /* Si ahora cabeza es null, entonces rabo también será null. Es
	     * decir, la estructura ahora será vacía.
	     */
	    if(this.cabeza == null) {
		this.rabo = null;
	    }
	} catch(Exception excepcion) {
	    System.out.println("Esta estructura no tiene elementos.");
	}

	return elementoEliminado;
    }

    public T mira( ) {
	return null;
    }

    public boolean esVacia( ) {
	return false;
    }

    @Override
    public boolean equals(Object o) {
	return false;
    }
}
