package Inicio;

import Clases.Jugador;
import Interfaz.Escenario;

/**
 *
 * @author Alex
 */
public class Inicio
{    
    public static void main(String[] args) 
    {
        Principal juego = new Principal();
        //Escenario juego = new Escenario(11,11,502,521, 12, 5,new Jugador("Drago"), new Principal());  // Facil
        //Escenario juego = new Escenario(15,15,683,705,23,15,new Jugador("Drago"), new Principal());   // Medio
        //Escenario juego = new Escenario(26,15,1178,705,40,20,new Jugador("Drago"), new Principal());  // Dificil
        juego.setVisible(true);
    }
}
