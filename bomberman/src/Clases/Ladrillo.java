package Clases;

import javax.swing.JButton;

/**
 *
 * @author Alex
 */
public class Ladrillo extends GameObject
{
    public JButton ladrillo;
    
    public Ladrillo(int columna, int fila) 
    {
        super(columna, fila);               // Se envian los parameyros al constructor de la clase padre
        this.id = "L";                      // Se le asigna un identificador
        this.ladrillo = new JButton();      // Se le asigna el atributo boton y se inhabilita
        this.ladrillo.setEnabled(false);
        this.ladrillo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ladrillo.jpg")));
        // Se le asigna una imagen al objeto, la imagen se encuentra en el paquete imagenes
    }   
}
