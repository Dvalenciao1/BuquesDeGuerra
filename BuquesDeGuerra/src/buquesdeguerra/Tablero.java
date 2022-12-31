package buquesdeguerra;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tablero {

    private int rondas = 0;
    public int movimientos = 4;
    private JButton arrayButtons[][] = new JButton[7][6];

    public void TableroBlanco(JPanel panel, JLabel contador) {
        for (int i = 0; i < arrayButtons.length; i++) {
            for (int j = 0; j < arrayButtons[i].length; j++) {
                JButton boxLabel = new JButton();
                boxLabel.setBackground(Color.WHITE);

                boxLabel.addActionListener((ActionEvent ae) -> {
                    JButton button = (JButton) ae.getSource();
                    button.setBackground(Color.yellow);
                    button.setEnabled(false);
                    if (movimientos <= 0) {
                        rondas++;
                        movimientos = 4;
                    } else {
                        movimientos--;
                    }
                    contador.setText(String.valueOf(rondas));
                });
                boxLabel.setText("~");
                arrayButtons[i][j] = boxLabel;
            }
        }

        for (int i = 0; i < arrayButtons.length; i++) {
            for (int j = 0; j < arrayButtons[i].length; j++) {
                panel.add(arrayButtons[i][j]);
            }
        }
    }

    public void TableroNegro(JPanel panel) {
        for (int i = 0; i < arrayButtons.length; i++) {
            for (int j = 0; j < arrayButtons[i].length; j++) {
                JButton boxLabel = new JButton();
                boxLabel.setBackground(Color.BLACK);
                arrayButtons[i][j] = boxLabel;
            }
        }

        for (int i = 0; i < arrayButtons.length; i++) {
            for (int j = 0; j < arrayButtons[i].length; j++) {
                panel.add(arrayButtons[i][j]);
            }
        }
    }
}
