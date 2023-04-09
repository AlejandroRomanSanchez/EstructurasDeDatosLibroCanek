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
    public String toString( ) {
	return null;
    }
}
