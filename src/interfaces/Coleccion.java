package interfaces;

import java.util.Iterator;

/**
 * Esta es la interfaz que permite la definición de 
 * estructuras de datos clasificadas como colecciones
 **/
public interface Coleccion<T> extends Iterable<T> {
    /**
     * Este método permite agregar un elemento a la 
     * colección. El método lanzará la excepción
     * IllegalArgumentException si el elemento 
     * recibido es null.
     * @param elemento Es el elemento a agregar en 
     * la colección.
     */
    public void agrega(T elemento);

    /**
     * Este método permite eliminar la primera 
     * coincidencia del parámetro que aparezca en la
     * colección.
     * @param elemento Es el elemento cuya primera
     * coincidencia será eliminada de la colección
     */
    public void elimina(T elemento);

    /**
     * Este método verifica si el elemento recibido 
     * se encuentra en la colección.
     * @param elemento Es el elemento a verificar si 
     * se encuentra en la colección.
     * @return Si el parámetro se encuentra en la
     * colección, el método devuelve true; false, en
     * caso contrario.
     */
    public boolean contiene(T elemento);

    /**
     * Este método verifica si la colección está vacía.
     * @return Si la colección no tiene elemento alguno,
     * este método devuelve true; false, en caso 
     * contrario.
     */
    public boolean esVacia( );

    /**
     * Este método devuelve el número de elementos de la
     * colección.
     * @return Es el número de elementos contenidos en la
     * colección.
     */
    public int getElementos( );

    /**
     * Este método eliminar absolutamente todos los elementos
     * contenidos en la colección; es decir, la vuelve vacía.
     */
    public void limpia( );

    /**
     * Este método devuelve una instancia de la interfaz 
     * Iterator que nos permitirá recorrer o iterar la
     * colección
     * @return Un iterador que nos permite recorrer la
     * colección.
     */
    public Iterator<T> iterator( );
}
