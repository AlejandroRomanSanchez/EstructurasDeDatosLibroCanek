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
    /**
     * Este método devuelve un iterador de la interfaz Iterador
     * @return Iterador de la interfaz Iterador
     */
    public Iterator<T> iterator( ) {
	// Creamos y devolvemos un iterador de Iterador
	return new Iterador( );
    }

    @Override
    /**
     * Este método devuelve una cadena que muestra todos los
     * elementos de la lista; en orden creciente de sus 
     * sus posiciones de izquierda a derecha. Aparecen dentro 
     * de un par de corchetes bien balanceados y separados por 
     * una coma.
     * @return Cadena que muestra los elementos de la lista.
     * Estos elementos aparecen en orden creciente de sus 
     * posiciones de izquierda a derecha, dentro de una par
     * de corchetes bien balanceados y separados por una coma.
     */
    public String toString( ) {
	/* Esta variable guardará la cadena con los elementos
	 * de la lista.
	 */
	String resultado = "[";
	/* Esta variable permitirá el recorrido de la lista de
	 * inicio a fin.
	 */
	Nodo recorredor = cabeza; 

	/* Si la lista no es vacía, hacemos que la cadena resultante
	 * contenga la información de los elementos de la lista.
	 */
	if(!this.esVacia( )) {
	    /* Este ciclo while permite recorrer toda la lista, de
	     * inicio a fin mediante la variable recorredor
	     */
	    while(recorredor != null) {
		/* Concatenamos la información del elemento del nodo
		 * que actualmente referencia la variable recorredor
		 * a la cadena que devolverá este método.
		 */
		resultado += " " + recorredor.elemento.toString( );
		/* Preparamos el escenario para la próxima iteración
		 * de este ciclo, al hacer que la variable recorredor
		 * haga referencia al nodo siguiente de lo actualmente
		 * referencia por dicha variable.
		 */
		recorredor = recorredor.siguiente;

		/* Si el siguiente nodo a analizar en este ciclo es
		 * distinto a null, entonces le concatenamos una coma
		 * a la cadena que devolverá este método (por cuestiones
		 * particulares del formato).
		 */
		if(recorredor != null) {
		    resultado += ",";
		}
	    }
	}

	/* Agregamos corchete izquierdo al resultado, por cuestiones 
	 * particulares del formato
	 */
	resultado += " ] ";

	return resultado;
    }

    @Override
    /**
     * Este método verifica si la lista invocadora y el parámetro son 
     * iguales; es decir, verifica si el parámetro es distinto del vacío
     * y si el parámetro es una lista y, en caso de que el parámetro sea
     * una lista, verifica si tanto la lista invocadora como la lista 
     * parámetro tienen exactamente los mismos elementos y en el mismo
     * orden.
     * @param o Es un objeto de la clase Object del cual queremos verificar 
     * si es igual a la lista invocadora.
     * @return Si el parámetro es distinto de null y si también es una lista y,
     * si en caso de que sea también una lista, tiene los mismos elementos que
     * la lista invocador y en el mismo orden, entonces este método devuelve
     * true. En caso contrario, devuelve false.
     */
    public boolean equals(Object o) {
	/* Esta variable recorrerá a la lista invocadora del inicio hasta que
	 * encuentre un elemento distinto al elemento ubicado en la misma 
	 * posición pero en el parámetro, en caso de que el parámetro también
	 * sea una lista.
	 */
	Nodo recorredorDeInvocador = this.cabeza;

	// Si el parámetro es null o no es una lista, se devuelve false
	if(o == null || this.getClass( ) != o.getClass( )) {
	    return false;
	}

	/* En caso de que el parámetro también sea una lista, le hacemos un
	 * casteo y lo referenciamos mediante la variable lista. Como la clase
	 * Lista es genérica, hacer esto obliga al compilador a arrojar una
	 * advertencia; para suprimir esta advertencia, utilizamos 
	 * SuppressWarnings.
	 */	
	@SuppressWarnings("unchecked")
	    Lista<T> lista = (Lista<T>) o;
	/* Esta variable recorrerá a lista, desde el inicio hasta que
	 * encuentre elementos distintos en la misma posición tanto en 
	 * lista como en el invocador.
	 */
	Nodo recorredorDeParametro = lista.cabeza;	
	
	if(this.longitud != lista.longitud) {
	    /* Si ambas lista no tienen la misma longtud, entonces exite
	     * al menos un elemento en una que no se encuentra en la otra.
	     */
	    return false;
	} else {
	    /* Si ambas listas tienen la misma longitud, entonces hacemos un recorrido	    
	     * de ambas listas, desde la cabeza de ambas hasta que se encuentren dos
	     * elementos en la misma posición que sean distintos. En caso contrario,
	     * obviamente recorrerá ambas listas a plenitud. Cabe mencionar, que como 
	     * ambas listas tienen la misma longitud, basta con verificar si la
	     * variable recorredor de una de las listas no hace referencia a null.
	     */
	    while(recorredorDeInvocador != null) {
		if(!recorredorDeInvocador.elemento.equals(recorredorDeParametro.elemento)) {
		    /* Si encuentra dos elementos distintos que están en la misma posición,
		     * significa que ambas listas son distintas.
		     */
		    return false;
		}

		/* Si en esta iteración, ambos elementos son iguales, entonces hacemos que
		 * ambos recorredores de las listas hagan referencia a sus respectivos nodos
		 * siguientes, para poder analizarlos en la siguiente iteración.
		 */
		recorredorDeInvocador = recorredorDeInvocador.siguiente;
		recorredorDeParametro = recorredorDeParametro.siguiente;
	    }
	}
	/* Si cada uno de los elementos en sus respectivas posiciones son iguales, entonces
	 * significa que ambas lista son iguales.
	 */
	return true;
    }

    /**
     * Este método devuelve el número de elementos en la lista.
     * @return El número de elementos de la lista
     */
    public int getLongitud( ) {
	/* Sólo invocamos al método getElementos, pues también devuelve la longitud de la
	 * lista
	 */
	return this.getElementos( );
    }

    /**
     * Este método agrega al final de la lista al parámetro. 
     * @param elemento Es el elemento que se agregará al final de la lista.
     */
    public void agregaFinal(T elemento) {
	/* Sólo invocamos al método agrega, pues este método también agrega al final de la
	 * lista.
	 */
	this.agrega(elemento);
    }

    /**
     * Este método agrega al inicio de la lista el parámetro.
     * @param elemento Es el elemento que se agregarár al inicio de la lista.
     */
    public void agregaInicio(T elemento) {
	// Creamos un nodo cuyo elemento sea el parámetro.
	Nodo nuevoNodo = new Nodo(elemento); 
	longitud++; // Incrementamos una unidad al número de elementos de la lista.
	
	if(this.esVacia( )) {
	    /* Si la lista es vacía, solo hacemos que la cabeza y el rabo hagan
	     * referencia a nuevoNodo.
	     */
	    this.cabeza = nuevoNodo;
	    this.rabo = nuevoNodo;	    
	} else {
	    // Si la lista no es vacía.
	    // Hacemos que el anterior de cabeza haga referencia a nuevoNodo.
	    cabeza.anterior = nuevoNodo;
	    // Hacemos que el siguiente de nuevoNodo haga referencia a cabeza.
	    nuevoNodo.siguiente = cabeza;	    
	    cabeza = nuevoNodo; // Ahora nuevoNodo será la cabeza de la lista.
	}
    }

    /**
     * Este método auxiliar permite devolver el i-ésimo nodo de la lista, donde 
     * i es el parámetro. Si i es menor o igual que cero, se devuelve la cabeza.
     * Si i es mayor o igual que la longitud de la lista menos uno, se devuelve 
     * el rabo de la lista.
     * @param indice El índice que tendrá el nodo a devolver.
     * @return El nodo correspondiente de la lista cuyo índice es igual al
     * parámetro. Si el parámetro es menor o igual que cero, se devuelve la
     * cabeza. Si el parámetro es maor o igual que la longitud de la lista menos
     * uno, se devuelve el rabo.
     */
    private Nodo devuelveIesimo(int indice) {
	// Esta variable hará referencia al nodo a devolver.
	Nodo resultado = cabeza;
	/* Esta variable permite el recorrido de la lista hasta que nos topemos
	 * con el nodo cuyo índice es igual al parámetro.
	 */
	Nodo recorredor = cabeza;
	// Esta variable guardará el conteo de cuántos nodos hemos recorrido.
	int contador = 0; 
	if(indice <= 0) {
	    // Si el parámetro es menor o igual que cero, devolvemos la cabeza.
	    return resultado;
	}
	if(indice >= this.getLongitud( ) - 1) {
	    /* Si el parámetro es mayor o igual que la longitud menos uno,
	     * devolvemos el rabo.
	     */
	    resultado = rabo;
	    return resultado;
	}

	/* Si el parámetro es mayor que cero y menor que la longitud de la lista
	 * menos uno, recorremos los nodos de la lista hasta que lleguemos al nodo
	 * cuyo índice es igual que el parámetro.
	 */
	while(contador <= indice) {
	    /* Si ya llegamos al nodo cuyo índice es igual al parámetro, entonces
	     * vamos a devolver el nodo actualmente referenciado por la variable
	     * recorredor.
	     */
	    if(contador == indice) {
		resultado = recorredor;
	    }

	    /* Si aún no hemos llegado al nodo deseado, hacemos que ahora la variable
	     * recorredor haga referencia al nodo siguiente de lo actualmente 
	     * referenciado por recorredor.
	     */
	    recorredor = recorredor.siguiente;
	    contador++;	// Incrementamos una unidad al conteo de los nodos recorridos
	}
	
	return resultado;
    }

    /**
     * Este método inserta el segundo parámetro en la posición de la lista correspondiente
     * al valor del primer parámetro. Si el primer parámetro es menor o igual que cero, 
     * entonces el segundo parámetro se inserta al inicio de la lista. Mientras que si
     * el primer parámetro es mayor que la longitud de la lista menos uno, entonces 
     * insertamos el segundo parámetro al final de la lista.
     * @param indice El índice en el cuall se inserrtará el segundo parámetro.
     * @param elemento El elemento que se insertará en la lista en la posición que
     * corresponde al valor del primer parámetro. Si el primer parámetro es menor o igual 
     * que cero, insertaremos el elemento al inicio de la lista. Si el primer parámetro
     * es mayor que la longitud de la lista, entonces insertaremos al elemento al final 
     * de la lista.
     */
    public void inserta(int indice, T elemento) {
	// Creamos un nodo cuyo elemento es el segundo parámetro.
	Nodo nuevoNodo = new Nodo(elemento);
	/* Esta variable hace referencia al nodo que se encuentra en la posición
	 * correspondiente al valor del primer parámetro.
	 */
	Nodo nodoEnIndice = this.devuelveIesimo(indice);
	// Esta variable hace referencia al nodo anterior de nodoEnIndice
	Nodo nodoAnterior = nodoEnIndice.anterior; 

	/* Si el primer parámetro es menor o igual que cero, sólo agregamos
	 * el segundo elemento al inicio de la lista.
	 */
	if(indice < 1) {
	    this.agregaInicio(elemento);
	    return;
	}
	/* Si el primer parámetro es mayor que la longitud de la lista, entonces
	 * sólo agregamos el segundo parámetro al final de la lista.
	 */
	if(indice > this.getLongitud( ) - 1) {
	    this.agregaFinal(elemento);
	    return;
	}
	/* Si el primer parámetro es mayor que cero y menor que la longitud de
	 * la lista menos uno.
	 */
	if(0 < indice && indice <= this.getLongitud( ) - 1) {
	    // Decrementamos una unidad al número de elementos de la lista.
	    longitud++;
	    /* Hacemos que el anterior del nuevo nodo sea el anterior de
	     * nodoEnIndice.
	     */
	    nuevoNodo.anterior = nodoAnterior;
	    /* Hacemos que el siguiente del nodo anterior de nodoEnIndice sea
	     * el nuevo nodo que insertaremos.
	     */
	    nodoAnterior.siguiente = nuevoNodo;
	    // Hacemos que el siguiente del nuevo nodo sea nodoEnIndice
	    nuevoNodo.siguiente = nodoEnIndice;
	    /* Hacemos que el anterior de nodoEnIndice sea el nodo que
	     * insertaremos.
	     */
	    nodoEnIndice.anterior = nuevoNodo;
	}	
    }

    /**
     * Este método elimina el primer elemento de la lista y lo devuelve. En caso
     * de que la lista sea vacía, solo se lanza una excepción.
     * @return El primer elemento de la lista antes de que se eliminara.
     */
    public T eliminaPrimero( ) throws Exception {
	// Esta variable guardará el nodo a eliminar, si es que la lista no es vacía.
	Nodo nodoEliminado;

	// Si la lista es vacía, sólo lanza una excepción.
	if(this.esVacia( )) {
	    throw new Exception("La lista es vacía");
	} else {
	    // Si la lista no es vacía.
	    // Hacemos que nodoEliminado haga referencia a la actual cabeza.
	    nodoEliminado = cabeza;
	    /* Hacemos que el anterior del siguiente de la cabeza actual haga
	     * referencia a null.
	     */
	    cabeza.siguiente.anterior = null;
	    /* Hacemos que cabeza ahora sea el nodo siguiente del nodo actualmente
	     * referenciado por cabeza.
	     */
	    cabeza = cabeza.siguiente;
	    longitud--; // Le restamos una unidad al número de elementos de la lista.
	    return nodoEliminado.elemento;
	}
    }

    /**
     * Este método elimina el último elemento de la lista y lo devuelve, si es que la
     * lista no es vacía. En caso de que la lista sea vacía se lanza una excepción.
     * @return El último elemento de la lista antes de que se eliminara..
     */
    public T eliminaUltimo( ) throws Exception {
	/* Esta variable hará referencia al elemento a eliminar, si la lista no es
	 * vacía.
	 */
	Nodo nodoEliminado; 

	// Si la lista es vacía, solo se lanza una excepción.
	if(this.esVacia( )) {
	    throw new Exception("La lista es vacía.");
	} else {
	    // Si la lista no es vacía.
	    nodoEliminado = rabo; // Hacemos que nodoEliminado haga referencia al rabo.
	    // Hacemos que el siguiente del anterior de rabo sea null.
	    rabo.anterior.siguiente = null;
	    /* Hacemos que rabo sea ahora el nodo anterior de lo actualmente referenciado
	     * por la variable rabo.
	     */
	    rabo = rabo.anterior;
	    longitud--; // Decrementamos una unidad al número de elementos de la lista.
	    return nodoEliminado.elemento;
	}
    }

    /**
     * Este método devuelve el primer elemento de la lista, si es que la lista es no vacía.
     * En caso contrario, lanza una excepción.
     * @return El primer elemento de la lista, si es que la lista es no vacía.
     */
    public T getPrimero( ) throws Exception {
	// Si la lista es vacía, se lanza una excepción.
	if(this.esVacia( )) {
	    throw new Exception("La lista es vacía.");
	}
	// Si no es vacía, sólo devolvemos la cabeza de la lista
	return this.cabeza.elemento;
    }

    /** 
     * Este método devuelve el último elemento de la lista, si es que la lista es no vacía.
     * En caso contrario, se lanza una excepción.
     * @return El último elemento de la lista, si es que la lista es no vacía.
     */
    public T getUltimo( ) throws Exception {
	// Si la lista es vacía, se lanza una excepción
	if(this.esVacia( )) {
	    throw new Exception("La lista es vacía.");
	}
	// Si la lista es no vacía, sólo devolvemos el rabo de la lista.
	return this.rabo.elemento;
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

    /**
     * Este método devuelve el índice del primer nodo cuyo
     * elemento coincide con el parámetro, si es que dicho 
     * nodo existe. En caso contrario, devuelve -1
     * @param elemento Es el elemento que queremos que tenga 
     * el primer nodo cuyo índice será devuelto, si es que 
     * existe tal nodo.
     * @return Es el índice del primer nodo cuyo elemento 
     * es igual al parámetro, si es que existe tal nodo. En
     * caso contrario, devuelve -1
     */
    public int indiceDe(T elemento) {
	/* Esta variable guardará el índice del primer nodo
	 * cuyo elemento es igual al parámetro, si es que 
	 * existe tal nodo. en caso contrario seguirá 
	 * guardando el valor entero de -1
	 */
	int resultado = -1;
	/* Esta varable contará el número de elemento que se tuvieron
	 * que recorrer para llegar al primer nodo cuyo elemento es 
	 * igual al parámetro.
	 */
	int contador = 0;
	/* Esta variable recorrerá los nodos de la lista, hasta que
	 * encuentre al primer nodo cuyo elemento es igual al 
	 * parámetro o hasta que se haya recorrido toda la lista.
	 */
	Nodo recorredor = cabeza; 

	/* Si la cabeza no hace referencia a null, entonces recorreremos
	 * la lista desde el inicio hasta que encontremos al primer nodo
	 * cuyo elemento es igual al parámetro o hasta que hayamos 
	 * recorrido toda la lista.
	 */
	if(recorredor != null) {
	    /* Seguimos recorriendo la lista siempre y cuando la variable
	     * recorredor no haga referencia a null o si el elemento del
	     * nodo referenciado por recorredor no sea igual al parámetro.
	     */
	    while(!recorredor.elemento.equals(elemento)) {		
		/* Hacemos que recorredor haga referencia al siguiente de lo
		 * actualmente referenciado por esta variable.
		 */
		recorredor = recorredor.siguiente;
		contador++; // El contador debe ser incrementado por una unidad.

		// Si recorredor ya llegó al rabo de la lista.
		if(recorredor == null) {
		    /* Significa que el parámetro no es elemento de la lista.
		     * Por lo que guardamos el valor de -1 en la variable contador
		     * y salimos del presente ciclo while.
		     */
		    contador = -1;
		    break;
		}
	    }
	    /* La variable resultado guardará el número de veces que se iteró sobre
	     * el anterior ciclo while, si es que encontramos al parámetro en la lista;
	     * o guardará el valor de -1, en caso contrario. En ambos casos, es lo que
	     * deseamos que este método devuelva. Por  lo que guardamos el valor de 
	     * conotador en la variable resultado.
	     */
	    resultado = contador; 
	}

	return resultado;
    }

    public IteradorLista<T> iteradorLista( ) {
	return null;
    }
}
