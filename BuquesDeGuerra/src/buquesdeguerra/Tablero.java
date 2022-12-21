package buquesdeguerra;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Tablero {

    private JButton arrayButtons[][] = new JButton[7][6];

    public void TableroBlanco(JPanel panel) {
        for (int i = 0; i < arrayButtons.length; i++) {
            for (int j = 0; j < arrayButtons[i].length; j++) {
                JButton boxLabel = new JButton();
                boxLabel.setBackground(Color.WHITE);
                boxLabel.addActionListener(new boton());
                boxLabel.setText("[ ]");
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

    private static class boton implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent ae) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

}
