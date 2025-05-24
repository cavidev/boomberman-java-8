package Interfaz;

import Clases.Bloque;
import Clases.Bomba;
import Clases.Enemigo;
import Clases.GameObject;
import Clases.Heroe;
import Clases.Jugador;
import Clases.Ladrillo;
import Clases.Puerta;
import Clases.Vacio;
import Inicio.Principal;
import java.applet.AudioClip;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Alex
 */
public class Escenario extends javax.swing.JFrame implements KeyListener
{
    private Jugador jugador;
    private Principal ventanaPrincipal;
    
    Timer timer;    // Para llevar el tiempo de las bombas
    int e=45;       // Para regular el tamaño y dstancia de todos lo Gameobjects
    Heroe h;        // El Heroe del juego, para tener un acceso rapido a este
    Puerta p;       // La Puerta, necesaria para ganar el juego
    boolean finJuego=false;         // Bandera para marcar el fin del juego
    Bomba bomb=new Bomba(0, 0);     // La bomba del heroe, solo podra usar esta bomba, y pone una unica bomba a al vez
    LinkedList<GameObject> listaExplote;    // Lista para guardar todos los objetos que la bomba va a destruir
    GameObject[][] Matriz;                  // La Matriz del juego para guardar posiciones de todos los objetos
    
    /**
    *   Esta es el contructor de la calse escenario, la cual recibe el tamaño de la matriz en X y Y
    *  La cantidad de ladrillos dependientdo de la dificultad selecionada por el usuario, al igual que 
    *  la cantidad de enemigos dependen de la dificultad
    */
    public Escenario(int x ,int y , int ancho, int alto, int ladrillos, int enemigos,Jugador jugador1,Principal ventanaP) 
    {
        // Se inicilalizan componentes (En este caso solo el frame, ya que todo se elaboro manualmente) 
        initComponents();
        
        this.setResizable(false);           // Se inhabilita la opcion para que la ventana cambie de tamaño
        this.setSize(ancho, alto);          // Se le da un tamaño
        this.setLocationRelativeTo(null);   // Se posiciona la ventana en el centro de la pantalla
        
        this.jugador = jugador1;            // Se inicializa el jugador, para luego guardar sus datos con repsecto al tiempo de juego, en caso de ganar
        this.ventanaPrincipal = ventanaP;   // Se asigna la variable que se paso por parametro
        
        bomb.activada=false;                            // El juego solo cuenta con una bomba la cual esta asignada a una varible global
        Matriz=new GameObject[x][y];                    // Se crea la matriz con el temaño que se le paso por parametros
        // Se inicializa el timer, el cual se activara y llevara el conteo para saber cuando se debe explotar la bomba
        timer = new Timer(2500, new ActionListener(){      
            public void actionPerformed(ActionEvent e) {
                explote();  // Hace que la bomba explote, llama un conjunto de funciones mas, las cuales se encargaran de elimanr los objetos alcanzados por la bomba
                repaint();  // Actualiza la ventana, ya sin los objetos que elimino la bomba
                timer.stop(); // Detiene el  timer para que deje de contar el tiempo
            }
        });
        
        montarBloques(x,y);                 // Coloca los objetos de tipo bloques que no se pueden romper en el Frame y en la matriz
        colocarHeroe();                     // Posiciona y coloca al heroe del juego en la posicion inicial        
        montarLadrillos(x,y,ladrillos);     // Coloca de manera aleatoria todos los ladrillos del juego
        montarEnemigos(x,y,enemigos);       // Coloca de manera aleatoria todos los enemigos del juego
        
        repaint(); // Se hace un repaint en el frame para que se vizualicen todos los objetos que se aregaron
        
        // Se habilita el frame para que capte eventos de boton
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() 
        {@Override
            public boolean dispatchKeyEvent(KeyEvent i) {keyReleased(i);return false;}
        });
    }
    
    /**
    *  Esta funcion posiciona los bloques, los objetos que marcan el limite del escenario
    * y los unicos que no se destruyen por las bomba, coloca los bloque de uno por medio
    */
    public void montarBloques(int tamaño1, int tamaño2)
    {
        for (int i = 0; i < tamaño2; i++) // Dependiendo del tamaño que ya se le paso por parametro
        {
            for (int j = 0; j < tamaño1; j++) 
            {
                if((i==0)||(j==0)||(i==tamaño2-1)||(j==tamaño1-1)||((esPar(i)==true)&&(esPar(j)==true)))
                {
                    Bloque b = new Bloque(j, i);
                    b.bloque.setBounds(j*e, i*e, 45, 45);
                    this.add(b.bloque);
                    
                    Matriz[j][i]=b;
                }
                else
                {
                    Vacio v = new Vacio(j, i);
                    Matriz[j][i]=v;
                }
            }
        }
    }
    
    /**
     *  Coloca al heroe en la posicion inicial
     */
    public void colocarHeroe()
    {
        h = new Heroe(1, 1);Matriz[1][1]=h; // Le asigan los valores al heroe mediante el contructor y lo posiciona en la matriz
        h.heroe.setBounds(1*e, 1*e, 45, 45);this.add(h.heroe); // Se le asigna un tamaño, el cual siempre sera el mismo para todos los objetos
    }
    
    /**
    *  Esta funcion posiciona los Ladrillos, los objetos que le impiden el paso al heroe y los enemigos
    * y los que pueden ser eliminados mediante la explocion de la bomba
    */
    public void montarLadrillos(int cantidad1, int cantidad2, int ladrillos)
    {
        int i = 0;  // Mediante un contador va colocando ladrilos de forma aleatoria
                    // en el moemnto que alcance el limiteque es el umero enviado por parametro multiplicado por 2
        
        while(i<ladrillos*2) // Se genera un ciclo para llevar el conteo
        {
            Random x = new Random();Random y = new Random(); // Se generan 2 random para elegir una ubicacion aleatoria, el randon correspondfera a las posicon X y Y de los objetos
            int X = (int) (x.nextDouble()*cantidad1-1)+1;int Y = (int) (y.nextDouble()*cantidad2-1)+1; // Se pasan a interger y se les pone un limite
            
            String id = Matriz[X][Y].id; // Una vez con la posicion, se ubica en al matriz y guarda en una variable el id del ogjeto que ahi se encuentre
            if(id.equals("V") && ((X+Y)>3)) // Solo colocara un ladrillo en el lugar donde se encuentre un objeto vacio 
            {
                Ladrillo l = new Ladrillo(X, Y);
                l.ladrillo.setBounds(X*e, Y*e, 45, 45);
                this.add(l.ladrillo);
                Matriz[X][Y]=l;
                i++; // Solo aumenta el contador cada vez que coloque un ladrillo
                if(i==ladrillos) // En el moemnto que el contador se igua que el parametro, se coloca la puerta para que tambien que de forna aleatoria
                {p=new Puerta(X, Y);p.puerta.setBounds(X*e, Y*e, 45, 45);this.add(p.puerta);}
            }
        }
    }
    
    /**
    *   Al igual que la funcion anterior posiciona los objetos de forma aleatoria en la matriz
    *  en este caso coloca a los enimgos
     */
    public void montarEnemigos(int cantidad1, int cantidad2, int E)
    {
        int i = 0;
        while(i<E)
        {
            Random x = new Random();Random y = new Random(); // Se generan 2 random para elegir una ubicacion aleatoria, el randon correspondfera a las posicon X y Y de losnobjetos
            int X = (int) (x.nextDouble()*cantidad1-1)+1;int Y = (int) (y.nextDouble()*cantidad2-1)+1; // Se pasan a interger y se les pone un limite
            
            String id = Matriz[X][Y].id;
            if(id.equals("V") && ((X+Y)>3)) // Solo colocara un enemigo en el lugar donde se encuentre un objeto vacio 
            {
                Enemigo enemy = new Enemigo(X, Y);
                enemy.enemy.setBounds(X*e, Y*e, 45, 45);
                this.add(enemy.enemy);
                Matriz[X][Y]=enemy;
                i++;    // Solo aumenta el contador cada vez que coloque un enemigo
            }
        }
    }
    
    /**
     * @param numero
     * @return falso en el caso que no sea par y truen el caso que si lo sea
     */
    public boolean esPar(int numero){if (numero%2==0) return true; else return false;}
    
    /**
     *  En esta funcion se activa el metodo del objet bomba en el cual se verifican 
     *  y añaden todos los objetos que se puden destruir en la lista de destruccion
     */
    public void explote()
    {
        bomb.explote(listaExplote=new LinkedList<GameObject>(), Matriz, h);    destruir(); // Activa el metodo de la bomba y luego llama destruir que elima a los objetos del frame
        
        Matriz[bomb.getColumna()][bomb.getFila()]= new Vacio(bomb.getColumna(), bomb.getFila()); // Coloca un vacio donde estaba la bomba
        this.remove(bomb.bomb); // Y luego pasa a eliminar la bomba del frame
        
        AudioClip sonidoJuego = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Explosion.mid")); //  Activa el sonido de explocion
        sonidoJuego.play(); // Lo ejecuta (Hace que suene)
        
        bomb.activada=false; // Pasa de nuevo el atributo de la bomba a false para que se pueda colcar una nueva bomba
    }
    
    /**
     *  Recorre la lista de destruccion y va eliminando del frame los objetos
     */
    public void destruir()
    {
        for (int i = 0; i < listaExplote.size(); i++) 
        {
            if(listaExplote.get(i).id.equals("L"))      // En el caso de que sea un ladrillo, lo elimina
            {
                Ladrillo temp = (Ladrillo) listaExplote.get(i);
                this.remove(temp.ladrillo);
            } 
            else if(listaExplote.get(i).id.equals("E")) // En el caso de que sea un enemigo, lo elimina
            {
                Enemigo temp = (Enemigo) listaExplote.get(i);
                this.remove(temp.enemy);
            }
            else if(listaExplote.get(i).id.equals("H")) // En el caso de que sea el heroe, finaliza el juego
            {
                gameOver("LOSE"); // Funcion que finaliza el juego dependientpo del paramtro que se le envie (LOSE: se perdio el juego, WIN: has ganado)
            } 
        }
    }
    
    /**
     *  Dependiendo del parametro que se le envie, finaliza el juego en gane o perdida
     * @param fin 
     */
    public void gameOver(String fin)
    {
        if(fin.equals("LOSE"))
        {
            finJuego=true;
            remove(h.heroe);
            JOptionPane.showMessageDialog(null, "Juego Terminado \nHaz Perdido", "Atencion", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        }
        else if(fin.equals("WIN"))
        {
            finJuego=true;
            remove(h.heroe);
            JOptionPane.showMessageDialog(null, "Enhorabuena \nHaz Ganado", "Felicitaciones", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        }        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    
    // Aqui van los eventos de boton
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent i) 
    {
        int key = i.getKeyCode();
        
        if ((key == KeyEvent.VK_SPACE)&&(bomb.activada==false))
        {
            if( (p.getColumna()==h.getColumna())  &&  (p.getFila()==h.getFila()))
            {
                gameOver("WIN");
            }
            else
            {
                bomb.activada=true;
                bomb = new Bomba(h.getColumna(), h.getFila());
                bomb.bomb.setBounds(h.getColumna()*e, h.getFila()*e, 45, 45);
                Matriz[h.getColumna()][h.getFila()] = bomb;
                this.add(bomb.bomb);

                timer.start();
            }
        }else{
            h.Mover(i, Matriz);
            h.heroe.setBounds(h.getColumna()*e, h.getFila()*e, 45, 45);
        }
        repaint();        
    }
}
