package interfaces;

import java.util.Iterator;

/**
 * Esta interfaz permite construir y manejar los 
 * iteradores de la case Lista. Cabe menciones que
 * extiende a la interfaz Iterator.
 */
public interface IteradorLista<T> extends Iterator<T> {
    /**
     * Este método verifica si existe un elemento 
     * anterior.
     * @return Si exite un elemento anterior, devuelve
     * true; false, en caso contrario.
     */
    public boolean hasPrevious( );

    /**
     * Este método devuelve el elemento anterior, y
     * hace que el iterador vaya a la izquierda.
     * @return El elemento anterior.
     */
    public T previous( );

    /**
     * Este método hace que el iterador regrese a la 
     * posición inicial, donde llamar el método 
     * next( ) devuelve el primer elemento.
     */
    public void start( );

    /**
     * Este método hace que el iterador vaya a la
     * posición final, donde invocar el método 
     * previous( ) nos devuelve el último elemento.
     */
    public void end( );
}

