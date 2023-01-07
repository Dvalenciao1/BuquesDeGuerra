package buquesdeguerra;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tablero {
    
    private JButton arrayButtons[][] = new JButton[7][6];
    
    public void TableroBlanco(JPanel panel, JLabel JLabelRonda, JLabel JLabelPuntos) {
        Player jugador = new Player();
        for (int i = 0; i < arrayButtons.length; i++) {
            for (int j = 0; j < arrayButtons[i].length; j++) {
                JButton boxLabel = new JButton();
                boxLabel.setText("~");
                boxLabel.setForeground(Color.BLACK);
                boxLabel.setFocusable(false);
                boxLabel.setEnabled(false);
                boxLabel.addActionListener((ActionEvent ae) -> {
                    JButton button = (JButton) ae.getSource();

                    //disparos
                    jugador.setTabla(arrayButtons);
                    jugador.Movimientos(button, JLabelRonda, JLabelPuntos);
                    
                });
                arrayButtons[i][j] = boxLabel;
            }
        }
        
        Barco boat = new Barco(arrayButtons);
        
        boat.crearBarcosAleatorio();
        jugador.setPosiciones(boat.getPosiciones());
        jugador.obtenerInicioFin();
        
        for (int i = 0; i < arrayButtons.length; i++) {
            for (int j = 0; j < arrayButtons[i].length; j++) {
                panel.add(arrayButtons[i][j]);
            }
        }
    }
    
    public void TableroNegro(JPanel panel, JLabel JLabelRonda, JLabel JLabelPuntos) {
        Player jugador = new Player();
        for (int i = 0; i < arrayButtons.length; i++) {
            for (int j = 0; j < arrayButtons[i].length; j++) {
                JButton boxLabel = new JButton();
                boxLabel.setBackground(Color.BLACK);
                boxLabel.setText("~");
                boxLabel.setForeground(Color.BLACK);
                boxLabel.setFocusable(false);
                boxLabel.addActionListener((ActionEvent ae) -> {
                    JButton button = (JButton) ae.getSource();

                    //disparos
                    jugador.setTabla(arrayButtons);
                    jugador.Movimientos(button, JLabelRonda, JLabelPuntos);
                    
                });
                arrayButtons[i][j] = boxLabel;
            }
        }
        
        Barco boat = new Barco(arrayButtons);
        
        boat.crearBarcosAleatorio();
        jugador.setPosiciones(boat.getPosiciones());
        jugador.obtenerInicioFin();
        
        for (int i = 0; i < arrayButtons.length; i++) {
            for (int j = 0; j < arrayButtons[i].length; j++) {
                panel.add(arrayButtons[i][j]);
            }
        }
    }
}
