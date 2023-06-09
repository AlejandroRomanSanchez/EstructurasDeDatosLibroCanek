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

    /**
     * Este método permite devolver el primer elemento almacenado en la 
     * estructura.
     * @return El primer elemento almacenado en la estructura, si no es
     * vacía.
     */
    public T mira( ) {
	/* Si la estructura es vacía, lanzaremos una excepción. Como la
	 * firma de este método no declara el lanzamiento de una excepción,
	 * debemos de manejarla por medio de un bloque catch-try
	 */
	try {
	    // Si la estructura es vacía, lanzamos una excepción.
	    if(this.cabeza == null) {
		throw new Exception( );
	    }
	} catch(Exception excepcion) {
	    System.out.println("Esta estructura no tiene elementos.");
	}
	/* Si la estructura no es vacía, devolvemos el elemento del primer
	 * nodo.
	 */
	return this.cabeza.elemento;
    }

    /** Este método verifica si la estructura tiene o no elementos.
     * @return Si tiene al menos un elemento, devuelve true; false, en caso contrario.
     */
    public boolean esVacia( ) {
	/* Si la cabeza de la estructura es null, entonces es vacía; en caso contrario,
	 * no lo es.
	 */
	return this.cabeza == null;
    }

    /**
     * Este método es auxiliar y permite obtener el número de elementos que tiene una 
     * estructura del tipo MeteSaca.
     * @return El número de elementos de la estrcutura MeteSaca.
     */
    private int getLongitud( ) {
	// Esta variable guardará el número de elementos de la estructura.
	int resultado = 0;
	// Esta variable permitirá recorrer en su totalidad a la estructura.
	Nodo recorredor = this.cabeza; 

	// Vamos a recorrer toda la estructura, de inicio a fin, si no es vacía.
	while(recorredor != null) {
	    /* Cada iteración realizzada significa que se tiene otro elemento más en
	     * estructura, por lo que le sumamos una unidad al resultado.
	     */
	    resultado++;
	    /* Ahora recorredor hará referencia a su nodo siguiente para poder
	     * realizar la siguiente iteración sobre este nuevo nodo.
	     */
	    recorredor = recorredor.siguiente;
	}

	return resultado;
    }
    
    @Override
    /**
     * Este método permite verificar si el MeteSaca invocador es igual al 
     * parémetro. Para que sean igual ambos deben de ser de la misma clase 
     * y deben tener exactamente los mismos elementos en el mismo orden.
     * @return Si el invocador y el parámetro son de la misma clase y si 
     * tienen los mismos elementos en el mismo orden, entonces este método
     * devuelve true; false, en caso contrario.
     */
    public boolean equals(Object o) {
	/* Debemos verificar que tanto el invocador como el parámetro sean
	 * instancias de la misma clase. Si no lo son, se concluyen que no
	 * son iguales.
	 */
	if(o == null || this.getClass( ) != o.getClass( )) {
	    return false;
	}

	/* Haremos una casteo al parámetro, lo trataremos ahora como una
	 * estructura de la clase MeteSaca, y suprimimos cualquier advertencia 
	 * por parte del compilador de Java.
	 */
	@SuppressWarnings("Unchecked")
	    MeteSaca<T> m = (MeteSaca<T>) o;

	// Esta variable permitirá recorrer todos los elementos del invocador.
	Nodo recorredorDeInvocador =  this.cabeza;
	// Esta variable permitirá recorrer todos los elementos del parámetro.
	Nodo recorredorDeParametro = m.cabeza;
	// Esta variable guardará el número de elementos del invocador.
	int longitudDeInvocador = this.getLongitud( );
	// Esta variable guardará el número de elementos del parámetro.
	int longitudDeParametro = m.getLongitud( );

	/* Si ambas estructuras MeteSaca tienen distinto número de elementos,
	 * se concluye que no son iguales.
	 */
	if(longitudDeInvocador != longitudDeParametro) {
	    return false;
	}

	/* Recorremos todos los elementos de ambas estructuras, hasta que encontremos
	 * dos elementos distintos que están en la misma posición.
	 */
	for(int i = 0; i < longitudDeInvocador; i++) {
	    /* Si encontramos un par de elementos distintos, concluimos que las
	     * estrcuturas no son iguales.
	     */
	    if(!recorredorDeInvocador.elemento.equals(recorredorDeParametro)) {
		return false;
	    }

	    /* Ahora ambos recorredores harán referencia a sus respectivos nodos
	     * siguientes para que en la siguiente iteración, se haga un analisis
	     * sobre éstos.
	     */
	    recorredorDeInvocador = recorredorDeInvocador.siguiente;
	    recorredorDeParametro = recorredorDeParametro.siguiente;
	}
	/* Si todos los elementos fueron iguales, entonces ambas estructuras sí son
	 * iguales.
	 */
	return true;
    }
}
