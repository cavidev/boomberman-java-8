package Clases;

import javax.swing.JButton;

/**
 *
 * @author Alex
 */
public class Bloque extends GameObject
{
    public JButton bloque; // Necesitan de un parametro bloque para que ase puedan posicionar en el frame del escenario
    
    public Bloque(int columna, int fila) 
    {
        super(columna, fila);           // Se envian los parameyros al constructor de la clase padre
        this.id = "B";                  // Se le asigna un identificador
        this.bloque = new JButton();    // Se le asigna el atributo boton y se inhabilita
        this.bloque.setEnabled(false);
        this.bloque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/bloque.jpg")));
        // Se le asigna una imagen al objeto, la imagen se encuentra en el paquete imagenes
    }   
}
