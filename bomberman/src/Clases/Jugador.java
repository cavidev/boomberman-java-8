package Clases;

/**
 *
 * @author Carlos Mario
 */
public class Jugador 
{    
    private String nombre;
    private int record;
    private String estado;
    

    public Jugador(String nombre) 
    {
        this.nombre = nombre;
    }

    public int getRecord() 
    {
        return record;
    }

    public String getNombre() 
    {
        return nombre;
    }

    public void setEstado(String estado) 
    {
        this.estado = estado;
    }

    public String getEstado() 
    {
        return estado;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }

    public void setRecord(int record) 
    {
        this.record = record;
    }
}
