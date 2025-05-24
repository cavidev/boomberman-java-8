package Clases;

import javax.swing.JButton;

/**
 *
 * @author Alex
 */
public class Puerta extends GameObject
{
    public JButton puerta;
    
    public Puerta(int columna, int fila) 
    {
        super(columna, fila);               // Se envian los parameyros al constructor de la clase padre
        this.id = "P";                      // Se le asigna un identificador
        this.puerta = new JButton();        // Se le asigna el atributo boton
        this.puerta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/puerta.png")));
        // Se le asigna una imagen al objeto, la imagen se encuentra en el paquete imagenes
    }
}
