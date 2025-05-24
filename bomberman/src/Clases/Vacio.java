package Clases;

/**
 *
 * @author Alex
 */
public class Vacio extends GameObject
{ 
    public Vacio(int columna, int fila) 
    {
        super(columna, fila);       // Se envian los parameyros al constructor de la clase padre
        this.id = "V";              // Se le asigna un identificador
    }
}
