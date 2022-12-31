package buquesdeguerra;

import java.util.Arrays;

public class BuquesDeGuerra {
    
    public static void main(String[] args) {
        Barco boat = new Barco();
        boat.crearBarcosAleatorio();
        
        for (int i = 0; i < boat.getTablero().length; i++) {
            System.out.println(Arrays.toString(boat.getTablero()[i]));
        }
//        VentanaPrincipal juego = new VentanaPrincipal();
//        juego.setVisible(true);
    }
    
}
