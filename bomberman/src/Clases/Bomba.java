package Clases;

import java.util.LinkedList;
import javax.swing.JButton;

/**
 *
 * @author Alex
 */
public class Bomba extends GameObject
{
    public JButton bomb;        // Necesitan de un parametro bloque para que ase puedan posicionar en el frame del escenario
    public boolean activada;    // En el caso de la clase bomba, se necesita de un atributo para saber el momento en que esta se encuentee activada
                                // Esto con el fin de cumplir con un requisito del juego el cual es: solo se podra poner una bomba a la vez
    
    public Bomba(int columna, int fila) 
    {
        super(columna, fila);       // Se envian los parameyros al constructor de la clase padre
        this.id = "b";              // Se le asigna un identificador
        this.activada = true;       // Se activa la bomba ya que, siempre que se cree la bomba va a estar activada para poder detonarse despues
        this.bomb = new JButton();  // Se le asigna el atributo boton y se inhabilita
        this.bomb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/bomba.png")));
        // Se le asigna una imagen al objeto, la imagen se encuentra en el paquete imagenes
    }   
    
    /**
    *   Esta funcion se activa cada vez que la bomba vaya a explotar y lo que hacees, 
    * detectar todos los objetos que se encuentren a su alrededor y guardar tales objetos en una lista
    * para luego, en otra funcion aparte, recorrer la lista he ir elimiando los onjetos del juego
    * solo podra eliminar objetos de tipo bloque, heroe y enemigo
    */
    public void explote(LinkedList<GameObject> lista, GameObject[][] m, Heroe h)
    {
        int x = this.getColumna();int y = this.getFila(); // Asigna a variables la posiion de la bomba
        
        if((x==h.getColumna())   &&    (y==h.getFila())) // Ubicacion de la Bomba
        {
            lista.add(h); // Verifica si el heroe se encuentra sobre la bomba
        }
        if(!m[x][y+1].id.equals("B")) // Abajo 
        {
            lista.add(m[x][y+1]); // Verifica que objetos se encuntran debajo de la bomba y si es un bloque, no lo guarda en la lista de destruccion
                                  // en caso de que sea cualquier otra cosa verifica esta y la posicion de abajo siguiente
            if((m[x][y+1].id.equals("V")) && (!m[x][y+2].id.equals("B"))) // Abajo 2
            {
                lista.add(m[x][y+2]);
                m[x][y+2] = new Vacio(x, y+2);      // Una vez guardado el objeto en lisat de destruccion, coloca un vacio, para que de esta forma el heroe pueda movilizarse por ese lugar
            }
            m[x][y+1] = new Vacio(x, y+1);          // Una vez guardado el objeto en lisat de destruccion, coloca un vacio, para que de esta forma el heroe pueda movilizarse por ese lugar
        }
        if(!m[x][y-1].id.equals("B")) // Arriba
        {   // Realiza las mismas verificaciones de antes solo que es en este caso, verifica los objetos que se encuentran arriba de la bomba 
            lista.add(m[x][y-1]);
            
            if((m[x][y-1].id.equals("V")) && (!m[x][y-2].id.equals("B"))) // Arriba 2
            {
                lista.add(m[x][y-2]);
                m[x][y-2] = new Vacio(x, y-2);
            }
            m[x][y-1] = new Vacio(x, y-1);
        }
        if(!m[x+1][y].id.equals("B")) // Derecha
        {   // Realiza las mismas verificaciones de antes solo que es en este caso, verifica los objetos que se encuentran a la derecha de la bomba 
            lista.add(m[x+1][y]);
            
            if((m[x+1][y].id.equals("V")) && (!m[x+2][y].id.equals("B"))) // Derecha 2
            {
                lista.add(m[x+2][y]);
                m[x+2][y] = new Vacio(x+2, y);
            }
            m[x+1][y] = new Vacio(x+1, y);
        }
        if(!m[x-1][y].id.equals("B")) // Izquierda
        {   // Realiza las mismas verificaciones de antes solo que es en este caso, verifica los objetos que se encuentran del lado izquierdo  de la bomba 
            lista.add(m[x-1][y]);
            
            if((m[x-1][y].id.equals("V")) && (!m[x-2][y].id.equals("B"))) // Izquierda 2
            {
                lista.add(m[x-2][y]);
                m[x-2][y] = new Vacio(x-2, y);
            }
            m[x-1][y] = new Vacio(x-1, y);
        }
    }
}
