package colecciones;

import interfaces.Coleccion;
import interfaces.IteradorLista;
import java.util.Iterator;

public class Lista<T> implements Coleccion<T> {
    private class Nodo {
	public T elemento;
	public Nodo anterior;
	public Nodo siguiente;
	public Nodo(T elemento) {
	    
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
    public void agrega(T elemento) {

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
