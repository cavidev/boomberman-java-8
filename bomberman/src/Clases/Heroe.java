package Clases;

import java.awt.event.KeyEvent;
import javax.swing.JButton;

/**
 *
 * @author Alex
 */
public class Heroe extends GameObject
{
    public boolean vida;    // Estos objetos y el heroe son los unicos tienen una vida ya que, esto sirve para ssaber si pueden seguir en el juego o no
    public JButton heroe;   // Necesitan de un parametro bloque para que ase puedan posicionar en el frame del escenario

    public Heroe(int columna, int fila) 
    {
        super(columna, fila);           // Se envian los parameyros al constructor de la clase padre
        this.id = "H";                  // Se le asigna un identificador
        this.vida = true;               // A la hora que se crea la vida esta en true
        this.heroe = new JButton();     // Se le asigna el atributo boton y se inhabilita
        this.heroe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/bomberman.png")));
        // Se le asigna una imagen al objeto, la imagen se encuentra en el paquete imagenes
    } 
    
    /**
    *   En esta funcion se es donde se hace la verifiacadio ce a matriz , para verificar si se puede mover al lugar deseado
    * El heroe solo podra moversen en espacios de la matriz donde se encientren espacios vacios
    * Esta funcion recibe l amatriz y el evento de teclado para verificar cual es el boton que seleciono el usuario
    */
    public void Mover(KeyEvent e, GameObject[][] m)
    {        
        int key = e.getKeyCode();  // Asigna el boton presionado a una variable

        // Hace la verificacion del boton precionado por el usuario
        if ((key == KeyEvent.VK_RIGHT)&&(m[this.getColumna()+1][this.getFila()].id.equals("V")))
        {   // En caso de que se precione la flecha derecha, verifica si en la posicion de la matriz donde se va a mover se encuentra un objeto vacio, en el caso de que haya uno, el heroe si podra moverse, en caso contrario no podra
            m[this.getColumna()][this.getFila()] = new Vacio(this.getColumna(), this.getFila()); // Coloca un vacio en la posicion que se encuentra y luego se mueve a la nueva posicion
            m[this.getColumna()+1][this.getFila()]= this;
            this.setColumna(this.getColumna()+1);
        }
        if ((key == KeyEvent.VK_LEFT)&&(m[this.getColumna()-1][this.getFila()].id.equals("V")))
        {   // En caso de que se precione la flecha derecha, verifica si en la posicion de la matriz donde se va a mover se encuentra un objeto vacio, en el caso de que haya uno, el heroe si podra moverse, en caso contrario no podra
            m[this.getColumna()][this.getFila()] = new Vacio(this.getColumna(), this.getFila()); // Coloca un vacio en la posicion que se encuentra y luego se mueve a la nueva posicion
            m[this.getColumna()-1][this.getFila()]= this;
            this.setColumna(this.getColumna()-1);
        }
        if ((key == KeyEvent.VK_UP)&&(m[this.getColumna()][this.getFila()-1].id.equals("V")))
        {   // En caso de que se precione la flecha derecha, verifica si en la posicion de la matriz donde se va a mover se encuentra un objeto vacio, en el caso de que haya uno, el heroe si podra moverse, en caso contrario no podra
            m[this.getColumna()][this.getFila()] = new Vacio(this.getColumna(), this.getFila()); // Coloca un vacio en la posicion que se encuentra y luego se mueve a la nueva posicion
            m[this.getColumna()][this.getFila()-1]=this;
            this.setFila(this.getFila()-1);
        }
        if ((key == KeyEvent.VK_DOWN)&&(m[this.getColumna()][this.getFila()+1].id.equals("V")))
        {   // En caso de que se precione la flecha derecha, verifica si en la posicion de la matriz donde se va a mover se encuentra un objeto vacio, en el caso de que haya uno, el heroe si podra moverse, en caso contrario no podra
            m[this.getColumna()][this.getFila()] = new Vacio(this.getColumna(), this.getFila()); // Coloca un vacio en la posicion que se encuentra y luego se mueve a la nueva posicion
            m[this.getColumna()][this.getFila()+1]=this;
            this.setFila(this.getFila()+1);
        }  
    }
}
