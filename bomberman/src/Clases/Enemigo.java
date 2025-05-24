package Clases;

import java.util.Random;
import javax.swing.JButton;

/**
 *
 * @author Alex
 */
public class Enemigo extends GameObject
{
    public boolean vida;    // Estos objetos y el heroe son los unicos tienen una vida ya que, esto sirve para ssaber si pueden seguir en el juego o no
    public JButton enemy;   // Necesitan de un parametro bloque para que ase puedan posicionar en el frame del escenario

    public Enemigo(int columna, int fila) 
    {
        super(columna, fila);   // Se envian los parameyros al constructor de la clase padre
        
        this.id = "E";          // Se le asigna un identificador
        this.vida = true;       // Se le asigna el atributo boton y se inhabilita
        this.enemy = new JButton();
        
        elegirEnemigo();    // Se le asigna una imagen de forma aleatoria 
        
    }

    /**
    *   En esta funcion se seleciona una imagen mediante un aleatorio
    * dependiendo del numero se elige una de las cuatro imagenes asignadas a los enemigos
    */
    private void elegirEnemigo() 
    {
        Random n = new Random();int x = (int) (n.nextDouble()*4); // Se activa el aleatorio
        // Dependiendo del numero se elige una de la imagenes, el aleatorio tiene un rango de 0 a 4
        if      (x==0)  {this.enemy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Enemigos/barril.png")));}
        else if (x==1)  {this.enemy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Enemigos/bola.png")));}
        else if (x==2)  {this.enemy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Enemigos/fantasma.png")));}
        else            {this.enemy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Enemigos/globo.png")));}
    }
}
