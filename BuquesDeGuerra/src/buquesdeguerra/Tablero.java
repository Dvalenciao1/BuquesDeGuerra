package buquesdeguerra;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tablero {

    private int rondas = 1;
    public int movimientos = 5;
    private JButton arrayButtons[][] = new JButton[7][6];

    public void TableroBlanco(JPanel panel, JLabel contador) {
        for (int i = 0; i < arrayButtons.length; i++) {
            for (int j = 0; j < arrayButtons[i].length; j++) {
                JButton boxLabel = new JButton();
                boxLabel.setBackground(Color.WHITE);
                boxLabel.setEnabled(false);

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

    public void TableroNegro(JPanel panel, JLabel contador) {
        for (int i = 0; i < arrayButtons.length; i++) {
            for (int j = 0; j < arrayButtons[i].length; j++) {
                JButton boxLabel = new JButton();
                boxLabel.setBackground(Color.BLACK);
                boxLabel.setText("~");
                boxLabel.setForeground(Color.BLACK);
                boxLabel.setFocusable(false);
                boxLabel.addActionListener((ActionEvent ae) -> {
                    JButton button = (JButton) ae.getSource();

                    if (movimientos > 0) {
                        movimientos--;
                    } else if (rondas <= 7) {
                        rondas++;
                        if (movimientos <= 0) {
                            movimientos = 5;
                            movimientos--;
                        }
                        contador.setText(String.valueOf(rondas));
                    } else {
                        movimientos = -1;
                    }
                    System.out.println(button.getName());
                    if (button.getText().equals("1") && movimientos > -1) {
                        button.setBackground(Color.yellow);
                        button.setEnabled(false);
                    } else if (button.getText().equals("~") && movimientos > -1) {
                        button.setBackground(Color.red);
                        button.setEnabled(false);
                    }

                });
                arrayButtons[i][j] = boxLabel;
            }
        }

        Barco boat = new Barco(arrayButtons);

        boat.crearBarcosAleatorio();

        for (int i = 0;
                i < arrayButtons.length;
                i++) {
            for (int j = 0; j < arrayButtons[i].length; j++) {
                panel.add(arrayButtons[i][j]);
            }
        }
    }
}
