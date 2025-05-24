package Clases;

/**
 *
 * @author Alex
 */
public abstract class GameObject
{
    private int fila;       // Coordenada con respecto al eje x
    private int columna;    // Coordenada con respecto al eje Y
    public String id;   // Identificador del Objeto para poder detectar a la hora de implemetacion del juego
    
    /**
    * Constructor de la clase resibe los parametros de la 
    * ubicacion para poder posicionar en la matriz del juego
    */
    public GameObject(int columna, int fila) 
    {
        this.columna = columna;
        this.fila = fila;
        this.id = new String();
    }

    /**
    * Retorna la ubicacion del objeto
    * con respecto al eje Y 
    */
    public int getColumna() 
    {
        return columna;
    }

    /**
    * Modifica la ubicacion del objeto
    * con respecto al eje Y
    */
    public void setColumna(int columna) 
    {
        this.columna = columna;
    }

    /**
    * Retorna la ubicacion del objeto
    * con respecto al eje X
    */
    public int getFila() 
    {
        return fila;
    }

    /**
    * Modifica la ubicacion del objeto
    * con respecto al eje X
    */
    public void setFila(int fila) 
    {
        this.fila = fila;
    }
    
}
