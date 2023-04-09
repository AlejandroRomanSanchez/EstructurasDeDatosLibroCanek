package meteSacas;

import abstractas.MeteSaca;

public class Pila<T> extends MeteSaca<T> {
    @Override
    /**
     * Este método agrega elementos la pila, sólo se puede agregar al inicio 
     * de la misma.
     */
    public void mete(T elemento) {
	/* Si el parámetro es null, lanzamos una excepción, pues no daremos
	 * posibilidad alguna de agregar null en las pilas. Pero como en la
	 * clase abstracta MeteSaca la firma del método mete no declara 
	 * ninguna excepción, debemos de manejar la posible excepción por 
	 * medio de un bloque try-catch
	 */
	try {
	    /* Si el parámetro es null, lanzamos una excepción. Pues no
	     * permitiremos que se agregue null en las pilas.
	     */
	    if(elemento == null) {
		throw new Exception( );
	    }

	    /* Si el parámetro no es null, creamos un nuevo nodo cuyo
	     * elemento sea el parámetro.
	     */
	    Nodo nuevoNodo = new Nodo(elemento);
	    if(this.cabeza == null) {
		/* Si la pila es vacía, entonces lo agregado será el
		 * único elemento, por lo qiue cabeza y rabo deben hacer 
		 * referencia a éste.
		 */
		this.cabeza = nuevoNodo;
		this.rabo = nuevoNodo;
		return;
	    } else {
		/* Si la pila no es vacía, hacemos que el nuevo nodo
		 * sea la cabeza y lo que era la cabeza sea el nodo 
		 * siguiente del nuevo nodo.
		 */
		nuevoNodo.siguiente = cabeza;
		this.cabeza = nuevoNodo;
	    }
	    
	    
	} catch(Exception excepcion) {
	    System.out.println("Las pilas no pueden almacenar a null.");
	}
    }

    @Override
    /**
     * Este método devuelve el contenido de la pila en una cadena. Si es
     * vacía, se devuelve la cadena sin contenido alguno. Si la pila no es
     * vacía, cada elemento tendrá su línea reservada, y el elemento de 
     * hasta arriba indica el tope de la pila y el de hasta abajo el fonfo.
     * @return Cadena con el contenido de la pila. Cada línea está reservada 
     * para un elemento, el elemento que aparece hasta arriba es el tope, y 
     * el de abajo ell fondo.
     */
    public String toString( ) {
	/* En esta variable construiremos la cadena con el contenido de la
	 * pila.
	 */
	String resultado = "";
	/* Esta variable permitirá el recorrido de toda la pila, de inicio
	 * hasta el fin.
	 */
	Nodo recorredor = this.cabeza; 

	// Recorremos toda la pila, desde el tope hasta el fondo de la pila.
	while(recorredor != null) {
	    // Agregamos el elemento en la cadena
	    resultado += recorredor.elemento.toString( ) + "\n";
	    /* La variable recorredor ahora hará referencia a su nodo
	     * siguiente para poder iterar sobre este último.
	     */
	    recorredor = recorredor.siguiente;
	}

	return resultado;	
    }
}
